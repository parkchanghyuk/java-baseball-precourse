package study;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.*;

/**
 * @packageName : study
 * @date : 2021-10-02
 * @author : chang
 * @description : junit 공부
**/

public class StringTest {

    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    @Test
    void numberSplitTest(){
        final String strTest = "1,2";
        assertThat(strTest.split(",")).contains("1","2");
    }

    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
    @Test
    void numberSplitTest2(){
        final String strTest = "1";
        assertThat(strTest.split(",")).containsExactly("1");
    }

    @DisplayName("문자열 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현")
    @Test
    void stringIndexOutOfBoundsExceptionTest(){
        final String strTest = "abc";
        final int position = 4;
        /*
        assertThatThrownBy(()->{
            strTest.charAt(position);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        */
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    strTest.charAt(position);
                }).withMessageMatching("String index out of range: \\d+");

    }
    @DisplayName("exception 분리")
    @Test
    void exceptionTest(){
        final String strTest = "abc";
        final int position = 4;

        Throwable thrown = catchThrowable(()->{
           strTest.charAt(position);
        });

        assertThat(thrown)
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: %s",4)
                .hasMessageEndingWith("range: 4")
                .hasMessageMatching("String index out of range: \\d+");

    }

}
