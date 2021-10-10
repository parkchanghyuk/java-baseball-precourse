package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {
	private Balls com;

	@BeforeEach
	void setUp() {
		com = new Balls(Arrays.asList(1,2,3));
	}

	@Test
	void play_3strike(){
		PlayResult result = com.play(Arrays.asList(1,2,3));
		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	void play_3ball(){
		PlayResult result = com.play(Arrays.asList(3,1,2));
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(3);
	}

	@Test
	void play_1strike_1ball(){
		PlayResult result = com.play(Arrays.asList(1,3,6));
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	void play_1strike_2ball(){
		PlayResult result = com.play(Arrays.asList(1,3,2));
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(2);
	}

	@Test
	void ball(){
		BallStatus status = com.play(new Ball(1,2));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@Test
	void strike(){
		BallStatus status = com.play(new Ball(1,1));
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void nothing(){
		BallStatus status = com.play(new Ball(1,6));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}
}
