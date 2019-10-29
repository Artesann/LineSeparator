package jej;

public class VectorFunc {
    //если точка "с" слева от вектора ab вернет отрицательное значение
    //справа - положительное
    //чем больше нужно развернуть вектор тем больше модуль
    public static int rotate(Point a, Point b, Point c){
        return ((b.getX() - a.getX()) * (c.getY() - b.getY())) - ((b.getY() - a.getY()) * (c.getX() - b.getX()));
    }

    public static boolean intersects(Point a, Point b, Point c, Point d){
        int v1 = rotate(a, b, c);
        int v2 = rotate(b, a, d);
        int v3 = rotate(c, d, b);
        int v4 = rotate(d, c, a);
        return ((v1 * v2) > 0) && ((v3 * v4) > 0);
    }

    public static double lenght(Line line){
        Point a = line.getA();
        Point b = line.getB();
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static Point getCenterPoint(Line line){
        return new BlackPoint((line.getA().getX() + line.getB().getX())/2,
                (line.getA().getY()  +line.getB().getY())/2);
    }
}