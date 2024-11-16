package racingcar.exception;

public enum ErrorMessage {

    INVALID_INPUT("입력을 하지 않았습니다. 다시 입력해주세요."),
    ONLY_NUMBER("양의 정수만 입력 가능합니다. 다시 입력해주세요."),
    INVALID_CAR_NAME_LENGTH("자동차의 이름은 최대 5글자 입니다. 다시 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
