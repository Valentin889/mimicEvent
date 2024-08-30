
import org.scalatest.funsuite.AnyFunSuite
import my.scalafx.Board

class TestSimple extends AnyFunSuite {
  val gridWidth = 7
  val gridHeight = 7

  test("test simple a") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
        val finalVal = b.d(b.squares(3)(3), 1, set, List())
        assertResult(7) {
          finalVal._1
        }
        assertResult(1){
          finalVal._2.size
        }
        assertResult(6) {
          finalVal._2(0).getX
        }
        assertResult(4) {
          finalVal._2(0).getY
        }
     }
    }


  }

  test("test simple b") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
        val finalVal = b.d(b.squares(3)(3), 2, set, List())
        assertResult(7) {
          finalVal._1
        }
         assertResult(1){
          finalVal._2.size
        }
        assertResult(6) {
          finalVal._2(0).getX
        }
        assertResult(4) {
          finalVal._2(0).getY
        }
     }
    }


  }

  test("test simple c") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 1, set, List())
      assertResult(Int.MinValue) {
        finalVal._1
      }
      assertResult(0){
        finalVal._2.size
      }
     }
    }


  }

  test("test simple d") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 2, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(2){
        finalVal._2.size
      }

     }
    }


  }

  test("test simple e") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 3, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(2) {
        finalVal._2.size
      }
     }
    }


  }

  test("test simple f") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 3, set, List())
      assertResult(7) {
        finalVal._1
      }
      
      assertResult(3) {
        finalVal._2.size
      }
     }
    }


  }

  test("test simple g") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 2, set, List())
      assertResult(2) {
       finalVal._1
      }
      assertResult(2) {
        finalVal._2.size
      }
     }
    }


  }

  test("test simple h") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 1, set, List())
      assertResult(7) {
        finalVal._1
      }

      assertResult(1) {
        finalVal._2.size
      }
     }
    }


  }

  test("test simple i") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 2, set, List())
      assertResult(7) {
        finalVal._1
      }

      assertResult(1) {
        finalVal._2.size
      }
     }
    }


  }
 
  test("test simple j") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 3, set, List())
      assertResult(7) {
        finalVal._1
      }

      assertResult(1) {
        finalVal._2.size
      }
     }
    }


  }
  
  test("test simple k") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 4, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(1) {
        finalVal._2.size
      }
     }
    }


  }
  
  test("test simple l") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 5, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(1) {
        finalVal._2.size
      }
     }
    }


  }

  test("test simple m") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 6, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(1) {
        finalVal._2.size
      }
     }
    }
  }

  test("test simple n") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(2,2).get.visitable = false
    b.getSquare(2,3).get.visitable = false
    b.getSquare(2,4).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,1).get.visitable = false
    b.getSquare(4,4).get.visitable = false


    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,4).get.visitable = false


    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,2).get.visitable = false
    b.getSquare(6,3).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 10, set, List())
      assertResult(7) {
        finalVal._1
      }
      assertResult(1) {
        finalVal._2.size
      }
     }
    }
  }


}

class TestReal extends AnyFunSuite {
  val gridWidth = 7
  val gridHeight = 7

  test("test real example 1") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(0,4).get.visitable = false
    b.getSquare(0,6).get.visitable = false
    
    b.getSquare(1,0).get.visitable = false
    b.getSquare(1,1).get.visitable = false

    b.getSquare(3,1).get.visitable = false
    b.getSquare(3,4).get.visitable = false

    b.getSquare(4,0).get.visitable = false
    b.getSquare(4,3).get.visitable = false
    b.getSquare(4,6).get.visitable = false

    b.getSquare(5,1).get.visitable = false
    b.getSquare(5,5).get.visitable = false

    b.getSquare(6,1).get.visitable = false
    b.getSquare(6,3).get.visitable = false
    b.getSquare(6,6).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 10, set, List())
      assertResult(13) {
        finalVal._1
      }
      assertResult(10) {
        finalVal._2.size
      }
      for {
        square <- finalVal._2
      } {
        println(square.getX + "/" + square.getY)
      }
     }
    }
  }

  test("test real example 2") {
    val b = new Board(gridWidth, gridHeight)
    b.getSquare(0,1).get.visitable = false
    b.getSquare(0,4).get.visitable = false
    
    b.getSquare(1,1).get.visitable = false
    b.getSquare(1,3).get.visitable = false
    b.getSquare(1,5).get.visitable = false

    b.getSquare(2,0).get.visitable = false

    b.getSquare(3,4).get.visitable = false
    b.getSquare(3,6).get.visitable = false

    b.getSquare(4,3).get.visitable = false

    b.getSquare(5,0).get.visitable = false
    b.getSquare(5,5).get.visitable = false
    b.getSquare(5,6).get.visitable = false

    b.getSquare(6,0).get.visitable = false
    b.getSquare(6,5).get.visitable = false

    val connectedSets = b.createConnectedSet()
    for {
      set <- connectedSets
    } {
     if (set.contains(b.squares(3)(3))) {
      val finalVal = b.d(b.squares(3)(3), 10, set, List())
      for {
        square <- finalVal._2
      } {
        println(square.getX + "/" + square.getY)
      }

      assertResult(13) {
        finalVal._1
      }
      assertResult(10) {
        finalVal._2.size
      }
     }
    }
  }


}