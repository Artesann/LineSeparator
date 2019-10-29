package jej;

import javafx.scene.canvas.GraphicsContext;

abstract class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract public void draw(GraphicsContext gc);

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
