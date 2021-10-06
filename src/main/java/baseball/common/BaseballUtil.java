package baseball.common;

import java.util.LinkedHashSet;

/**
 * @date : 2021-10-06
 * @author : 박창혁
 * @description : 야구 공통 util 정리
 **/
public class BaseballUtil {
	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : 숫자 비교. 성공 시 1, 실패 시 2 반환
	 **/
	public static int numberComparison(int standard, int target) {
		return standard == target ? 1 : 0;
	}

	/**
	 * @date : 2021-10-06
	 * @author : 박창혁
	 * @description : set 숫자 비교. 성공 시 1, 실패 시 2 반환
	 **/
	public static int numberContains(LinkedHashSet<Integer> standard, int target) {
		return standard.contains(target) ? 1 : 0;
	}
}
