import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class EarthRevolution extends Application {
  @Override
  public void start(Stage primaryStage){
    Pane pane = new Pane(); // Creates a layout to hold nodes (circles)

    Circle sun = new Circle(); // Creates circle from javafx shapes class
    sun.centerXProperty().bind(pane.widthProperty().divide(2)); // sets X coordinate
    sun.centerYProperty().bind(pane.heightProperty().divide(2)); // sets Y coordinate
    sun.setRadius(50); // sets radius
    sun.setFill(Color.YELLOW); // Color of the inside
    sun.setStroke(Color.ORANGE); // Color of the outline

    Circle earth = new Circle(); // Creates a circle for Earth
    earth.setRadius(10);
    earth.setFill(Color.BLUE); // Earth is filled with water so Blue
    earth.setStroke(Color.GREEN); // There's still some land so some Green

    pane.getChildren().addAll(sun,earth); // Adds circles to Pane

    // Creates a Scene, using layout of Pane with dimensions 400x400
    Scene scene = new Scene(pane, 500, 500);
    primaryStage.setTitle("Earth's Revolution"); // Sets Title
    primaryStage.setScene(scene); // Adds Scene to window
    primaryStage.show(); // Actually displays the window

    final long startTime = System.nanoTime(); // stores starting time
    // creating an anonymous to extend the AnimationTimer class
    // each tick updates the x & y coordinate of Earth so it appears to
    // revolve around the Sun. It's a circular orbit here, even thought
    // the real one is elliptical
      new AnimationTimer(){
        @Override
        public void handle(long now) {
          double t = (now - startTime) / 1000000000.0; // ticks 128 times per second
          // never thought I'd see the day where trig came in handy
          double x = sun.getCenterX() + 128 * Math.cos(t); // new x coordinate for Earth
          double y = sun.getCenterY() + 128 * Math.sin(t); // new y coordinate for Earth

          earth.setCenterX(x);
          earth.setCenterY(y);
        }
      }.start();
  }
  public static void main(String[] args){ Application.launch(args);}
}
