package baseball.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import baseball.common.BaseballUtil;
import baseball.common.Const;
import baseball.common.ErrMsgEnum;
import baseball.common.GameStatEnum;
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
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 야구 게임
	 **/
	public void baseballGame() {
		do {
			userView.comment(MsgEnum.WELCOME.getMsg()); // 시작
			initRandomBalls(); // 난수 생성
		} while (GameStatEnum.GAME_START == gameStart()); // 게임 시작
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : random 숫자 생성
	 **/
	private void initRandomBalls() {
		computer = new Computer();
		LinkedHashSet<Integer> randomList = computer.getBalls();
		while (randomList.size() < Const.NUMBER_MAX_DIGITS) {
			addNonDuplicateNumbers(randomList);
		}
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 생성된 랜덤 숫자 중복되지 않을 경우 리스트에 add
	 **/
	private void addNonDuplicateNumbers(LinkedHashSet<Integer> randomSet) {
		//랜덤 숫자 생성
		int random = Randoms.pickNumberInRange(Const.START_NUM, Const.END_NUM);
		randomSet.add(random);
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 시작
	 **/
	private GameStatEnum gameStart() {
		userView.comment(MsgEnum.INFO.getMsg());
		String userInput;
		do {
			userInput = userView.readLine(MsgEnum.INPUT.getMsg());
		} while (GameStatEnum.IN_GAME == gameProcess(userInput));
		return gameReStart();
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 유효성 체크, 점수 체크. 3 스트라이크일 경우에만
	 **/
	private GameStatEnum gameProcess(String input) {
		if (validateInGame(input) || checkScore(input)) {
			return GameStatEnum.IN_GAME;
		}
		return GameStatEnum.GAME_OVER;
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 유효성 체크
	 **/
	private boolean validateInGame(String input) {
		try {
			validateNumberSize(input);
			validateNumberRange(input);
			validateDupNumber(input);

		} catch (Exception e) {
			userView.comment(e.getMessage());
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 숫자 중복 체크. Set으로 중복 제거 후 크기 비교
	 **/
	private void validateDupNumber(String input) throws Exception {
		Set<Integer> duplicate = new HashSet<>();
		for (char number : input.toCharArray()) {
			duplicate.add(Character.getNumericValue(number));
		}

		if (duplicate.size() != Const.NUMBER_MAX_DIGITS) {
			throw new UserException(ErrMsgEnum.NON_DUPLICATE_NUMBERS.getMsg());
		}
	}

	/**
	 * @date : 2021-10-05
	 * @author : 박창혁
	 * @description : 게임 종료 유효성 체크
	 **/
	private boolean validateGameReStart(String input) {
		try {
			validateGameCode(input);
		} catch (Exception e) {
			userView.comment(e.getMessage());
			return true;
		}
		return false;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 게임 코드 유효성 (사이즈, 존재여부)
	 **/
	private void validateGameCode(String input) throws UserException {
		if (input.length() != Const.CODE_MAX_DIGITS) {
			throw new UserException(ErrMsgEnum.CODE_SIZE.getMsg());
		}

		if (!GameStatEnum.GAME_START.getCode().equals(input) && !GameStatEnum.GAME_OVER.getCode().equals(input)) {
			throw new UserException(ErrMsgEnum.RANGE.getMsg());
		}
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 게임 종료 유효성 체크
	 **/
	private GameStatEnum gameReStart() {
		String userInput;
		userView.comment(MsgEnum.GAME_OVER.getMsg());
		do {
			userInput = userView.readLine(MsgEnum.INPUT.getMsg());
		} while (validateGameReStart(userInput));
		return GameStatEnum.GAME_START.getCode().equals(userInput) ? GameStatEnum.GAME_START : GameStatEnum.GAME_OVER;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 범위 체크
	 **/
	private void validateNumberRange(String balls) throws UserException {
		String pattern = "^[" + Const.START_NUM + "-" + Const.END_NUM + "]{" + Const.NUMBER_MAX_DIGITS + "}$";
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
		if (balls.length() != Const.NUMBER_MAX_DIGITS) {
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
		return strike != Const.NUMBER_MAX_DIGITS;
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
			count += BaseballUtil.numberComparison(iter.next(), Integer.parseInt(input.substring(idx, (idx++) + 1)));
		}
		return count;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 숫자 포함 개수 체크
	 **/
	private int getNumberOfContains(String input) {
		int count = 0;
		for (char target : input.toCharArray()) {
			count += BaseballUtil.numberContains(computer.getBalls(), Character.getNumericValue(target));
		}
		return count;
	}

}
