package src;

public class ModelDescStrategy implements CarSortStrategy {

    @Override
    public int compare(Car c1, Car c2) {
        return c2.getModel().compareTo(c1.getModel());
    }
}
