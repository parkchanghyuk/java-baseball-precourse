package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.common.Const;
import nextstep.utils.Randoms;

public class BaseballTest {
	private LinkedHashSet<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new LinkedHashSet<>();
		while (numbers.size() < Const.NUMBER_MAX_DIGITS) {
			numbers.add(Randoms.pickNumberInRange(Const.START_NUM, Const.END_NUM));
		}
	}

	@DisplayName("중복코드 테스트")
	@ParameterizedTest
	@ValueSource(ints = {11, 22, 33, 44, 55, 66, 77, 88, 99})
	void contains(int input) {
		assertThat(numbers.contains(input)).isFalse();
	}
}
