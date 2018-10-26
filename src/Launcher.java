import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application {
    private Circle sun, mercury, venus, earth, mars;
    private Pane pane;
    private Scene scene;

    @Override
    public void start(Stage stage){
        pane = new Pane(); // Creates a layout to hold nodes
        scene = new Scene(pane, 600, 600, Color.BLACK);
        createBodies(); // Creates Circles for each celestial body
        addText(); // Displays text to show not to scale

        stage.setTitle("Solar System");
        stage.setScene(scene); // Adds Scene to window
        stage.show(); // Actually displays the window

        animate();
    }
    private void addText(){
        Text text = new Text("[Not drawn to scale]");
        text.setFont(Font.font("Comic Sans", 14));
        text.setFill(Color.WHITE);
        // centers the text to the middle, regardless of resizing
        text.layoutXProperty().bind(scene.widthProperty().subtract(text.prefWidth(0)).divide(2));
        // want the text to be at the bottom to not interfere with the animation
        text.layoutYProperty().bind(pane.heightProperty().multiply(.95));

        pane.getChildren().add(text);
    }
    private void createBodies(){
        sun = new Circle(); // Creates circle from javafx shapes class
        sun.centerXProperty().bind(pane.widthProperty().divide(2)); // sets X coordinate
        sun.centerYProperty().bind(pane.heightProperty().divide(2)); // sets Y coordinate
        sun.setRadius(45);
        sun.setFill(Color.YELLOW); // Color of the inside
        sun.setStroke(Color.ORANGE); // Color of the outline

        mercury = new Circle();
        mercury.setRadius(5);
        mercury.setFill(Color.ORANGE);
        mercury.setStroke(Color.YELLOW);

        venus = new Circle();
        venus.setRadius(10);
        venus.setFill(Color.LIGHTYELLOW);
        venus.setStroke(Color.BEIGE);

        earth = new Circle();
        earth.setRadius(12);
        earth.setFill(Color.BLUE); // Earth is filled with water so Blue
        earth.setStroke(Color.GREEN); // There's still some land so some Green

        mars = new Circle();
        mars.setRadius(7);
        mars.setFill(Color.DARKORANGE);
        mars.setStroke(Color.ORANGERED);

        pane.getChildren().addAll(sun,mercury,venus,earth,mars); // Adds circles to Pane
    }
    private void animate(){
        final long startTime = System.nanoTime(); // stores starting time
        // Each tick updates the x & y coordinate of a planet so it appears to
        // revolve around the Sun. Each planet has a circular orbit here
        // even though the actual orbit is elliptical in most cases
        AnimationTimer at = new AnimationTimer(){
            @Override
            public void handle(long now) {
                double t = (now - startTime) / 1000000000.0; // ticks 128 times per second
                // never thought I'd see the day where trig came in handy
                double x1 = sun.getCenterX() + 70 * Math.cos(t); // new x coordinate for Mercury
                double y1 = sun.getCenterY() + 70 * Math.sin(t); // new y coordinate for Mercury
                // venus coordinates
                double x2 = sun.getCenterX() + 100 * Math.cos(t);
                double y2 = sun.getCenterY() + 100 * Math.sin(t);
                // earth coordinates
                double x3 = sun.getCenterX() + 135 * Math.cos(t);
                double y3 = sun.getCenterY() + 135 * Math.sin(t);
                // mars coordinates
                double x4 = sun.getCenterX() + 175 * Math.cos(t);
                double y4 = sun.getCenterY() + 175 * Math.sin(t);

                mercury.setCenterX(x1);
                mercury.setCenterY(y1);
                venus.setCenterX(x2);
                venus.setCenterY(y2);
                earth.setCenterX(x3);
                earth.setCenterY(y3);
                mars.setCenterX(x4);
                mars.setCenterY(y4);
            }
        };
        at.start();
    }
    public static void main(String[] args){ Application.launch(args);}
}