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
