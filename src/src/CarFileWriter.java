package src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CarFileWriter {

    public static void appendCars(String fileName, List<Car> cars) throws Exception {

        // 1) Собираем текст, который хотим дописать
        StringBuilder sb = new StringBuilder();

        // Для красоты добавим "шапку", чтобы было понятно, что это результат сортировки
        sb.append("---- SORT RESULT ----").append(System.lineSeparator());

        for (Car car : cars) {
            if (car == null) continue;

            // 2) Формат: model;power;year
            sb.append(car.getModel())
                    .append(";")
                    .append(car.getPower())
                    .append(";")
                    .append(car.getYear())
                    .append(System.lineSeparator());
        }

        // Если вдруг список пуст — ничего не пишем
        if (sb.length() == 0) return;

        // 3) Дописываем в файл (CREATE + APPEND)
        Files.writeString(
                Path.of(fileName),
                sb.toString(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}