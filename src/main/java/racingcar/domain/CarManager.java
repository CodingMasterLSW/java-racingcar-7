package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {

    private final List<Car> cars;

    private CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarManager from(List<Car> cars) {
        return new CarManager(cars);
    }

    public List<Car> moveCars(List<Integer> randomNumbers) {
        int idx = 0;
        for (Car car : cars) {
            car.move(randomNumbers.get(idx));
            idx++;
        }
        return getCars();
    }

    public int getCarsSize() {
        return cars.size();
    }

    public List<String> findWinner() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
