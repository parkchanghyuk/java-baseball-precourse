package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Balls {
	private final LinkedHashSet<Ball> balls;

	public Balls(List<Integer> answers) {
		this.balls = mapBalls(answers);
	}

	private LinkedHashSet<Ball> mapBalls(List<Integer> answers) {
		LinkedHashSet<Ball> balls = new LinkedHashSet<>();
		for(Integer answer : answers){
			balls.add(new Ball(answers.indexOf(answer) + 1, answer));
		}
		return balls;
	}

	public BallStatus play(Ball ball) {
		BallStatus status;
		Iterator<Ball> iterator = balls.iterator();
		do {
			status = iterator.next().play(ball);
		}while(status.isNothing() && iterator.hasNext());
		return status;
	}
}
