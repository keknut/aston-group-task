package src;

public class Car {

    private String model;
    private float power;
    private int year;

    public Car(String model, float power, int year) {
        this.model = model;
        this.power = power;
        this.year = year;
    }

    // begin "getters, setters"
    public String getModel() { return this.model; }
    public Car setModel(String model) { this.model = model; return this; }

    public float getPower() { return this.power; }
    public Car setPower(float power) { this.power = power; return this; }

    public int getYear() { return this.year; }
    public Car setYear(int year) { this.year = year; return this; }
    // end "getters, setters"

    private Car(Builder builder) {
        this.model = model;
        this.power = power;
        this.year = year;
    }

    public static class Builder {
        private String model;
        private float power;
        private int year;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder power(float power) {
            this.power = power;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
