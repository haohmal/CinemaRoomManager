import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        int factorial = 1;
        long factorialResult = 1;
        while (factorialResult <= number) {
            factorial++;
            factorialResult = 1;
            for (int i = 1; i <= factorial; i++) {
                factorialResult *= i;
            }
        }
        System.out.println(factorial);
    }
}