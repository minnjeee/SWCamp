// 사용자로부터 숫자 입력 받는다.
// 입력값을 100단위만 남긴다. (즉, 3421 -> 3400)
let num1 = Number(prompt('숫자를 입력하세요'));
// 방법1 : 숫자 - 100으로 나눈 나머지
let result1 = (num1 - num1%100);
// 방법2 : 100으로 나눈 몫 * 100
// 몫 구하기 : 나눈 값을 정수로 바꾸면 된다. (js에는 몫 연산자 없음)
let result2 = parseInt(num1/100) * 100;
console.log('실습1 : 입력받은 숫자를 백단위만 남기기')
console.log(result1, result2);