package jej;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Shape {
    List<Point> vertexes = new LinkedList<>();
    List<Line> lines = new LinkedList<>();

    public List<Line> getLines() {
        return lines;
    }

    //Алгоритм Джарвиса
    public void makeByList(List<Point> dots){
        List<Point> points = new LinkedList<>();
        for (Point p : dots) {
            points.add(p);
        }

        //найдем самую "левую" точку
        vertexes.clear();
        Point start = points.get(0);
        for(Point p: points){
            if(p.getX() < start.getX()){
                start = p;
            }
        }
        //"заворачиваем подарок"
        Point next = null;
        int i = 0;
        vertexes.add(start);
        //перемещаем start в конец
        points.remove(vertexes.get(0));
        points.add(vertexes.get(0));
        while (true){
            next = points.get(0);
            for (Point p : points){
                if (VectorFunc.rotate(vertexes.get(i), next, p) < 0){
                    next = p;
                }
            }
            if(next == vertexes.get(0))
            {
                break;
            }else {
                vertexes.add(next);
                lines.add(new Line(vertexes.get(vertexes.size() - 2), vertexes.get(vertexes.size() - 1)));
                points.remove(next);
            }
            i++;
        }
        lines.add(new Line(vertexes.get(vertexes.size() - 1), vertexes.get(0)));
    }

    public void draw(GraphicsContext gc) {
        for (Line l : lines) {
            l.draw(gc, Color.DARKGREEN);
        }
    }

    public List<Point> getVertexes(){
        return vertexes;
    }
}