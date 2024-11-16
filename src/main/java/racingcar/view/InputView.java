package racingcar.view;

import static racingcar.exception.ErrorMessage.INVALID_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String racingCarNameInput() {
        return inputAndValidate();
    }

    public void printInputMessage() {
        printMessage(INPUT_MESSAGE);
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

}
