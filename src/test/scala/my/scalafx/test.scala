
import org.scalatest.funsuite.AnyFunSuite
import my.scalafx.Board

class Test extends AnyFunSuite {
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