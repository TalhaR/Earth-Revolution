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
    static Pane pane;
    static Scene scene;

    @Override
    public void start(Stage stage){
        pane = new Pane(); // Creates a layout to hold nodes
        scene = new Scene(pane, 1024, 720, Color.BLACK); // 720p resolution
        Display.createBodies(); // Creates Circles for each celestial body
        Display.addText(); // Displays text to show not to scale

        stage.setTitle("Solar System");
        stage.setScene(scene); // Adds Scene to window
        stage.show(); // Actually displays the window

        Animation.animate();
    }
    public static void main(String[] args){ Application.launch(args);}
}