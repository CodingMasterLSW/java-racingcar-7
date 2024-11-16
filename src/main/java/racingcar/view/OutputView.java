package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String HISTOGRAM = "-";
    private static final String RACING_RESULT = "%s : %s";

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
            System.out.printf(RACING_RESULT, car.getName(), convertToHistogram(car.getDistance()));
            printBlank();
        }
        printBlank();
    }

    public void printWinnerResult(List<String> winners) {
        System.out.printf(WINNER_MESSAGE, String.join(", ", winners));
    }

    private String convertToHistogram(int distance) {
        return HISTOGRAM.repeat(distance);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printBlank() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
