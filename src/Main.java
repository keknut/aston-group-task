import src.*;
import comparators.*;

void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    while (running) {
        DisplayMenu.Main();
        switch (scanner.nextLine()) {
            case "1":
                DisplayMenu.SetArraySize();
                DisplayMenu.InputArray();
                DisplayMenu.InputArrayChoice(scanner.nextLine());
                break;
            case "2":
                DisplayMenu.SortArrayField();
                DisplayMenu.SortArrayField(scanner.nextLine());
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

    List<Car> cars = FileReader.readCars("file.txt");

    for (Car car : cars) {
        System.out.println(
                car.getModel() + " " +
                        car.getPower() + " " +
                        car.getYear()
        );
    }
}