import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeArray = scanner.nextInt();
        int[] numbers = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            numbers[i] = scanner.nextInt();
        }
        int min = scanner.nextInt();

        int result = 0;
        for (int var: numbers) {
            if (var > min) {
                result += var;
            }
        }
        System.out.println(result);
    }
}