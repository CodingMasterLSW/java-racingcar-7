package racingcar.domain;

import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int distance;

    private Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.distance ++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
