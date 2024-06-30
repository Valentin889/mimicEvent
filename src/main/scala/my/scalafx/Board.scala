package my.scalafx


class Board(rows: Int, cols: Int) {
  // Create a 2D array of squares
  val squares: Array[Array[Square]] = Array.tabulate(rows, cols)((x, y) => new Square(x, y, visitable = true))

  // Initialize neighbors for each square
  for {
    x <- 0 until rows
    y <- 0 until cols
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
    // algo logic

    // Find all connected sets of visitable squares
    val connectedSets = createConnectedSet()
    
    // Find all combinations of 10 squares to remove that enclose at least one square

    
    val combinations = findCombinations(10)
    println("valide combinaison length" + combinations.length)
    printConnectedSets(combinations.toList)
    
    /* 
    */
    // 

  }


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
