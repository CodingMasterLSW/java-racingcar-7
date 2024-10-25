package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumber;

public class Racing {

    private CarManager carManager;

    public Racing(CarManager carManager) {
        this.carManager = carManager;
    }

    public List<Car> startRacing() {
        for (Car car : carManager.getCars()) {
            car.move(RandomNumber.generate());
        }
        return carManager.getCars();
    }

    public String findWinner(List<Car> cars) {
        int maxMovedDistance = findMaxMovedDistance(cars);
        return cars.stream()
                .filter(car -> car.getMovedDistance() == maxMovedDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxMovedDistance(List<Car> cars) {
        int maxMovedDistance = 0;
        for (Car car : cars) {
            if (car.getMovedDistance() > maxMovedDistance) {
                maxMovedDistance = car.getMovedDistance();
            }
        }
        return maxMovedDistance;
    }

}
