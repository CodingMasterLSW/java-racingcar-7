package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 객체를 생성할 때, disance는 0으로 초기화 되어야한다")
    @Test
    void create_car_distance_test() {

        //given
        Car car = Car.from("pobi");

        //when, then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("자동차 이름이 5글자를 초과한 경우, 예외가 발생한다")
    @Test
    void car_name_exception_test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = Car.from("pobiii");
        });

        assertThat(exception.getMessage()).isEqualTo(INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차 이름이 5글자 이하인 경우, 자동차가 성공적으로 생성된다.")
    @Test
    void car_create_test() {

        //given
        Car car = Car.from("kayne");

        //when, then
        assertThat(car.getName()).isEqualTo("kayne");
    }
}
