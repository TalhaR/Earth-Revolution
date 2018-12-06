import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Display {
    static Circle sun, mercury, venus, earth, moon, mars, jupiter, saturn, ring, uranus, neptune;

    static void addText(){
        Text text = new Text("[Not drawn to scale]");
        text.setFont(Font.font("Comic Sans", 14));
        text.setFill(Color.WHITE);
        // centers the text to the middle, regardless of resizing
        text.layoutXProperty().bind(Launcher.scene.widthProperty().subtract(text.prefWidth(0)).divide(2));
        // want the text to be at the bottom to not interfere with the animation
        text.layoutYProperty().bind(Launcher.pane.heightProperty().multiply(.98));
        Launcher.pane.getChildren().add(text);
    }
    static void createBodies(){
        sun = new Circle(); // Creates circle from javafx shapes class
        sun.centerXProperty().bind(Launcher.pane.widthProperty().divide(2)); // sets X coordinate
        sun.centerYProperty().bind(Launcher.pane.heightProperty().divide(2)); // sets Y coordinate
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

        Launcher.pane.getChildren().add(ring); // adding saturn's ring first so it can go behind saturn
        Launcher.pane.getChildren().addAll(sun,mercury,venus,earth,moon,mars,jupiter,saturn,uranus,neptune);
    }
}