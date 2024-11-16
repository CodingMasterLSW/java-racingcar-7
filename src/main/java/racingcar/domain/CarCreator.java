package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {

    private CarCreator(){
    }

    public static CarCreator create() {
        return new CarCreator();
    }

    public List<Car> generate(List<String> userNames) {
        List<Car> tmpCars = new ArrayList<>();
        for (String userName : userNames) {
            Car car = Car.from(userName);
            tmpCars.add(car);
        }
        return tmpCars;
    }


}
