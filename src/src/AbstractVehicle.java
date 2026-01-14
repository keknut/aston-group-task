package src;

public abstract class AbstractVehicle {
    protected String model;
    protected float power;
    protected int year;

    protected AbstractVehicle(String model, float power, int year) {
        this.model = model;
        this.power = power;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public float getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": Модель=" + model + "; мощность=" + power + "; год=" + year;
    }
}

