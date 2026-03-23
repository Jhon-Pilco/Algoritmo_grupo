public class Verificador {
    private static double minX(Rectangulo r) {
        return Math.min(r.getEsquina1().getX(), r.getEsquina2().getX());
    }
    private static double maxX(Rectangulo r) {
        return Math.max(r.getEsquina1().getX(), r.getEsquina2().getX());
    }

    private static double minY(Rectangulo r) {
        return Math.min(r.getEsquina1().getY(), r.getEsquina2().getY());
    }

    private static double maxY(Rectangulo r) {
        return Math.max(r.getEsquina1().getY(), r.getEsquina2().getY());
    }
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        return (maxX(r1) > minX(r2) &&
                minX(r1) < maxX(r2) &&
                maxY(r1) > minY(r2) &&
                minY(r1) < maxY(r2));
    }
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        boolean bordeX = (maxX(r1) == minX(r2) || minX(r1) == maxX(r2)) &&
                         (maxY(r1) >= minY(r2) && minY(r1) <= maxY(r2));

        boolean bordeY = (maxY(r1) == minY(r2) || minY(r1) == maxY(r2)) &&
                         (maxX(r1) >= minX(r2) && minX(r1) <= maxX(r2));

        return bordeX || bordeY;
    }
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !(esSobrePos(r1, r2) || esJunto(r1, r2));
    }
}