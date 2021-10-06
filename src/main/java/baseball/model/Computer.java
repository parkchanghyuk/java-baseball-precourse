package baseball.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2021-10-04
 * @author : chang
 * @description : 컴퓨터 객체 생성
 **/
public class Computer {
	private List<Integer> balls;

	public Computer() {
		this.balls = new ArrayList<>();
	}

	public List<Integer> getBalls() {
		return balls;
	}

	public void setBalls(List<Integer> balls) {
		this.balls = balls;
	}
}
