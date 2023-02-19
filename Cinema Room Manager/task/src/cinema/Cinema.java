package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);

    static int numberOfSeats;
    static int rows;
    static int seatsPerRow;
    static int[][] cinema;

    public static void initialize() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();

        numberOfSeats = rows * seatsPerRow;

        cinema = new int[rows][seatsPerRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                cinema[i][j] = 0;
            }
        }
    }

    private static int purchasedSeats() {
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (cinema[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int incomeSeats() {
        int income = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                income += cinema[i][j];
            }
        }
        return income;
    }

    private static int totalIncome() {
            if (numberOfSeats < 60) {
                return numberOfSeats * 10;
            } else {
                return (seatsPerRow * (rows/2) * 10) + (seatsPerRow * (rows - (rows/2)) * 8);
            }
    }

    private static void showStatistics() {
        System.out.printf("Number of purchased tickets: %d%n", purchasedSeats());
        System.out.printf("Percentage: %.2f%%%n",(purchasedSeats()/(double )numberOfSeats) * 100);
        System.out.printf("Current income: $%d%n",incomeSeats());
        System.out.printf("Total income: $%d%n",totalIncome());
    }

    public static void showSeats() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i+1);
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(" " + (cinema[i][j] == 0?"S":"B"));
            };
            System.out.println();
        }
    }

    public static boolean buyTicket() {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        if (row <= 0 || row > rows || seat <= 0 || seat > seatsPerRow) {
            System.out.println("Wrong input!");
            return false;
        }

        int ticketprice;
        if (numberOfSeats <= 60) {
            ticketprice = 10;
        } else {
            ticketprice = (row <= rows/2?10:8);
        }
        if (cinema[row-1][seat-1] == 0) {
            cinema[row-1][seat-1] = ticketprice;
            System.out.println("Ticket price: $" + ticketprice);
            return true;
        } else {
            System.out.println("That ticket has already been purchased!");
            return false;
        }
    }

    public static void doLoop() {
        int option;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if (option == 1) {
                showSeats();
            } else if (option == 2) {
                boolean ticketSold = false;
                do {
                    ticketSold = buyTicket();
                } while(!ticketSold);
            } else if (option == 3) {
                showStatistics();
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        initialize();
        doLoop();
    }
}