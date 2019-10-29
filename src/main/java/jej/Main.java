package jej;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        List<Point> blackPoints = new LinkedList<>();
        List<Point> redPoints = new LinkedList<>();

        blackPoints.add(new BlackPoint(100, 150));
        blackPoints.add(new BlackPoint(100, 200));
        blackPoints.add(new BlackPoint(150, 170));
        blackPoints.add(new BlackPoint(200, 100));
        blackPoints.add(new BlackPoint(200, 200));

        redPoints.add(new RedPoint(300,100));
        redPoints.add(new RedPoint(320,150));
        redPoints.add(new RedPoint(300,200));
        redPoints.add(new RedPoint(400,200));
        redPoints.add(new RedPoint(200,90));
        //redPoints.add(new RedPoint(180,180));

        for (Point b:blackPoints ) {
            b.draw(gc);
        }
        for (Point r: redPoints ) {
            r.draw(gc);
        }

//        Shape shape = new Shape();
//        shape.makeByList(blackPoints);
//        shape.draw(gc);
        Invoker.drawLine(blackPoints, redPoints, gc);

//
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.show();
    }
}