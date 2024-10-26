package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCreator;
import racingcar.domain.CarManager;
import racingcar.domain.InputParser;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;


public class RacingService {

    private final Winner winner;
    private final RandomNumber randomNumber;
    private final Validator validation;
    private CarManager carManager;

    public RacingService(Winner winner, RandomNumber randomNumber, Validator validation) {
        this.winner = winner;
        this.randomNumber = randomNumber;
        this.validation = validation;
    }

    public void setUpRacing(String userInput) {
        List<Car> cars = CarCreator.createCars(InputParser.parserCarNames(userInput));
        this.carManager = new CarManager(cars);
    }

    public List<Car> startRacingOnce() {
        List<Car> cars = carManager.getCars();
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
        return cars;
    }

    public String getWinners() {
        return winner.findWinner(carManager.getCars());
    }

    public String getValidatedStringInput(String userStringInput) {
        validation.verifyUserInput(userStringInput);
        return userStringInput;
    }

    public int getValidateIntegerInput(String userIntegerInput) {
        validation.verifyRepeatCount(userIntegerInput);
        return Integer.parseInt(userIntegerInput);
    }

}
