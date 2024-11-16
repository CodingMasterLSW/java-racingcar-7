package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarManagerTest {

    private CarManager carManager;

    @BeforeEach
    void carsInit() {
        List<Car> cars = List.of(
                Car.from("pobi"),
                Car.from("jenny"),
                Car.from("jisu")
        );
        carManager = CarManager.from(cars);
    }

    @DisplayName("5보다 작은 랜덤번호가 주어졌을 때, 모든 자동차는 움직여서는 안 된다.")
    @Test
    void under_move_condition_then_not_move() {

        //given
        List<Integer> randomNumbers = List.of(1, 2, 3);

        //when
        carManager.moveCars(randomNumbers);
        List<Car> cars = carManager.getCars();

        //then
        for (Car car : cars) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @DisplayName("5보다 큰 랜덤번호가 주어졌을 때, 모든 자동차들은 움직여야한다.")
    @Test
    void over_move_condition_then__move() {

        //given
        List<Integer> randomNumbers = List.of(5, 6, 7);

        //when
        carManager.moveCars(randomNumbers);
        List<Car> cars = carManager.getCars();

        //then
        for (Car car : cars) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @DisplayName("3, 4, 5 가 주어졌을 경우, 5가 주어진 자동차만 움직여야한다.")
    @Test
    void different_case() {

        //given
        List<Integer> randomNumbers = List.of(3, 4, 5);

        //when
        carManager.moveCars(randomNumbers);
        List<Car> cars = carManager.getCars();

        //then
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = randomNumbers.get(i);
            Car car = cars.get(i);

            if (randomNumber < 5) {
                assertThat(car.getDistance()).isEqualTo(0);
                return;
            }
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @DisplayName("5,6,7 이 주어졌을 경우, 우승자는 pobi, jenny, jisu다")
    @Test
    void all_winner_case() {
        //given
        List<Integer> randomNumbers = List.of(5, 6, 7);

        //when
        carManager.moveCars(randomNumbers);
        List<String> winner = carManager.findWinner();

        //then
        List<String> expectedWinner = List.of("pobi", "jenny", "jisu");
        assertThat(winner.containsAll(expectedWinner));
    }

    @DisplayName("4,5,6 이 주어졌을 경우, 우승자는 jenny, jisu다")
    @Test
    void two_winner_case() {
        //given
        List<Integer> randomNumbers = List.of(4, 5, 6);

        //when
        carManager.moveCars(randomNumbers);
        List<String> winner = carManager.findWinner();

        //then
        List<String> expectedWinner = List.of("jenny", "jisu");
        assertThat(winner.containsAll(expectedWinner));
    }

    @DisplayName("3,4,5 가 주어졌을 경우, 우승자는 jisu다")
    @Test
    void one_winner_case() {
        //given
        List<Integer> randomNumbers = List.of(3, 4, 6);

        //when
        carManager.moveCars(randomNumbers);
        List<String> winner = carManager.findWinner();

        //then
        List<String> expectedWinner = List.of("jisu");
        assertThat(winner.containsAll(expectedWinner));
    }
}
