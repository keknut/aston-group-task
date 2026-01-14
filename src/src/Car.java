package src;

public class Car extends AbstractVehicle {
    public static Car[] cars;
    @Override
    public String getType() {
        return "Car";
    }

    // begin "setters", "getters" in abstract class
    // Убрал сеттеры, т.к.
//    public Car setModel(String model) {
//        this.model = model;
//        return this;
//    }
//
//    public Car setPower(float power) {
//        this.power = power;
//        return this;
//    }
//
//    public Car setYear(int year) {
//        this.year = year;
//        return this;
//    }
    // end "getters, setters"

    // Убрал
    private Car(Builder builder) {
        super(builder.model, builder.power, builder.year);
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
            if (model == null || model.isBlank()) {
                throw new IllegalStateException("Модель не задана");
            }
            if (power <= 0) {
                throw new IllegalStateException("Мощность должна быть > 0");
            }
            if (year < 1886 || year > 2100) {
                throw new IllegalStateException("Год некорректен");
            }
            return new Car(this);
        }
    }
}
