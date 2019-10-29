package jej;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;

public class Invoker {
    //находим две линии (A1, A2) и (B1, B2), соединяющие две ближайшие верширы многоугольников
    //проводим прямую через центры этих линий
    public static void drawLine(List<Point> points1, List<Point> points2, GraphicsContext gc){
        if(canDrawLine(points1, points2)){
            Shape shape1 = new Shape();
            Shape shape2 = new Shape();
            shape1.makeByList(points1);
            shape2.makeByList(points2);

//            shape1.draw(gc);
//            shape2.draw(gc);

            List<Point> shape1Points = shape1.getVertexes();
            List<Point> shape2Points = shape2.getVertexes();

            Line shortest1 = new Line(shape1Points.get(0), shape2Points.get(0));
            Line shortest2 = new Line(shape1Points.get(0), shape2Points.get(0));
            Line curLine;

            for(Point point1: shape1Points){
                for(Point point2: shape2Points){
                    curLine = new Line(point1, point2);
                    if(curLine.len() < shortest1.len()) {
                        shortest1 = curLine;
                    }
                }
            }
            shape1Points.remove(shortest1.getA());
            shape2Points.remove(shortest2.getB());
            for(Point point1: shape1Points){
                for(Point point2: shape2Points){
                    curLine = new Line(point1, point2);
                    if(curLine.len() < shortest2.len()) {
                        shortest2 = curLine;
                    }
                }
            }
//            for(Point point1: shape1Points){
//                for(Point point2: shape2Points){
//                    curLine = new Line(point1, point2);
//                    if(curLine.len() < shortest1.len() && curLine.getA() != shortest2.getA() &&
//                            curLine.getB() != shortest2.getB()){
//                        shortest1 = curLine;
//                    }else if(curLine.len() < shortest2.len() && curLine.getA() != shortest1.getA() &&
//                            curLine.getB() != shortest1.getB()){
//                        shortest2 = curLine;
//                    }
//                }
            //}

            Line separateLine = new Line(VectorFunc.getCenterPoint(shortest1),
                    VectorFunc.getCenterPoint(shortest2));

//            shortest1.draw(gc, Color.BLACK);
//            shortest2.draw(gc, Color.GRAY);
            separateLine.draw(gc, Color.BLUE);

        }
    }
    //работает коректно если в обоих множествах больше двух точек, иначе возвращет true
    public static boolean canDrawLine(List<Point> points1, List<Point> points2){
        if(points1.size() > 1 && points2.size() > 1) {
            Shape shape1 = new Shape();
            Shape shape2 = new Shape();
            shape1.makeByList(points1);
            shape2.makeByList(points2);

            List<Point> shape1Vertexes = shape1.getVertexes();
            List<Point> shape2Vertexes = shape2.getVertexes();
            //iterator ixy
            //x - номер фигуры
            //y - номер итератора
            //второй итрератор на шаг опрережает первый
            Iterator<Point> i11 = shape1Vertexes.iterator();
            Iterator<Point> i12 = shape1Vertexes.iterator();
            Iterator<Point> i21 = shape2Vertexes.iterator();
            Iterator<Point> i22 = shape2Vertexes.iterator();

            boolean intersects = false;
            Point A = null;
            Point B = i12.next();
            Point C = null;
            Point D = i22.next();

            boolean end = false;
            while (!end){
                //сравненеие линии последний - первый
                if(!i12.hasNext()){
                    end = true;
                    A = B;
                    B = shape1Vertexes.get(0);
                }else {
                    A = i11.next();
                    B = i12.next();
                }
                while (i22.hasNext()){
                    C = i21.next();
                    D = i22.next();
                    intersects = VectorFunc.intersects(A, B, C, D);
                    if(intersects == true) {
                        break;
                    }
                }
                if(intersects == true){
                    break;
                }
                //сравненеие линии последний - первый
                intersects = VectorFunc.intersects(A, B, D, shape2Vertexes.get(0));
                i21 = shape2Vertexes.iterator();
                i22 = shape2Vertexes.iterator();
                i22.next();
            }
            return !intersects;
        } else {
            return true;
        }
    }
}
