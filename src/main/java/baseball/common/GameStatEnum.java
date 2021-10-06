package baseball.common;

/**
 * @date : 2021-10-06
 * @author : 박창혁
 * @description : 게임 코드
 **/
public enum GameStatEnum {
	GAME_START("1"),
	GAME_OVER("2"),
	IN_GAME("I");

	String code;

	GameStatEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
