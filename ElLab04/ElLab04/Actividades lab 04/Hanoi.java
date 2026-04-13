public class Hanoi {

    public static void main(String[] args) {
        torresHanoi(3, 1, 2, 3);
    }

    // Método recursivo corregido (ahora es static)
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) {

        // Caso base
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            // Mover n-1 discos a la torre auxiliar
            torresHanoi(discos - 1, torre1, torre3, torre2);

            // Mover el disco más grande
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);

            // Mover los n-1 discos al destino
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}