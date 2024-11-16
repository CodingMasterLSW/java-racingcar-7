package racingcar.view;

import static racingcar.exception.ErrorMessage.INVALID_INPUT;
import static racingcar.exception.ErrorMessage.ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String racingCarNameInput() {
        return inputAndValidate();
    }

    public void printInputMessage() {
        printMessage(CAR_INPUT_MESSAGE);
    }

    public int tryNumberInput() {
        String userInput = Console.readLine();
        validateEmptyInput(userInput);
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public void printTryNumberMessage() {
        printMessage(TRY_NUMBER_INPUT_MESSAGE);
    }

    private String inputAndValidate() {
        String userInput = Console.readLine();
        validateEmptyInput(userInput);
        return userInput;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void validateEmptyInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

    }

    private void validateNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
        }

        int userNumber = Integer.parseInt(userInput);
        if (userNumber <= 0) {
            throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
        }
    }

}
