package baseball.view;

import baseball.common.MsgEnum;
import nextstep.utils.Console;

/**
 * @packageName : baseball.view
 * @date : 2021-10-04
 * @author : 박창혁
 * @description :
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
	public void score(int strike, int ball) {
		System.out.println(printStrike(strike) + printBall(ball) + printNothing(strike + ball));
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 스트라이크 출력
	 **/
	public String printStrike(int number) {
		return number > 0 ? number + MsgEnum.STRIKE.getMsg() + " " : null;
	}

	public String printBall(int number) {
		return number > 0 ? number + MsgEnum.BALL.getMsg() : null;
	}

	public String printNothing(int number) {
		return number == 0 ? MsgEnum.NOTHING.getMsg() : null;
	}
}
