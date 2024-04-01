import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class RandomDataGenerator {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Генерация случайных данных:");
        System.out.println("1. Число");
        System.out.println("2. Строка");
        System.out.println("3. Дата");
        System.out.print("Выберите тип данных (1/2/3): ");
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
                System.out.println("Некорректный выбор.");
        }
    }

    public static void generateRandomNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите минимальное значение: ");
        int min = scanner.nextInt();
        System.out.print("Введите максимальное значение: ");
        int max = scanner.nextInt();

        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("Случайное число: " + randomNumber);
    }

    public static void generateRandomString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину строки: ");
        int length = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        System.out.println("Случайная строка: " + sb.toString());
    }

    public static void generateRandomDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Введите начальную дату (в формате dd-mm-yyyy): ");
        String startDateStr = scanner.next();
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);

        System.out.print("Введите конечную дату (в формате dd-mm-yyyy): ");
        String endDateStr = scanner.next();
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        long startMillis = startDate.toEpochDay();
        long endMillis = endDate.toEpochDay();
        long randomMillis = startMillis + random.nextInt((int) (endMillis - startMillis));
        LocalDate randomDate = LocalDate.ofEpochDay(randomMillis);

        System.out.println("Случайная дата: " + randomDate.format(formatter));
    }
}
