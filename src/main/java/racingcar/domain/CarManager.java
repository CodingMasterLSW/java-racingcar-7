package racingcar.domain;

import java.util.ArrayList;
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
        List<String> winner = new ArrayList<>();
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                winner.clear();
                maxDistance = car.getDistance();
                winner.add(car.getName());
            }
            if (car.getDistance() == maxDistance) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
