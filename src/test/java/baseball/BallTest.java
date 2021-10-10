package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

	private Ball com;

	@BeforeEach
	void setUp() {
		com = new Ball(1,2);
	}

	@Test
	void strike(){
		BallStatus status = com.play(new Ball(1,2));
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void ball(){
		BallStatus status = com.play(new Ball(2,2));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@Test
	void nothing(){
		BallStatus status = com.play(new Ball(1,3));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}
}
