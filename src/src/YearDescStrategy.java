package src;

public class YearDescStrategy implements CarSortStrategy {

    @Override
    public int compare(Car c1, Car c2) {
        return c2.getYear() - c1.getYear();
    }
}