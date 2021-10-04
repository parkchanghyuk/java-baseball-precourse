# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

### 야구게임 동작

1) 상대방(컴퓨터)은 1~9까지의 임의의 서로 다른 수로 이루어진 3자리 수를 생성 한다.
2) 사용자는 1~9까지의 서로 다른 3자리 수를 입력한다.
3) 컴퓨터는 사용자 입력 값에 대한 결과 값을 출력한다.
    * 스트라이크 : 컴퓨터, 사용자 숫자의 각 자릿수에 대해 숫자와 위치가 전부 일치하는 경우
    * 볼 : 컴퓨터, 사용자 숫자의 각 자릿수에 대해 숫자는 맞지만 위치가 일치하지 경우
    * 낫싱 : 컴퓨터, 사용자의 숫자의 각 자릿수에 대해 숫자, 위치 모두 일치하지 않을 경우
4) 2번 3번 반복 후 사용자가 입력한 숫자와 컴퓨터의 숫자가 일치하는 경우 게임을 종료한다.
5) 게임 종료 후 사용자는 게임 재시작, 완전종료 중 선택한다.

### 구현

* #### 데이터 생성
    * 1~9까지의 임의의 겹치지 않은 세 자리 숫자 생성
* #### 게임 시작
    * 사용자 입력에 대한 스트라이크, 볼, 낫싱 정보 출력
        * 예시)
            * 컴퓨터 : 132, 사용자 : 426 > 1볼
            * 컴퓨터 : 132, 사용자 : 123 > 1 스트라이트 2볼
            * 컴퓨터 : 132, 사용자 : 786 > 낫싱
    * 게임 종료 후 게임 재시작 여부 출력

* #### 게임 종료
    * 재시작(1) 입력 시 게임 재시작
    * 종료(2) 입력 시 프로그램 종료

* #### 오류 처리
    * 사용자입력
        * 게임 도중 0을 제외한 1~9로 이루어진 서로다른 세 자리의 숫자만 입력했는지 확인
        * 게임 종료 후 1,2 숫자만 입력했는지 확인 
    






