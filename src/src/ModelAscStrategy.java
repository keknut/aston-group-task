package src;

public class ModelAscStrategy implements CarSortStrategy {

    @Override
    public int compare(Car c1, Car c2) {
        return c1.getModel().compareTo(c2.getModel());
    }
}
