package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarManager {

    private final List<Car> cars;

    private CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarManager from(List<Car> cars) {
        return new CarManager(cars);
    }

    public void moveCars(List<Integer> randomNumbers) {
        int idx = 0;
        for (Car car : cars) {
            car.move(randomNumbers.get(idx));
            idx++;
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
