import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class RandomDataGenerator {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random data generator:");
        System.out.println("1. Number");
        System.out.println("2. String");
        System.out.println("3. Date");
        System.out.println("Please, choose a type of data: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                generateRandomNumber();
                break;
            case 2:
                generateRandomString();
                break;
            case 3:
                generateRandomDate();
                break;
            default:
                System.out.println("Incorrect input.");
        }
    }

    public static void generateRandomNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write min value: ");
        int min = scanner.nextInt();
        System.out.print("Write max value: ");
        int max = scanner.nextInt();

        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("Random number is " + randomNumber);
    }

    public static void generateRandomString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write length of string: ");
        int length = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        System.out.println("Random string is " + sb);
    }

    public static void generateRandomDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter start date (dd-mm-yyyy): ");
        String startDateStr = scanner.next();
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);

        System.out.print("Enter end date (dd-mm-yyyy): ");
        String endDateStr = scanner.next();
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        long startMillis = startDate.toEpochDay();
        long endMillis = endDate.toEpochDay();
        long randomMillis = startMillis + random.nextInt((int) (endMillis - startMillis));
        LocalDate randomDate = LocalDate.ofEpochDay(randomMillis);

        System.out.println("Random date is " + randomDate.format(formatter));
    }
}
