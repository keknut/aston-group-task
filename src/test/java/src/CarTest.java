package src;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void shouldBuildCarSuccessfully() {
        Car car = new Car.Builder()
                .model("Toyota")
                .power(150.0f)
                .year(2020)
                .build();

        assertThat(car.getModel()).isEqualTo("Toyota");
        assertThat(car.getPower()).isEqualTo(150.0f);
        assertThat(car.getYear()).isEqualTo(2020);
        assertThat(car.getType()).isEqualTo("Car");
    }

    @Test
    void shouldThrowExceptionWhenModelIsBlank() {
        assertThatThrownBy(() -> new Car.Builder()
                .model(" ")
                .power(100.0f)
                .year(2020)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Модель не задана");
    }

    @Test
    void shouldThrowExceptionWhenPowerIsInvalid() {
        assertThatThrownBy(() -> new Car.Builder()
                .model("BMW")
                .power(0.0f)
                .year(2020)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Мощность должна быть > 0");

        assertThatThrownBy(() -> new Car.Builder()
                .model("BMW")
                .power(-50.0f)
                .year(2020)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Мощность должна быть > 0");
    }

    @Test
    void shouldThrowExceptionWhenYearIsInvalid() {
        assertThatThrownBy(() -> new Car.Builder()
                .model("Audi")
                .power(120.0f)
                .year(1885)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Год некорректен");

        assertThatThrownBy(() -> new Car.Builder()
                .model("Audi")
                .power(120.0f)
                .year(2101)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Год некорректен");
    }

    @Test
    void shouldThrowExceptionWhenPowerIsNotSetAndNotProvided() {
        assertThatThrownBy(() -> new Car.Builder().model("BMW").build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Мощность должна быть > 0");
    }

    @Test
    void shouldReturnTypeAsCar() {
        Car car = new Car.Builder().model("Tesla").power(300).year(2023).build();
        assertThat(car.getType()).isEqualTo("Car");
    }
}