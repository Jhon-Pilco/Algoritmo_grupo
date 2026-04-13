public static void main(String[] args) {
    int[] arr = {1, 2, 2, 3, 3, 3, 4};

    System.out.println("Moda1: " + moda1(arr));

    Arrays.sort(arr); // necesario para moda2
    System.out.println("Moda2: " + moda2(arr));
}