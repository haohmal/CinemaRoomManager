import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = scanner.nextInt();

        int[][] array = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                array[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        String result = "YES";
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (array[i][j] != array[j][i]) {
                    result = "NO";
                }
            }
        }
        System.out.println(result);
    }
}