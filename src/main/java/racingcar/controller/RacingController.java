package racingcar.controller;

import java.util.List;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void start() {
        inputView.printInputMessage();
        String userInput = inputView.racingCarNameInput();

        inputView.printTryNumberMessage();
        inputView.tryNumberInput();

        racingService.initCarManager(userInput);

        List<Integer> numbers = racingService.generateRandomNumbers();
        racingService.racing(numbers);

    }

}
