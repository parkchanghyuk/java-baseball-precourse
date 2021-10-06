package baseball.common;

/**
 * @date : 2021-10-04
 * @author : 박창혁
 * @description : 공통 메시지
 **/
public enum MsgEnum {
	READY("게임에 참가를 원하십니까? 참가를 원하시면 1번을, 아니면 2번을 눌러주세요."),
	WELCOME("이 자리에 오신 여러분을 진심으로 환영합니다."),
	ING("1~9까지의 서로 다른 수로 이루어진 3자리 수를 입력해주세요 : "),
	GAME_OVER("게임 끝. 게임을 다시 시작하시려면 1번을 종료하시려면 2번을 입력해 주세요."),
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	String msg;

	MsgEnum(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
