package racingcar.utils;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private RandomNumber() {
    }

    public static RandomNumber create() {
        return new RandomNumber();
    }

    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

}
