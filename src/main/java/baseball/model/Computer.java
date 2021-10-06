package baseball.model;

import java.util.Set;

/**
 * @date : 2021-10-04
 * @author : chang
 * @description : 컴퓨터 객체 생성
 **/
public class Computer {
	private Set<Integer> balls;

	public Computer() {
	}

	public Set<Integer> getBalls() {
		return balls;
	}

	public void setBalls(Set<Integer> balls) {
		this.balls = balls;
	}
}
