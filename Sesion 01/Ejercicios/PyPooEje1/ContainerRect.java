public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;

    public static int numRec = 0;
    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }
    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            Coordenada c1 = r.getEsquina1();
            Coordenada c2 = r.getEsquina2();
            distancias[numRec] = Coordenada.distancia(c1, c2);
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No se pueden agregar más rectangulos.");
        }
    }
    public String toString() {
        String salida = "Rectangulo\tCoordenadas\t\t\tDistancia\tArea\n";

        for (int i = 0; i < numRec; i++) {
            salida += (i + 1) + "\t\t" +
                      "(" + rectangulos[i].getEsquina1() + ", " + rectangulos[i].getEsquina2() + ")\t" +
                      String.format("%.3f", distancias[i]) + "\t\t" +
                      String.format("%.2f", areas[i]) + "\n";
        }
        return salida;
    }
}
