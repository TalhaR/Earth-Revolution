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
    private Circle sun, mercury, venus, earth, mars, moon;
    private Pane pane;
    private Scene scene;

    @Override
    public void start(Stage stage){
        pane = new Pane(); // Creates a layout to hold nodes
        scene = new Scene(pane, 800, 800, Color.BLACK);
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
        venus.setFill(Color.SANDYBROWN);
        venus.setStroke(Color.BEIGE);

        earth = new Circle();
        earth.setRadius(12);
        earth.setFill(Color.BLUE); // Earth is filled with water so Blue
        earth.setStroke(Color.GREEN); // There's still some land so some Green

        moon = new Circle();
        moon.setRadius(3);
        moon.setFill(Color.GREY);
        moon.setStroke(Color.DARKGRAY);

        mars = new Circle();
        mars.setRadius(7);
        mars.setFill(Color.DARKORANGE);
        mars.setStroke(Color.ORANGERED);

        pane.getChildren().addAll(sun,mercury,venus,earth,moon,mars); // Adds circles to Pane
    }
    private void animate(){
        final long startTime = System.nanoTime(); // stores starting time
        // Each tick updates the x & y coordinate of a planet so it appears to
        // revolve around the Sun. Each planet has a circular orbit here
        // even though the actual orbit is elliptical in most cases
        AnimationTimer at = new AnimationTimer(){
            @Override
            public void handle(long now) {
                double t1 = (now - startTime) / 480000000.0;
                double t2 = (now - startTime) / 1240000000.0;
                double t3 = (now - startTime) / 2000000000.0; // ticks 64 times per second
                double t4 = (now - startTime) / 600000000.0;
                double t5 = (now - startTime) / 3600000000.0;

                // never thought I'd see the day where trig came in handy
                double x1 = sun.getCenterX() + 70 * Math.cos(t1); // new x coordinate for Mercury
                double y1 = sun.getCenterY() + 70 * Math.sin(t1); // new y coordinate for Mercury
                // venus coordinates
                double x2 = sun.getCenterX() + 100 * Math.cos(t2);
                double y2 = sun.getCenterY() + 100 * Math.sin(t2);
                // earth coordinates
                double x3 = sun.getCenterX() + 145 * Math.cos(t3);
                double y3 = sun.getCenterY() + 145 * Math.sin(t3);
                // moon coordinates
                double x4 = earth.getCenterX() + 20 * Math.cos(t4); 
                double y4 = earth.getCenterY() + 20 * Math.sin(t4);
                // mars coordinates
                double x5 = sun.getCenterX() + 195 * Math.cos(t5);
                double y5 = sun.getCenterY() + 195 * Math.sin(t5);

                mercury.setCenterX(x1);
                mercury.setCenterY(y1);

                venus.setCenterX(x2);
                venus.setCenterY(y2);

                earth.setCenterX(x3);
                earth.setCenterY(y3);

                moon.setCenterX(x4);
                moon.setCenterY(y4);

                mars.setCenterX(x5);
                mars.setCenterY(y5);
            }
        };
        at.start();
    }
    public static void main(String[] args){ Application.launch(args);}
}