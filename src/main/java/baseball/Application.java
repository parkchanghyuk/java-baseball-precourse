package baseball;

import baseball.controller.BaseballGameController;

public class Application {
	public static void main(String[] args) {
		// 야구게임 시작
		new BaseballGameController().baseballGame();
	}
}
