package baseball.common;

/**
 * @date : 2021-10-04
 * @author : 박창혁
 * @description : 오류 메시지 
 **/
public enum ErrMsgEnum {
	SIZE("3자리의 숫자만 입력 가능합니다."),
	RANGE(Const.START_NUM + "~" + Const.END_NUM + "까지의 숫자만 입력 가능합니다."),
	NON_DUPLICATE_NUMBERS("숫자가 중복되었습니다.");

	String msg;

	ErrMsgEnum(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}
}
