package src;
import java.util.*;

public class CarSorter {
    private CarSortStrategy strategy;

    public void setStrategy(CarSortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Car> sort(List<Car> cars) {

        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = 0; j < cars.size() - 1 - i; j++) {

                if (strategy.compare(cars.get(j), cars.get(j + 1)) > 0) {
                    swap(cars, j);
                }
            }
        }
        return cars;
    }

    private void swap(List<Car> cars, int index) {
        Car temp = cars.get(index);
        cars.set(index, cars.get(index + 1));
        cars.set(index + 1, temp);
    }
}