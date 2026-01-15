package src;

import java.util.ArrayList;
import java.util.List;

public class EvenYearCarSorter extends  CarSorter {

    @Override
    public List<Car> sort(List<Car> cars) {
        List<Car> evens = new ArrayList<>();
        for (Car car : cars)
            if (car.getYear() % 2 == 0)
                evens.add(car);

        super.sort(evens);

        int evenIndex = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getYear() % 2 == 0) {
                cars.set(i, evens.get(evenIndex++));
            }
        }

        return cars;
    }
}
