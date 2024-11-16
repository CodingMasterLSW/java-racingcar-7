package racingcar.utils;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private RandomNumber() {
    }

    public static RandomNumber create() {
        return new RandomNumber();
    }

    public List<Integer> generate(int numberSize) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i=0; i<numberSize; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return randomNumbers;
    }


}
