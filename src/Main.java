import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        int row;
        int column;
        Scanner scanner = new Scanner(System.in);
        Graveyard graveyard = new Graveyard(100,100);
        System.out.println("Добро пожаловать в SadGraves. Создай свое идеальное кладбище ^-^\n");
        while (true) {
            System.out.println("""
                    Выберите действие:
                    1.Поиск могилы
                    2.Список всех могил
                    3.Узнать количество могил
                    4.Добавить могилу
                    5.Удалить могилу
                    6.Узнать ФИО умерших
                    7.Выход""");
            System.out.print("Введите номер действия: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера ввода
                switch (choice) {
                    case 1:
                        System.out.print("Введите номер вертикального ряда могилы: ");
                        row = scanner.nextInt();
                        System.out.print("Введите номер горизонтального ряда могилы: ");
                        column = scanner.nextInt();
                        Grave grave = graveyard.findGrave(row, column);
                        if (graveyard.NullGrave()) {
                            System.out.println("Могила с заданными координатами не найдена");
                        } else {
                            System.out.println("Найдена могила:");
                            System.out.println("Фамилия: " + grave.getMourners().getSurname());
                            System.out.println("Имя: " + grave.getMourners().getLastname());
                            System.out.println("Отчество: " + grave.getMourners().getMiddlename());
                            System.out.println("Дата смерти: " + grave.getMourners().getLastDay() + "."
                            + grave.getMourners().getLastMonth() + "." + grave.getMourners().getLastYear());
                        }
                        break;
                    case 2:
                        System.out.println("Список всех могил:");
                        if(graveyard.NullGrave()){
                            System.out.println("Могил пока что нет!");
                        }else{
                            System.out.println("Могилы есть в этих рядах.");
                            graveyard.displayGraves();
                        }
                        break;
                    case 3:
                        System.out.println("Количество могил: " + graveyard.countGraves());
                        break;
                    case 4:
                        addGrave(scanner, graveyard);
                        break;
                    case 5:
                        System.out.print("Введите номер вертикального ряда на кладбище (от 1 до 100): ");
                        row = scanner.nextInt();
                        System.out.print("Введите номер горизонтального ряда на кладбище (от 1 до 100): ");
                        column = scanner.nextInt();

                        graveyard.deleteGrave(row, column);
                        break;
                    case 6:
                        System.out.println("Список всех умерших:");
                        graveyard.displayMourners();
                        break;
                    case 7:
                        System.out.println("Выход из программы");
                        return;
                    default:
                        System.out.println("Неверный выбор");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода: введите число");
                scanner.nextLine(); // очистка буфера ввода
            }
        }
    }

    public static void addGrave(Scanner scanner, Graveyard graveyard) {
        System.out.print("Введите номер вертикального ряда на кладбище (от 1 до 100): ");
        int row = scanner.nextInt();
        if (row < 1 || row > 100) {
            System.out.println("Неверный номер ряда");
            return;
        }
        System.out.print("Введите номер горизонтального ряда на кладбище (от 1 до 100): ");
        int column = scanner.nextInt();
        if (column < 1 || column > 100) {
            System.out.println("Неверный номер ряда");
            return;
        }
        if (graveyard.isGraveTaken(row, column)) {
            System.out.println("Место для могилы с заданными рядами уже занято");
            return;
        }
        System.out.print("Введите фамилию: ");
        String surname = readString(scanner);
        System.out.print("Введите имя: ");
        String lastname = readString(scanner);
        System.out.print("Введите отчество: ");
        String middlename = readString(scanner);
        System.out.print("Введите день смерти (от 1 до 31): ");
        int lastDay = readDay(scanner);
        System.out.print("Введите месяц смерти (от 1 до 12): ");
        int lastMonth = readMonth(scanner);
        System.out.print("Введите год смерти (от 2000 до 2024): ");
        int lastYear = readYear(scanner);
        Mourners person  = new Person(lastname, surname, middlename, lastDay, lastMonth, lastYear);
        Grave grave = new Grave(row, column, person);
        graveyard.addGrave(grave);
        System.out.println("Могила успешно добавлена");
    }

    private static String readString(Scanner scanner) {
        String input = scanner.nextLine();
        if (!input.matches("[а-яА-Я]+")) {
            System.out.println("Введите только буквы");
            return readString(scanner);
        }
        return input;
    }

    private static int readDay(Scanner scanner) {
        int input = scanner.nextInt();
        if (input < 1 || input > 31) {
            System.out.println("Введите дату от 1 до 31");
            return readDay(scanner);
        }
        return input;
    }

    private static int readMonth(Scanner scanner) {
        int input = scanner.nextInt();
        if (input < 1 || input > 12) {
            System.out.println("Введите месяц от 1 до 12");
            return readMonth(scanner);
        }
        return input;
    }

    private static int readYear(Scanner scanner) {
        int input = scanner.nextInt();
        if (input < 1900 || input > 2024) {
            System.out.println("Введите год от 1900 до 2024");
            return readYear(scanner);
        }
        return input;
    }
}