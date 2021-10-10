package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Balls {
	private final LinkedHashSet<Ball> balls;

	public Balls(List<Integer> answers) {
		LinkedHashSet<Ball> balls = mapBalls(answers);
		validation(answers, balls);
		this.balls = balls;
	}

	private LinkedHashSet<Ball> mapBalls(List<Integer> answers) {
		LinkedHashSet<Ball> balls = new LinkedHashSet<>();
		for(Integer answer : answers){
			balls.add(new Ball(answers.indexOf(answer) + 1, answer));
		}
		return balls;
	}

	private void validation(List<Integer> answers, LinkedHashSet<Ball> balls) {
		if(answers == null || answers.size() != BallConst.NUMBER_SIZE){
			throw new IllegalArgumentException(BallConst.NUMBER_SIZE+"자리의 숫자를 입력해주시기 바랍니다.");
		}
		if(answers.size() != balls.size()){
			throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
		}
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
