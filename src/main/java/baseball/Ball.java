package baseball;

import java.util.Objects;

public class Ball {

	private final int position;
	private final int ballNo;

	public Ball(int position, int ball) {
		this.position = position;
		this.ballNo = ball;
	}

	public BallStatus play(Ball ball) {
		if(this.equals(ball)){
			return BallStatus.STRIKE;
		}

		if(ball.matchBallNo(this.ballNo)){
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean matchBallNo(int ballNo) {
		return this.ballNo == ballNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return position == ball.position && ballNo == ball.ballNo;
	}
}
