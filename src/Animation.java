import javafx.animation.AnimationTimer;

public class Animation {
    static void animate(){
        final long startTime = System.nanoTime(); // stores starting time
        // Each tick updates the x & y coordinate of each planet so it appears to
        // revolve around the Display.sun. Each planet has a circular orbit here
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
                double x1 = Display.sun.getCenterX() + 70 * Math.cos(t1); // new x coordinate for Mercury
                double y1 = Display.sun.getCenterY() + 70 * Math.sin(t1); // new y coordinate for Mercury
                // venus coordinates
                double x2 = Display.sun.getCenterX() + 100 * Math.cos(t2);
                double y2 = Display.sun.getCenterY() + 100 * Math.sin(t2);
                // earth coordinates
                double x3 = Display.sun.getCenterX() + 145 * Math.cos(t3);
                double y3 = Display.sun.getCenterY() + 145 * Math.sin(t3);
                // moon coordinates
                double x4 = Display.earth.getCenterX() + 20 * Math.cos(t4);
                double y4 = Display.earth.getCenterY() + 20 * Math.sin(t4);
                // mars coordinates
                double x5 = Display.sun.getCenterX() + 195 * Math.cos(t5);
                double y5 = Display.sun.getCenterY() + 195 * Math.sin(t5);
                // jupiter coordinates
                double x6 = Display.sun.getCenterX() + 240 * Math.cos(t6);
                double y6 = Display.sun.getCenterY() + 240 * Math.sin(t6);
                // saturn coordinates
                double x7 = Display.sun.getCenterX() + 310 * Math.cos(t7);
                double y7 = Display.sun.getCenterY() + 310 * Math.sin(t7);
                // uranus coordinates
                double x8 = Display.sun.getCenterX() + 350 * Math.cos(t8);
                double y8 = Display.sun.getCenterY() + 350 * Math.sin(t8);
                // neptune coordinates
                double x9 = Display.sun.getCenterX() + 400 * Math.cos(t9);
                double y9 = Display.sun.getCenterY() + 400 * Math.sin(t9);
                // setting respective X and Y coordinates for each body
                Display.mercury.setCenterX(x1);
                Display.mercury.setCenterY(y1);
                Display.venus.setCenterX(x2);
                Display.venus.setCenterY(y2);
                Display.earth.setCenterX(x3);
                Display.earth.setCenterY(y3);
                Display.moon.setCenterX(x4);
                Display.moon.setCenterY(y4);
                Display.mars.setCenterX(x5);
                Display.mars.setCenterY(y5);
                Display.jupiter.setCenterX(x6);
                Display.jupiter.setCenterY(y6);
                Display.ring.setCenterX(x7);// has the same tick rate as saturn so they move together
                Display.ring.setCenterY(y7);
                Display.saturn.setCenterX(x7);
                Display.saturn.setCenterY(y7);
                Display.uranus.setCenterX(x8);
                Display.uranus.setCenterY(y8);
                Display.neptune.setCenterX(x9);
                Display.neptune.setCenterY(y9);
            }
        };
        at.start();
    }
}