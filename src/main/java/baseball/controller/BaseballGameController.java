package baseball.controller;

import java.util.HashSet;
import java.util.Set;

import baseball.common.Const;
import baseball.model.Computer;
import baseball.view.UserInputView;
import nextstep.utils.Randoms;

/**
 * @date : 2021-10-05
 * @author : 박창혁
 * @description : 야구게임 기능
 **/
public class BaseballGameController {

	private UserInputView userInputView;
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
		do {
			stat = false;
		} while (stat);
		return false;
	}

}
