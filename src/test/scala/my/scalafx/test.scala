
import org.scalatest.funsuite.AnyFunSuite
import my.scalafx.Board

class Test extends AnyFunSuite {
  val gridWidth = 7
  val gridHeight = 7

  test("test 1") {
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
        assertResult(7) {
          b.d(b.squares(3)(3), 1, set)
        }
     }
    }


  }

  test("test 2") {
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
        assertResult(7) {
          b.d(b.squares(3)(3), 2, set)
        }
     }
    }


  }

  test("test 3") {
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
      assertResult(Int.MinValue) {
       b.d(b.squares(3)(3), 1, set)
      }
     }
    }


  }

  test("test 4") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 2, set)
      }
     }
    }


  }

  test("test 5") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 3, set)
      }
     }
    }


  }

  test("test 6") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 3, set)
      }
     }
    }


  }

  test("test 7") {
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
      assertResult(2) {
       b.d(b.squares(3)(3), 2, set)
      }
     }
    }


  }

  test("test 8") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 1, set)
      }
     }
    }


  }

  test("test 9") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 2, set)
      }
     }
    }


  }
 
  test("test 10") {
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
      assertResult(7) {
       b.d(b.squares(3)(3), 3, set)
      }
     }
    }


  }


}