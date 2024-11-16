package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RUN_RESULT_MESSAGE = "실행 결과";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printRunResultMessage() {
        printBlank();
        printMessage(RUN_RESULT_MESSAGE);
    }

    public void printRacingResult(List<Car> racingResult) {
        for (Car car : racingResult) {
            System.out.print(car.getName()+ " : " + car.getDistance());
            printBlank();
        }
        printBlank();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printBlank(){
        System.out.println();
    }

}
