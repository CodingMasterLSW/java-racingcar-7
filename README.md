# 자동차

## 입력
- [x] 경주할 자동차를 입력받는다
  - Exception
    - [x] 입력이 없다면, 예외를 발생시킨다
    
- [x] 시도할 횟수를 입력받는다
  - Exception
    - [x] 0보다 작다면, 예외를 발생시킨다
    - [x] 숫자가 아니라면, 예외를 발생시킨다
  
## 입력값 파싱
- [x] 입력받은 자동차를 ','를 기준으로 나눈다
- [x] 나눈 값을 List로 반환한다

## 자동차 생성
- [x] 자동차를 생성한다
  - Exception
    - [x] 자동차 이름이 5를 초과한다면, 예외를 발생시킨다

## 랜덤 번호 생성
- [x] 0~9의 랜덤한 번호를 생성한다
- [x] 자동차 수 만큼 랜덤한 번호를 생성한다

## 경주
- [ ] 생성한 번호가 4이상일 경우, 자동차를 한 칸 움직인다

## 우승자
- [ ] 가장 많이 움직인 자동차를 찾는다

## 출력
- [ ] 경주 실행 결과를 전부 출력한다
- [ ] 우승자를 출력한다
  - [ ] 공동우승자의 경우, 전부 출력한다