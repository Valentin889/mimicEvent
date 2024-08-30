package my.scalafx


class Board(rows: Int, cols: Int) {
  // Create a 2D array of squares
  val squares: Array[Array[Square]] = Array.tabulate(rows, cols)((x, y) => new Square(x, y, visitable = true))

  var memory: Map[(Square, Int, Set[Square]), (Int, List[Square])] = Map()
  var memory2: Map[(Int, Set[Square]), (Int, List[Square])] = Map()
  var memoryHitj0 = 0
  var memoryHitj1 = 0
  var memoryHitj2 = 0
  var memoryHitj3 = 0
  var memoryHitj4 = 0
  var memoryHitj5 = 0
  var memoryHitj6 = 0
  var memoryHitj7 = 0
  var memoryHitj8 = 0
  var memoryHitj9 = 0

  // Initialize neighbors for each square
  for {
    x <- 1 until rows-1
    y <- 1 until cols-1
  } {
    val currentSquare = squares(x)(y)
    

    val potentialNeighbors = if (x % 2 == 0) {
      Seq(
        (x - 1, y - 1), (x, y - 1), (x + 1, y - 1),
        (x - 1, y), (x, y + 1), (x + 1, y)
      )

    } else {
      Seq(
        (x - 1, y), (x, y - 1), (x + 1, y),
        (x - 1, y + 1), (x, y + 1), (x + 1, y + 1)
      )
    }
        
    // Filter valid neighbors and add to the list
    potentialNeighbors.foreach {
      case (nx, ny) if nx >= 0 && ny >= 0 && nx < rows && ny < cols =>
        currentSquare.addNeighbor(squares(nx)(ny))
      case _ => // Out of bounds, do nothing
  
    }
  }
  

  // Method to get a square
  def getSquare(x: Int, y: Int): Option[Square] = {
    if (x >= 0 && y >= 0 && x < rows && y < cols) Some(squares(x)(y))
    else None
  }

  def createConnectedSet(s:  Array[Array[Square]] = squares): List[Set[Square]] = {

    // BFS to find all connected visitable squares
    def bfs(start: Square): Set[Square] = {
      var visited = Set[Square]()
      val queue = scala.collection.mutable.Queue[Square]()

      queue.enqueue(start)
      visited += start

      while (queue.nonEmpty) {
        val current = queue.dequeue()
        for (neighbor <- current.neighbors) {
          if (neighbor.visitable && !visited.contains(neighbor)) {
            queue.enqueue(neighbor)
            visited += neighbor
          }
        }
      }

      visited
    }

    // Create a list to store connected sets
    var connectedSets: List[Set[Square]] = List()

    // Iterate through all squares
    for {
      x <- 0 until rows
      y <- 0 until cols
      } {
      val currentSquare = s(x)(y)
      if (currentSquare.visitable) {
    
        var isVisited = false

        for (s <- connectedSets) {
          if (s.contains(currentSquare)) {
            isVisited = true
          }
        }

        if (!isVisited) {
          var set = bfs(currentSquare)
          connectedSets = set :: connectedSets
        }
      }
    }
    
    connectedSets

    
  }

  def recreateConnectedSet(s: Array[Array[Square]] = squares, current: Square) = {
    var visited = Set[Square]()
    val queue = scala.collection.mutable.Queue[Square]()

    queue.enqueue(current)
    visited += current

    while (queue.nonEmpty) {
      val current = queue.dequeue()
      for (neighbor <- current.neighbors) {
        if (neighbor.visitable && !visited.contains(neighbor)) {
          queue.enqueue(neighbor)
          visited += neighbor
        }
      }
    }

    visited
  }

  def isSetClosed(set: Set[Square]): Boolean = {
    for {
      square <- set
    } {
      if (square.getX == 0 || square.getX == rows - 1 || square.getY == 0 || square.getY == cols - 1) {
        return false
      }
    }
    true
  }

  def findCombinations(x: Int): Seq[Set[Square]] = {
    // Helper to check if a combination encloses at least one visible square
    def enclosesVisibleSquare(combination: Set[Square]): Boolean = {
      // Implement your logic here. This is a stub returning true for demonstration purposes.
      for {
        square <- combination
      } {
        squares(square.getX)(square.getY).visitable = false
      }

      
      val connectedSets = createConnectedSet()
      val square = combination.head
      for {
        s <- connectedSets
      } {
        if (isSetClosed(s)) {
          for {
            square <- combination
          } {
            squares(square.getX)(square.getY).visitable = true
          }
          return true
        }
      }
      for {
        square <- combination
      } {
        squares(square.getX)(square.getY).visitable = true
      }
      false
    }

    val allVisitableSquares = for {
      x <- 0 until rows
      y <- 0 until cols
      square <- getSquare(x, y) if square.visitable
    } yield square
    
    println("allVisitable length " + allVisitableSquares.length)


    // Generate all possible combinations of size `x`
    val combinations = allVisitableSquares.combinations(x).toSeq.map(_.toSet)

    println("combinations length " + combinations.length)

    // Filter combinations based on the provided criteria
    combinations.filter { combination =>
      enclosesVisibleSquare(combination)
    }
  }


  def reset(): Unit = {
    for {
      x <- 0 until rows
      y <- 0 until cols
    } {
      squares(x)(y).visitable = true
    }
  }

  def start(): Unit = {
    memory = Map()
    memory2 = Map()
    // algo logic

    // Find all connected sets of visitable squares
    val connectedSets = createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(squares(3)(3))) {
        val finalVal = d(squares(3)(3), 1, set, List())
        println(finalVal._1)
        for {
          square <- finalVal._2
        } {
          println(s"Square x: ${square.getX} y: ${square.getY}")
        }
     }
    }

  }

  def d(sq: Square, j:Int, s: Set[Square], moves: List[Square]): (Int, List[Square]) = {
  
    //println("Try with sq: "+ sq.getX + "/" + sq.getY + " j: " + j)
    
    val mem = memory.get((sq, j, s))
    mem match {
      case Some(value) =>
        j match {
          case 0 => 
            memoryHitj0 += 1
            if (memoryHitj0 % 100000 == 0){
              //println("j0 Memory hit " + memoryHitj0)
            }
          case 1 => 
            memoryHitj1 += 1
            if (memoryHitj1 % 100000 == 0){
              println("j1 Memory hit " + memoryHitj1)
            }
          case 2 => 
            memoryHitj2 += 1
            if (memoryHitj2 % 100000 == 0){
              println("j2 Memory hit " + memoryHitj2)
            }
          case 3 =>
            memoryHitj3 += 1
             if (memoryHitj3 % 100000 == 0){
              println("j3 Memory hit " + memoryHitj3)
            }
          case 4 => 
            memoryHitj4 += 1
             if (memoryHitj4 % 100000 == 0){
              println("j4 Memory hit " + memoryHitj4)
            }
          case 5 =>
            memoryHitj5 += 1
            if (memoryHitj5 % 100000 == 0){
            println("j5 Memory hit " + memoryHitj5)
            }
          case 6 =>
            memoryHitj6 += 1
             if (memoryHitj6 % 100000 == 0){
              println("j6 Memory hit " + memoryHitj6)
            }
          case 7 =>
            memoryHitj7 += 1
             if (memoryHitj7 % 100000 == 0){
              println("j7 Memory hit " + memoryHitj7)
            }
          case 8 =>
            memoryHitj8 += 1
             if (memoryHitj8 % 100000 == 0){
              println("j8 Memory hit " + memoryHitj8)
            }
          case 9 =>
            memoryHitj9 += 1
             if (memoryHitj9 % 100000 == 0){
              println("j9 Memory hit " + memoryHitj9)
            }
        }
        
        return value
      case None => 
    }
      

    val x = sq.getX
    val y = sq.getY
    if (x==0 || y==0 || x==rows-1 || y==cols-1 || (j==0 && !isSetClosed(s))) {
      memory += ((sq, j, s) -> (Int.MinValue, List()))
      return (Int.MinValue, List())
    }

    if (j>=0 && isSetClosed(s)) {
      //println("Return with size : " + s.size + " and moves size: " + moves.size)
      memory += ((sq, j, s) -> (s.size, moves))
      return (s.size, moves)
    }
    
    var max = Int.MinValue
    var newMovesMax = moves
    for {
      square <- s
    } {
      if (square.getX != x || square.getY != y) {
        //println("Try to remove square: " + square.getX + "/" + square.getY + " and j is "+ j)
        var min = Int.MaxValue
        var newMovesMin = moves
        var nextMove : Square = null
        for {
          neighbor <- sq.neighbors
        } {
          if (neighbor.visitable && s.contains(neighbor) && neighbor != square) {
            if (nextMove == null) {
              nextMove = neighbor
            } else if (neighbor.getY > nextMove.getY) {
              nextMove = neighbor
            } else if (neighbor.getY == nextMove.getY){
              if (neighbor.getX > nextMove.getX) {
                nextMove = neighbor
              }
            }
          }
        }
        if (nextMove != null) {
          //println("Next move is: " + nextMove.getX + "/" + nextMove.getY)
          square.visitable = false
          var newSet: Set[Square] = recreateConnectedSet(squares, nextMove)
          /*
            for {
              connectedSets <- createConnectedSet(squares)
            } {
              if (connectedSets.contains(sq)) {
                newSet = connectedSets
              }
            }
          */

          val temp = d(nextMove, j-1, newSet, moves :+ square)
          if (temp._1 > max) {
            max = temp._1
            newMovesMax = temp._2
          } else if (temp._1 == max && temp._2.size < newMovesMax.size) {
            max = temp._1
            newMovesMax = temp._2
          }
          square.visitable = true
        }

        /*
        for {
          neighbor <- sq.neighbors
        } {
          square.visitable = false
          
          if (s.contains(neighbor) && neighbor.visitable) {
            var newSet = s - square
            for {
              s <- createConnectedSet(squares)
            } {
              if (s.contains(sq)) {
                newSet = s
              }
            }
            val temp = d(neighbor, j-1, newSet, moves :+ square)
            if (temp._1 < min) {
              min = temp._1
              newMovesMin = temp._2
            } else if (temp._1 == min && temp._2.size < newMovesMin.size) {
              min = temp._1
              newMovesMin = temp._2
            }
          }
          square.visitable = true
        }        
        if (min > max) {
          max = min
          newMovesMax = newMovesMin
        } else if (min == max && newMovesMin.size < newMovesMax.size) {
          max = min
          newMovesMax = newMovesMin
        }
          */
      }
    }

    //println("End Return with size : " + max + " and moves size: " + newMovesMax.size)
    memory += ((sq, j, s) -> (max, newMovesMax))
    return (max, newMovesMax)
  }
    
  
  def computeNextMove(sq: Square, s:Set[Square]): Square = {
    //Find all closest exit

  
    //When multiple choice first go down, left, up, right

    return sq
  }

  def maxSetWithoutCareOfMimic(starting:Square, j: Int, s: Set[Square], moves: List[Square]): (Int, List[Square]) = {
    val mem = memory2.get((j, s))
    mem match {
      case Some(value) => 
        return value
      case None =>
    }

    if (j == 0 && !isSetClosed(s)) {
      memory2 += ((j, s) -> (Int.MinValue, List()))
      return (Int.MinValue, List())
    }

    if (j >= 0 && isSetClosed(s)) {
      memory2 += ((j, s) -> (s.size, moves))
      return (s.size, moves)
    }

    var max = Int.MinValue
    var newMovesMax = moves
    for {
      square <- s
    } {
      if(square.visitable && square != starting) {
        square.visitable = false
        var newSet = s - square
        for {
          s <- createConnectedSet(squares)
        } {
          if (s.contains(starting)) {
            newSet = s
          }
        }

        val tempVal = maxSetWithoutCareOfMimic(starting, j-1, newSet, moves :+ square)
        if (tempVal._1 > max) {
          max = tempVal._1
          newMovesMax = tempVal._2
        } else if (tempVal._1 == max && tempVal._2.size < newMovesMax.size) {
          max = tempVal._1
          newMovesMax = tempVal._2
        }
        square.visitable = true
      }
    }
    memory2 += ((j, s) -> (max, newMovesMax))
    return (max, newMovesMax)
  }

  def maxSetWithoutCareOfMimic2(starting:Square, j: Int, s: Set[Square], moves: List[Square]): (Int, List[Square]) = {
    // Find all set of square you can construct with j moves
    for {
      square <- s
    } {
      if (square.visitable) {
        square.visitable = false
        var newSet = s - square
        for {
          s <- createConnectedSet(squares)
        } {
          if (s.contains(starting)) {
            newSet = s
          }
        }
        val tempVal = maxSetWithoutCareOfMimic2(starting, j-1, newSet, moves :+ square)
        square.visitable = true
      }
    }
    return (0, List())
  }

  /* 
  def n(sq: Square, s:Set[Square]): (Square, Int) = {
    val x = sq.getX
    val y = sq.getY
    if ( x==0 || y==0 || x==rows-1 || y==cols-1 || (j==0 && !isSetClosed(s))) {
      return (sq, 0)
    }
    
    var i = 0
    var sq2 = sq
    for {
      square <- sq.neighbors
    }
    {
      if (s.contains(square)) {
        val temp = n(square, s-sq)
        if (temp._2 > i) {
          i = temp._2
          sq2 = temp._1
        }
        else if (temp._2 == i) {
          // down, left, up, right
          
        }
      }
    }
    
    return (sq2, i)
    
    
  }
  */
  
  
  def printConnectedSets(connectedSets: List[Set[Square]]): Unit = {
  for {
      s <- connectedSets
    } {
      println("new set")
      println(isSetClosed(s))
      for {
        sq <- s
      } println(s"Square x: ${sq.getX} y: ${sq.getY}")
    }






  }
}
