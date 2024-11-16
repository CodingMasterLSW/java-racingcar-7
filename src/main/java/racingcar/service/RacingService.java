package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCreator;
import racingcar.domain.CarManager;
import racingcar.utils.InputParser;
import racingcar.utils.RandomNumber;

public class RacingService {

    private final CarCreator carCreator;
    private final InputParser inputParser;
    private CarManager carManager;
    private RandomNumber randomNumber;

    public RacingService(CarCreator carCreator, InputParser inputParser, RandomNumber randomNumber) {
        this.carCreator = carCreator;
        this.inputParser = inputParser;
        this.randomNumber = randomNumber;
    }

    public void initCarManager(String userInput) {
        List<String> userNames = inputParser.split(userInput);
        List<Car> generateCars = carCreator.generate(userNames);
        carManager = CarManager.from(generateCars);
    }

    public List<Car> racing(List<Integer> randomNumbers) {
        return carManager.moveCars(randomNumbers);
    }

    public List<Integer> generateRandomNumbers(){
        return randomNumber.generate(carManager.getCarsSize());
    }

    public List<String> winner() {
        return carManager.findWinner();
    }
}
