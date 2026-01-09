package src;

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

    public static void InputArrayChoice(String input) {
        switch (input) {
            case "1":
                //метод заполнения массива из файла
                System.out.println("//метод заполнения массива из файла");
                break;
            case "2":
                //метод заполнения массива рандомно
                System.out.println("//метод заполнения массива рандомно");
                break;
            case "3":
                //метод заполнения массива вручную
                System.out.println("//метод заполнения массива вручную");
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