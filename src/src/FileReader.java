package src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<Car> readCars(String fileName) throws Exception {

        List<Car> cars = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(fileName));

        // проходим по строкам
        for (String line : lines) {
            // пропускаем пустые строки
            if (line.isEmpty()) {
                continue;
            }
            // делим строку по ;
            Car car = getCar(line);
            cars.add(car);
        }
        return cars;
    }

    private static Car getCar(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат строки: " + line);
        }
        String model = parts[0].trim();
        String power = parts[1].trim();
        String year = parts[2].trim();

        if (model.isEmpty()) {
            throw new IllegalArgumentException("Модель пустая");
        }

        float carPower;
        int carYear;

        // ВАЛИДАЦИЯ: power число
        try {
            carPower = Float.parseFloat(power);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("power должен быть числом, а не: " + power);
        }

        // ВАЛИДАЦИЯ: year целое число
        try {
            carYear = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("year должен быть целым числом, а не: " + year);
        }

        // ВАЛИДАЦИЯ: разумные границы
        if (carPower <= 0) {
            throw new IllegalArgumentException("power должен быть > 0");
        }
        if (carYear < 1886 || carYear > 2100) {
            throw new IllegalArgumentException("year выглядит неверно: " + carYear);
        }

        return new Car.Builder()
                .model(model)
                .power(carPower)
                .year(carYear)
                .build();
    }
}
