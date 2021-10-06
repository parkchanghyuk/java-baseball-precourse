package baseball.model;

import java.util.LinkedHashSet;

/**
 * @date : 2021-10-04
 * @author : 박창혁
 * @description : 컴퓨터 객체 생성
 **/
public class Computer {
	private LinkedHashSet<Integer> balls;

	public Computer() {
		this.balls = new LinkedHashSet<>();
	}

	public LinkedHashSet<Integer> getBalls() {
		return balls;
	}

	public void setBalls(LinkedHashSet<Integer> balls) {
		this.balls = balls;
	}
}
