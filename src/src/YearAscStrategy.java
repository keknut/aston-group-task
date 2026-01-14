package src;

public class YearAscStrategy implements CarSortStrategy {

    @Override
    public int compare(Car c1, Car c2) {
        return c1.getYear() - c2.getYear();
    }
}