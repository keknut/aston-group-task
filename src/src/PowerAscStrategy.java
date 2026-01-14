package src;

public class PowerAscStrategy implements CarSortStrategy {

    @Override
    public int compare(Car c1, Car c2) {

        if (c1.getPower() > c2.getPower()) return 1;
        if (c1.getPower() < c2.getPower()) return -1;
        return 0;
    }
}