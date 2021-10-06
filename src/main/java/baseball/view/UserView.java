package baseball.view;

import baseball.common.MsgEnum;
import nextstep.utils.Console;

/**
 * @date : 2021-10-04
 * @author : 박창혁
 * @description : view
 **/

public class UserView {
	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 공지
	 **/
	public void comment(String msg) {
		System.out.println(msg);
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 사용자 input 받기
	 **/
	public String readLine() {
		return readLine("");
	}

	public String readLine(String msg) {
		if (!msg.isEmpty()) {
			System.out.print(msg);
		}
		return Console.readLine();
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 야구 점수
	 **/
	public void printScore(int strike, int ball) {
		this.comment(toStringStrike(strike) + toStringBall(ball) + toStringNothing(strike + ball));
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 스트라이크 문자 반환
	 **/
	private String toStringStrike(int number) {
		return number > 0 ? number + MsgEnum.STRIKE.getMsg() + " " : "";
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 스트라이크 문자 반환
	 **/
	private String toStringBall(int number) {
		return number > 0 ? number + MsgEnum.BALL.getMsg() : "";
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 스트라이크 문자 반환
	 **/
	private String toStringNothing(int number) {
		return number == 0 ? MsgEnum.NOTHING.getMsg() : "";
	}
}
