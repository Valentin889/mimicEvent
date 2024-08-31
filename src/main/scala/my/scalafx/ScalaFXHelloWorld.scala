package my.scalafx

import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text
import scalafx.scene.layout.Pane
import scalafx.scene.shape.Polygon
import scalafx.scene.layout.{HBox, Pane, VBox}
import scalafx.scene.control.Button
import scalafx.scene.Group

object ScalaFXHelloWorld extends JFXApp3 {

  // Define constants for hexagon size and grid
  val hexRadius = 30.0
  val gridWidth = 7
  val gridHeight = 7

  val board = new Board(gridWidth, gridHeight)  
  

  // Method to create a hexagon shape
  def createHexagon(x: Double, y: Double, s: Square): Group = {
    val hexagon = new Polygon()
    for (i <- 0 until 6) {
      val angle = Math.toRadians(60 * i)
      val xOffset = hexRadius * Math.cos(angle)
      val yOffset = hexRadius * Math.sin(angle)
      hexagon.getPoints.addAll(x + xOffset, y + yOffset)
    }
    if (s.visitable) {
      hexagon.fill = Color.LightGray
    } else {
      hexagon.fill = Color.Gray
    }
    hexagon.stroke = Color.Gray

    // Add mouse click event handler to toggle color
    hexagon.onMouseClicked = _ => {
      s.visitable = !s.visitable
      if (s.visitable) {
        hexagon.fill = Color.LightGray
      } else {
        hexagon.fill = Color.Gray
      }
    }

    // Create a Group to hold both the hexagon and the text (if any)
    val group = new Group()
    group.children.add(hexagon)

    // If the number is greater than 0, create a Text node to display the number
    if (s.number > 0) {
      val text = new Text(x, y, s.number.toString)
      text.fill = Color.Red // Set text color, adjust as needed
      text.setStyle("-fx-font-size: 14px;") // Adjust font size as needed

      // Center the text inside the hexagon
      text.x = x - text.getBoundsInLocal.getWidth / 2
      text.y = y + text.getBoundsInLocal.getHeight / 4

      group.children.add(text)
    }

    // Return the group containing the hexagon (and text if applicable)
    group
  }

  // Method to calculate hexagon positions and add them to the pane
  def createHexGrid(): Pane = {
    val pane = new Pane()
    for (row <- 0 until gridHeight) {
      for (col <- 0 until gridWidth) {
        val x = (col + 1) * hexRadius * 1.5
        val y = (row + 1) * hexRadius * Math.sqrt(3) + (if (col % 2 == 0) 0 else hexRadius * Math.sqrt(3) / 2)
        val hexagon = createHexagon(x, y, board.getSquare(col, row).get)
        pane.children.add(hexagon)
      }
    }
    pane
  }

  
  override def start(): Unit = {

    val hexGridPane = createHexGrid()
    
    val startButton = new Button("Start")
    val resetButton = new Button("Reset")

    resetButton.onAction = _ => {
      board.reset()
      hexGridPane.children.remove(0, hexGridPane.children.size())
      hexGridPane.children.addAll(createHexGrid().children)
    }

    startButton.onAction = _ => {
      board.start
      hexGridPane.children.remove(0, hexGridPane.children.size())
      hexGridPane.children.addAll(createHexGrid().children)
    }
    
    // Arrange buttons in a horizontal box
    val buttonBox = new HBox(10, resetButton, startButton ) // 10 pixels spacing between buttons
    buttonBox.style = "-fx-alignment: center; -fx-padding: 10;" // Center the buttons and add padding
    
    // Arrange grid and buttons in a vertical box
    val mainLayout = new VBox(10, hexGridPane, buttonBox) // 10 pixels spacing between grid and buttons
    mainLayout.style = "-fx-alignment: center; -fx-padding: 10;" // Center the layout and add padding
    
    stage = new JFXApp3.PrimaryStage  {
      title = "Hexagonal Grid Example"
      scene = new Scene(600, 600) {
        content = mainLayout
      }
    }
  }
  

  /*
  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      //    initStyle(StageStyle.Unified)
      title = "ScalaFX Hello World"
      scene = new Scene {
        fill = Color.rgb(38, 38, 38)
        content = new HBox {
          padding = Insets(50, 80, 50, 80)
          children = Seq(
            new Text {
              text = "Scala"
              style = "-fx-font: normal bold 100pt sans-serif"
              fill = new LinearGradient(
                endX = 0,
                stops = Stops(Red, DarkRed))
            },
            new Text {
              text = "FX"
              style = "-fx-font: italic bold 100pt sans-serif"
              fill = new LinearGradient(
                endX = 0,
                stops = Stops(White, DarkGray)
              )
              effect = new DropShadow {
                color = DarkGray
                radius = 15
                spread = 0.25
              }
            }
          )
        }
      }
    }
  }
    */
}


