package baseball;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Balls {
	private final LinkedHashSet<Ball> answers;

	public Balls(List<Integer> answers) {
		LinkedHashSet<Ball> balls = mapBalls(answers);
		validation(answers, balls);
		this.answers = balls;
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
		Iterator<Ball> iterator = this.answers.iterator();
		do {
			status = iterator.next().play(ball);
		}while(status.isNothing() && iterator.hasNext());
		return status;
	}

	public PlayResult play(List<Integer> balls) {
		Balls userBalls = new Balls(balls);
		PlayResult result = new PlayResult();
		Iterator<Ball> iterator = this.answers.iterator();

		do {
			BallStatus status = userBalls.play(iterator.next());
			result.report(status);
		}while(iterator.hasNext());

		return result;
	}
}
