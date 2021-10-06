package baseball.controller;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import baseball.common.Const;
import baseball.common.ErrMsgEnum;
import baseball.common.MsgEnum;
import baseball.exception.UserException;
import baseball.model.Computer;
import baseball.view.UserView;
import nextstep.utils.Randoms;

/**
 * @date : 2021-10-05
 * @author : 박창혁
 * @description : 야구게임 기능
 **/
public class BaseballGameController {

	private final UserView userView = new UserView();
	private Computer computer;

	/**
	 * @packageName : baseball.controller
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 야구 게임
	 **/
	public void baseballGame() {
		do {
			initRandomBalls(); // 난수 생성
		} while (gameStart()); // 게임 시작
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : random 숫자 생성
	 **/
	private void initRandomBalls() {
		computer = new Computer();
		List<Integer> randomList = computer.getBalls();
		while (randomList.size() < Const.MAX_DIGITS) {
			addNonDuplicateNumbers(randomList);
		}
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 생성된 랜덤 숫자 중복되지 않을 경우 리스트에 add
	 **/
	private void addNonDuplicateNumbers(List<Integer> randomSet) {
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
		String userInput;
		do {
			userInput = userView.readLine(MsgEnum.ING.getMsg());
		} while (checkGameStart(userInput));
		return gameReStart();
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 시작 유효성 체크. true 일 경우 게임진행, false 일 경우 게임 종료
	 **/
	private boolean checkGameStart(String input) {
		if (validateGame(input)) {
			return true;
		}
		if (checkScore(input)) {
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 유효성 체크
	 **/
	private boolean validateGame(String input) {
		try {
			validateNumberSize(input);
			validateNumberRange(input);
		} catch (Exception e) {
			userView.comment(e.getMessage());
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 종료 유효성 체크
	 **/
	private boolean validateGameReStart(String input) {
		try {
			validateRestart(input);
		} catch (Exception e) {
			userView.comment(e.getMessage());
			return true;
		}
		return false;
	}

	private void validateRestart(String input) throws Exception {
		if (input.length() != 1) {
			throw new UserException(ErrMsgEnum.SIZE.getMsg());
		}

		if (!"1".equals(input) && !"2".equals(input)) {
			throw new UserException(ErrMsgEnum.RANGE.getMsg());
		}
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 게임 종료 유효성 체크
	 **/
	private boolean gameReStart() {
		String userInput;
		do {
			userInput = userView.readLine(MsgEnum.GAME_OVER.getMsg());
		} while (validateGameReStart(userInput));
		return userInput.equals("1");
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 범위 체크
	 **/
	private void validateNumberRange(String balls) throws UserException {
		String pattern = "^[" + Const.START_NUM + "-" + Const.END_NUM + "]{" + Const.MAX_DIGITS + "}$";
		if (!Pattern.matches(pattern, balls)) {
			throw new UserException(ErrMsgEnum.RANGE.getMsg());
		}
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : number 사이즈 체크
	 **/
	private void validateNumberSize(String balls) throws UserException {
		if (balls.length() != Const.MAX_DIGITS) {
			throw new UserException(ErrMsgEnum.SIZE.getMsg());
		}
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 점수 체크
	 **/
	private boolean checkScore(String input) {
		int strike = getNumberOfStrikes(input);
		int ball = getNumberOfContains(input) - strike;
		userView.printScore(strike, ball);
		return strike != Const.MAX_DIGITS;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description :  스트라이크 체크
	 **/
	private int getNumberOfStrikes(String input) {
		Iterator<Integer> iter = computer.getBalls().iterator();
		int count = 0;
		int idx = 0;
		while (iter.hasNext()) {
			count += numberEquals(iter.next(), Integer.parseInt(input.substring(idx, idx + 1)));
			idx++;
		}
		return count;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 숫자 비교. 성공 시 1, 실패 시 2 반환
	 **/
	private int numberEquals(int standard, int target) {
		return standard == target ? 1 : 0;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description :
	 **/
	private int getNumberOfContains(String input) {
		int count = 0;
		for (char target : input.toCharArray()) {
			count += numberContains(computer.getBalls(), Character.getNumericValue(target));
		}
		return count;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 숫자 비교. 성공 시 1, 실패 시 2 반환
	 **/
	private int numberContains(List<Integer> standard, int target) {
		return standard.contains(target) ? 1 : 0;
	}
}
