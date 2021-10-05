package baseball.view;

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
			System.out.print("");
		}
		return Console.readLine();
	}
}
