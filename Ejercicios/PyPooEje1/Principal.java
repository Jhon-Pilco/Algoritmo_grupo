import java.util.*;
public class Principal {
    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println(nombre + " = (" + r.getEsquina1() + ", " + r.getEsquina2() + ")");
    }
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double x1 = Math.max(
                Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX())
        );
        double y1 = Math.max(
                Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY())
        );
        double x2 = Math.min(
                Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX())
        );
        double y2 = Math.min(
                Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY())
        );
        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);
        return new Rectangulo(c1, c2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContainerRect contenedor = new ContainerRect(10);
        System.out.print("Ingrese una esquina del 1er rectángulo: ");
        Coordenada a1 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        Coordenada a2 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        Rectangulo A = new Rectangulo(a1, a2);
        contenedor.addRectangulo(A); 
        System.out.print("Ingrese una esquina del 2do rectángulo: ");
        Coordenada b1 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: ");
        Coordenada b2 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        Rectangulo B = new Rectangulo(b1, b2);
        contenedor.addRectangulo(B); 
        mostrarRectangulo("Rectangulo A", A);
        mostrarRectangulo("Rectangulo B", B);
        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo rSobre = rectanguloSobre(A, B);
            System.out.println("Area de sobreposicion = " + rSobre.calculoArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan.");
        } else {
            System.out.println("Rectangulos A y B son disjuntos.");
        }
        System.out.println("\nContenido del contenedor:");
        System.out.println(contenedor);
    }
}
