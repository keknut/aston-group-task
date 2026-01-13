package src;

import java.util.Random;
import java.util.Scanner;

public class DisplayMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void Main() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1. Выбрать вариант заполнения массива");
        System.out.println("2. Cортировать массив по полю");
        System.out.println("0. Выход из программы \n");

        System.out.print("Выберите действие: ");
    }

    public static void InputArray() {
        System.out.println("\nВАРИАНТЫ ЗАПОЛНЕНИЯ МАССИВА");
        System.out.println("1. Загрузить из файла");
        System.out.println("2. Случайное заполнение");
        System.out.println("3. Вручную");
        System.out.println("0. Вернуться назад\n");

        System.out.print("Выберите действие: ");
    }

    public static void SortArrayField() {
        System.out.println("\nСОРТИРОВКА ПО ПОЛЮ");
        System.out.println("1. Модель");
        System.out.println("2. Мощность");
        System.out.println("3. Год выпуска");
        System.out.println("0. Вернуться назад\n");

        System.out.print("Выберите действие: ");
    }

    public static void SortArrayFieldDirection() {
        System.out.println("\nНАПРАВЛЕНИЕ СОРТИРОВКИ");
        System.out.println("1. По возрастанию");
        System.out.println("2. По убыванию");
        System.out.println("0. Вернуться назад\n");

        System.out.print("Выберите действие: ");
    }

    public static void SetArraySize() {
        System.out.print("\nВведите размер массива: ");
        Car.cars = new Car[scanner.nextInt()];
    }

    public static void ManualInput() {
        Car.Builder current;
        for(var i = 0; i < Car.cars.length; i++) {
            current = new Car.Builder();

            System.out.print("\nВведите модель автомобиля: ");
            var model = scanner.next().trim();

            System.out.print("Введите мощность автомобиля: ");
            var power = scanner.nextFloat();

            System.out.print("Введите год автомобиля: ");
            var year = scanner.nextInt();

            current.model(model).power(power).year(year);

            Car.cars[i] = current.build();
            System.out.println("\nДобавлен автомобиль: " + current);
        }
    }

    public static void RandomInput() {
        Car.Builder current;
        String[] models = { "Toyota", "Volkswagen", "Ford", "Honda", "Nissan", "Hyundai", "BMW", "Mercedes-Benz", "Audi", "Kia" };
        for(var i = 0; i < Car.cars.length; i++) {
            var random = new Random();
            current = new Car.Builder();

            String model = models[random.nextInt(Car.cars.length)];
            var power = Math.round(random.nextFloat(50f, 100f) * 100f) / 100f;
            int year = random.nextInt(1950, 2026);

            current.model(model).power(power).year(year);

            Car.cars[i] = current.build();
            System.out.print("\nДобавлен автомобиль: " + current);
        }
        System.out.print('\n');
    }

    public static void PrintArray() {
        for(var car : Car.cars) {
            System.out.println(car);
        }
    }

    public static void InputArrayChoice(String input) {
        switch (input) {
            case "1":
                //метод заполнения массива из файла
                System.out.println("//метод заполнения массива из файла");
                break;
            case "2":
                //метод заполнения массива рандомно
                System.out.println("//метод заполнения массива рандомно");
                RandomInput();
                break;
            case "3":
                //метод заполнения массива вручную
                System.out.println("//метод заполнения массива вручную");
                ManualInput();
                break;
            case "0":
                break;
            default:
                System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
        }
    }

    public static void SortArrayField(String input) {
        switch (input) {
            case "1":
            case "2":
            case "3":
                SortArrayFieldDirection();
                SortArrayFieldDirection(scanner.nextLine(), input);
                break;
            case "0":
                break;
            default:
                System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
        }
    }

    public static void SortArrayFieldDirection(String input, String sortIput) {
        switch (input) {
            case "1":
                switch (sortIput) {
                    case "1":
                        System.out.println("//метод сортировки по возрастанию и модели");
                        //метод сортировки по возрастанию и модели
                        break;
                    case "2":
                        System.out.println("//метод сортировки по возрастанию и по мощности");
                        //метод сортировки по возрастанию и по мощности
                        break;
                    case "3":
                        System.out.println("//метод сортировки по возрастанию и по году выпуска");
                        //метод сортировки по возрастанию и по году выпуска
                        break;
                }
                break;
            case "2":
                switch (sortIput) {
                    case "1":
                        System.out.println("//метод сортировки по убыванию и по модели");
                        //метод сортировки по убыванию и по модели
                        break;
                    case "2":
                        System.out.println("//метод сортировки по убыванию и по мощности");
                        //метод сортировки по убыванию и по мощности
                        break;
                    case "3":
                        System.out.println("//метод сортировки по убыванию и по году выпуска");
                        //метод сортировки по убыванию и по году выпуска
                        break;
                }
                break;
            case "0":
                break;
            default:
                System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
        }
    }
}