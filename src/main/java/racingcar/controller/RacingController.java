package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;


    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void start() {
        inputView.printInputMessage();
        String userInput = inputView.racingCarNameInput();

        inputView.printTryNumberMessage();
        int tryNumber = inputView.tryNumberInput();

        racingService.initCarManager(userInput);

        outputView.printRunResultMessage();

        for (int i=0; i<tryNumber; i++) {
            List<Integer> numbers = racingService.generateRandomNumbers();
            List<Car> racingResult = racingService.racing(numbers);
            outputView.printRacingResult(racingResult);
        }

    }

}
