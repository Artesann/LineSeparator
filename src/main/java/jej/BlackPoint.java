package jej;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BlackPoint extends Point {

    public BlackPoint(int x, int y) {
        super(x, y);
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(getX()-1,getY()-1, 3,3);
    }

}
