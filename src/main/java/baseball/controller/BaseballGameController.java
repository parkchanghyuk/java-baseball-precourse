package baseball.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import baseball.common.Const;
import baseball.common.ErrMsgEnum;
import baseball.common.MsgEnum;
import baseball.model.Computer;
import baseball.view.UserView;
import nextstep.utils.Randoms;

/**
 * @date : 2021-10-05
 * @author : 박창혁
 * @description : 야구게임 기능
 **/
public class BaseballGameController {

	private UserView userView;
	private Computer computer;

	/**
	 * @packageName : baseball.controller
	 * @date : 2021-10-05
	 * @author : chang
	 * @description : 야구 게임
	 **/
	public void baseballGame() {
		boolean stat;
		do {
			userView.comment(MsgEnum.WELCOME.getMsg());
			// 난수 생성
			initRandomBalls();
			// 게임 시작
			stat = gameStart();
		} while (stat);
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : random 숫자 생성
	 **/
	private void initRandomBalls() {
		Set<Integer> randomSet = new HashSet<>();
		while (randomSet.size() <= Const.MAX_DIGITS) {
			addNonDuplicateNumbers(randomSet);
		}
		//computer 객체에 set
		computer.setBalls(randomSet);
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 생성된 랜덤 숫자 중복되지 않을 경우 리스트에 add
	 **/
	private void addNonDuplicateNumbers(Set<Integer> randomSet) {
		//랜덤 숫자 생성
		int random = Randoms.pickNumberInRange(Const.START_NUM, Const.END_NUM);
		//list에 동일 숫자 포함 확인
		if (!randomSet.contains(random)) {
			randomSet.add(random);
		}
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 시작
	 **/
	private boolean gameStart() {
		boolean stat;
		String userInput;
		do {
			//사용자 input
			userInput = userView.readLine(MsgEnum.ING.getMsg());
			//validation 체크
			stat = checkGameStart(userInput);
		} while (stat);
		return false;
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 시작 유효성 체크. true 일 경우 게임진행, false 일 경우 게임 종료
	 **/
	private boolean checkGameStart(String input) {
		// number 사이즈 체크
		if (checkNumberSize(input)) {
			userView.readLine(ErrMsgEnum.SIZE.getMsg());
			return true;
		}
		// 1~9까지의 숫자 체크
		if (checkNumberRange(input)) {
			userView.readLine(ErrMsgEnum.RANGE.getMsg());
			return true;
		}
		// 스트라이크, 볼, 낫싱 체크
		if (checkBaseballContains(input)) {
			userView.readLine(ErrMsgEnum.RANGE.getMsg());
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 종료 유효성 체크
	 **/
	private boolean checkGameReStart(String input) {
		// number 사이즈 체크
		if (checkNumberSize(input)) {
			userView.readLine(ErrMsgEnum.SIZE.getMsg());
			return true;
		}
		// 1~9까지의 숫자 체크
		if (checkNumberRange(input)) {
			userView.readLine(ErrMsgEnum.RANGE.getMsg());
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 범위 체크
	 **/
	private boolean checkNumberRange(String balls) {
		String pattern = "[" + Const.START_NUM + "-" + Const.END_NUM + "]";
		boolean valid = true;
		int i = 0;
		do {
			valid = Pattern.matches(pattern, balls.substring(i, i + 1));
		} while (valid && ++i < Const.MAX_DIGITS);
		return valid;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : number 사이즈 체크
	 **/
	private boolean checkNumberSize(String balls) {
		return balls.length() != Const.MAX_DIGITS;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 점수 체크 
	 **/
	private boolean checkBaseballContains(String input) {
		int strike = 0;
		int ball = 0;
		strike = getBallsStrick(input);
		ball = getBallsContailns(input) - strike;
		return strike == Const.MAX_DIGITS;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description :  스트라이크 체크 
	 **/
	private int getBallsStrick(String input) {
		return 0;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 볼 체크  
	 **/
	private int getBallsContailns(String input) {
		return 0;
	}

}
