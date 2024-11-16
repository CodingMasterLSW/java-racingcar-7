package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    private InputView inputView = InputView.create();

    public void start() {
        inputView.printInputMessage();
        inputView.racingCarNameInput();

        inputView.printTryNumberMessage();
        inputView.tryNumberInput();
    }

}
