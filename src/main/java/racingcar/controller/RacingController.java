package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
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
        manageCarInput();
        int tryNumber = manageTryNumberInput();

        playRacing(tryNumber);
        winner();
    }

    private void manageCarInput() {
        inputView.printInputMessage();
        retryOnInvalidInput(() -> {
            String userInput = inputView.racingCarNameInput();
            racingService.initCarManager(userInput);
            return null;
        });
    }

    private int manageTryNumberInput() {
        inputView.printTryNumberMessage();
        int tryNumber = retryOnInvalidInput(() -> inputView.tryNumberInput());
        return tryNumber;
    }

    private void playRacing(int tryNumber) {
        outputView.printRunResultMessage();
        for (int i=0; i<tryNumber; i++) {
            List<Integer> numbers = racingService.generateRandomNumbers();
            List<Car> racingResult = racingService.racing(numbers);
            outputView.printRacingResult(racingResult);
        }
    }

    private void winner(){
        List<String> winner = racingService.winner();
        outputView.printWinnerResult(winner);
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
