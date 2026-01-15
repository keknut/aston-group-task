package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void Main() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1. Выбрать вариант заполнения массива");
        System.out.println("2. Сортировать массив по полю");
        System.out.println("3. Вывести содержимое массива");
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
        int size = scanner.nextInt();
        /*
        Очистка буфера
         */
        scanner.nextLine();
        Car.cars = new Car[size];
    }

    public static void ManualInput() {
        Car.Builder current;
        /*
        Очистка буфера после предыдущего ввода
         */
        scanner.nextLine();

        for (var i = 0; i < Car.cars.length; i++) {
            current = new Car.Builder();

            System.out.print("\nВведите модель автомобиля: ");
            /*
            Исправил на Line чтобы можно было читать строку вместо слова
             */
            String model = scanner.nextLine().trim();
            if (model.isEmpty()) {
                System.out.println("Модель не может быть пустой. Попробуйте ещё раз.");
                i--;
                continue;
            }

            float power = 0;
            boolean validPower = false;
            while (!validPower) {
                System.out.print("Введите мощность автомобиля: ");
                try {
                    power = scanner.nextFloat();
                    if (power <= 0) {
                        System.out.println("Мощность должна быть положительным числом. Попробуйте снова.");
                        continue;
                    }
                    validPower = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Ошибка: введите корректное число (например 90.5).");
                    /*
                    Очистка буфера
                     */
                    scanner.nextLine();
                }
            }

            int year = 0;
            boolean validYear = false;
            while (!validYear) {
                System.out.print("Введите год автомобиля: ");
                try {
                    year = scanner.nextInt();
                    if (year < 1886 || year > 2100) {
                        System.out.println("Год должен быть от 1886 до 2100. Попробуйте снова.");
                        continue;
                    }
                    validYear = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Ошибка: введите корректный год (целое число).");
                    scanner.nextLine();
                }
            }
            /*
            Очистка буфера
             */
            scanner.nextLine();

            /*
            Сборка объекта
             */
            try {
                current.model(model).power(power).year(year);
                Car.cars[i] = current.build();
                System.out.println("\nДобавлен автомобиль: " + Car.cars[i]);
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при создании автомобиля: " + e.getMessage());
                /*
                Даём возможность пересоздать автомобиль
                 */
                i--;
            }

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
        if (Car.cars == null) {
            System.out.println("Массив еще не заполнен");
            return;
        }
        for (var car : Car.cars) {
//            for (var car : Car.cars)
            System.out.println(car);
        }
    }

    public static void InputArrayChoice(String input) {
        switch (input) {
            case "1":
                SetArraySize();
                try {
                    List<Car> list = FileReader.readCars("src/file.txt");
                    for (int i = 0; i < Car.cars.length && i < list.size(); i++) {
                        Car.cars[i] = list.get(i);
                    }
                    System.out.println("Готово! Массив заполнен из файла.");
                } catch (Exception e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
                PrintArray();
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
            case "1", "2", "3" -> {
                SortArrayFieldDirection();
            }
            case "0" -> {}
            default -> System.out.println("Неверный ввод! Пожалуйста, выберите пункт из меню.");
        }
    }

    public static void SortArrayFieldDirection(String input, String sortIput) {
        try{
            SortOption option = SortOption.fromInput(sortIput, input);
            CarSorter carSorter = new CarSorter();
            carSorter.setStrategy(option.getStrategy());

            List<Car> current = new ArrayList<>(List.of(Car.cars));
            current = carSorter.sort(current);
            Car.cars = current.toArray(new Car[0]);

            System.out.println("Отсортировано: " + option.getDescription());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}