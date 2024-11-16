package racingcar.utils;

import java.util.List;

public class InputParser {

    private static final String SPLITTER = ",";

    private InputParser() {
    }

    public static InputParser create() {
        return new InputParser();
    }

    public List<String> split(String userInput) {
        return List.of(userInput.split(SPLITTER));
    }
}
