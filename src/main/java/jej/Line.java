package jej;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line {
    private Point A;
    private Point B;

    public double len(){
        return VectorFunc.lenght(this);
    }

    public void draw(GraphicsContext gc, Color color){
        gc.setStroke(color);
        gc.strokeLine(A.getX(), A.getY(), B.getX(), B.getY());
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Line(Point a, Point b) {
        A = a;
        B = b;
    }
}
