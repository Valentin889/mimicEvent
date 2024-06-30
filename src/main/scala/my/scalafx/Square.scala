package my.scalafx

class Square(x: Int, y: Int, var visitable: Boolean) {
  var neighbors: List[Square] = List()

  // Define how to add a neighbor
  def addNeighbor(neighbor: Square): Unit = {
    neighbors = neighbor :: neighbors
  }

  def getX = x
  def getY = y
}
