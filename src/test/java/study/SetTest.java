package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
		// 클래스 내에 존재하는 각각의 @Test 를 실행하기 전에 매번 실행
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("numbers 사이즈 체크")
	@Test
	void sizeTest() {
		assertThat(this.numbers.size())
			.isNotZero()
			.hasToString("3");
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현" +
		"ParameterizedTest를 이용한 중복 코드 제거")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현" +
		"CsvSouce를 이용하여 예상되는 결과값 체크")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains2(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}

}
