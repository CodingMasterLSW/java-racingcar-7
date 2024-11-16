package racingcar.controller;

import racingcar.domain.CarCreator;
import racingcar.service.RacingService;
import racingcar.utils.InputParser;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public static RacingService createRacingService() {
        return new RacingService(CarCreator.create(), InputParser.create(), RandomNumber.create());
    }

    public static RacingController createRacingController() {
        return new RacingController(InputView.create(), OutputView.create(), createRacingService());
    }


}
