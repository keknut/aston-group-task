package src;

public class Car {

    private String model;
    private float power;
    private int year;
    public static Car[] cars;

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
        private String model = "undefined";
        private float power = 0.0f;
        private int year = 0;

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

        @Override
        public String toString() {
            return "Модель: " + this.model +
                    ", мощность: " + this.power +
                    ", год: " + this.year;
        }
    }
}
