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
    private Circle sun, mercury, venus, earth, moon, mars, jupiter, saturn, ring, uranus, neptune;
    private Pane pane;
    private Scene scene;

    @Override
    public void start(Stage stage){
        pane = new Pane(); // Creates a layout to hold nodes
        scene = new Scene(pane, 900, 800, Color.BLACK);
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
        text.layoutYProperty().bind(pane.heightProperty().multiply(.98));
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
        venus.setRadius(9);
        venus.setFill(Color.SANDYBROWN);
        venus.setStroke(Color.BEIGE);

        earth = new Circle();
        earth.setRadius(11);
        earth.setFill(Color.DEEPSKYBLUE);
        earth.setStroke(Color.GREEN);
        earth.setStrokeWidth(2);

        moon = new Circle();
        moon.setRadius(3);
        moon.setFill(Color.GREY);
        moon.setStroke(Color.DARKGRAY);

        mars = new Circle();
        mars.setRadius(7);
        mars.setFill(Color.DARKORANGE);
        mars.setStroke(Color.ORANGERED);

        jupiter = new Circle();
        jupiter.setRadius(22);
        jupiter.setFill(Color.ORANGERED);
        jupiter.setStroke(Color.DARKORANGE);

        saturn = new Circle();
        saturn.setRadius(18);
        saturn.setFill(Color.SANDYBROWN);
        saturn.setStroke(Color.BLACK);
        saturn.setStrokeWidth(3.5);

        ring = new Circle();
        ring.setRadius(20);
        ring.setFill(Color.BLACK);
        ring.setStroke(Color.SADDLEBROWN);
        ring.setStrokeWidth(6);

        uranus = new Circle();
        uranus.setRadius(15);
        uranus.setFill(Color.AQUA);
        uranus.setStroke(Color.BLUE);

        neptune = new Circle();
        neptune.setRadius(15);
        neptune.setFill(Color.BLUE);
        neptune.setStroke(Color.DARKBLUE);

        pane.getChildren().add(ring); // adding saturn's ring first so it can go behind saturn
        pane.getChildren().addAll(sun,mercury,venus,earth,moon,mars,jupiter,saturn,uranus,neptune);
    }
    private void animate(){
        final long startTime = System.nanoTime(); // stores starting time
        // Each tick updates the x & y coordinate of each planet so it appears to
        // revolve around the Sun. Each planet has a circular orbit here
        // even though the actual orbit is elliptical in most cases
        AnimationTimer at = new AnimationTimer(){
            @Override
            public void handle(long now) {
                // each body has a different speed of orbit, so they update at different rates
                // I actually looked up each planet's time of revolution and adjusted
                // the tick rates based on Earth's base tick rate
                double t1 = (now - startTime) / 480000000.0;
                double t2 = (now - startTime) / 1240000000.0;
                double t3 = (now - startTime) / 2000000000.0; // ticks 64 times per second
                double t4 = (now - startTime) / 600000000.0;
                double t5 = (now - startTime) / 3600000000.0;
                double t6 = (now - startTime) / 24000000000.0;
                double t7 = (now - startTime) / 59000000000.0;
                double t8 = (now - startTime) / 164000000000.0;
                double t9 = (now - startTime) / 330000000000.0;

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
                // jupiter coordinates
                double x6 = sun.getCenterX() + 240 * Math.cos(t6);
                double y6 = sun.getCenterY() + 240 * Math.sin(t6);
                // saturn coordinates
                double x7 = sun.getCenterX() + 310 * Math.cos(t7);
                double y7 = sun.getCenterY() + 310 * Math.sin(t7);
                // uranus coordinates
                double x8 = sun.getCenterX() + 350 * Math.cos(t8);
                double y8 = sun.getCenterY() + 350 * Math.sin(t8);
                // neptune coordinates
                double x9 = sun.getCenterX() + 400 * Math.cos(t9);
                double y9 = sun.getCenterY() + 400 * Math.sin(t9);
                // setting respective X and Y coordinates for each body
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
                jupiter.setCenterX(x6);
                jupiter.setCenterY(y6);
                ring.setCenterX(x7);// has the same tick rate as saturn so they move together
                ring.setCenterY(y7);
                saturn.setCenterX(x7);
                saturn.setCenterY(y7);
                uranus.setCenterX(x8);
                uranus.setCenterY(y8);
                neptune.setCenterX(x9);
                neptune.setCenterY(y9);
            }
        };
        at.start();
    }
    public static void main(String[] args){ Application.launch(args);}
}