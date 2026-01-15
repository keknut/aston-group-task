import src.*;
import comparators.*;

void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    while (running) {
        DisplayMenu.Main();
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                DisplayMenu.SetArraySize();
                DisplayMenu.InputArray();
                String inputChoice = scanner.nextLine().trim();
                DisplayMenu.InputArrayChoice(inputChoice);
                break;
            case "2":
                if (Car.cars == null) {
                    System.out.println("Массив еще не заполнен");
                    continue;
                }
                DisplayMenu.SortArrayField();
                String fieldInput = scanner.nextLine().trim();

                if (fieldInput.equals("0")) break;

                switch (fieldInput) {
                    case "1", "2", "3", "4":
                        DisplayMenu.SortArrayFieldDirection();
                        String directionInput = scanner.nextLine().trim();
                        DisplayMenu.SortArrayFieldDirection(directionInput, fieldInput);
                        break;
                    default:
                        System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
                }
                break;
            case "3":
                DisplayMenu.PrintArray();
                break;
            case "0":
                running = false;
                System.out.println("Работа программы завершена");
                break;
            default:
                System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
        }
    }
    scanner.close();

    try {
        List<Car> cars = FileReader.readCars("file.txt");

        for (Car car : cars) {
            System.out.println(
                    car.getModel() + " " +
                            car.getPower() + " " +
                            car.getYear()
            );
        }
    } catch (Exception e) {
        System.out.println("Ошибка чтения из файла: " + e.getMessage());
    }

}