package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    private InputParser inputParser = InputParser.create();


    @DisplayName("사용자의 입력이 주어졌을 때, SPLITTER 기준으로 나눈 후, List로 반환한다")
    @Test
    void user_input_split() {

        //given
        String userInput = "pobi,woni,jun";

        //when
        List<String> userSplitter = inputParser.split(userInput);

        //then
        assertThat(userSplitter.size()).isEqualTo(3);
        assertThat(userSplitter.get(0)).isEqualTo("pobi");
        assertThat(userSplitter.get(1)).isEqualTo("woni");
        assertThat(userSplitter.get(2)).isEqualTo("jun");

    }

}
