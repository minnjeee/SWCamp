// 문자 -> 숫자 변환
let pi = '3.1417';
console.log(typeof(pi));
console.log('문자->실수', parseFloat(pi));
// parseFloat : 실수로 변환시킴
console.log(typeof(parseInt(pi)));
// parseInt : 정수로 변환
console.log('문자 -> 정수', parseInt(pi));
console.log('문자->숫자', Number(pi));

let str = '11';
console.log(parseInt(str));
console.log(Number(str));//

// 숫자 -> 문자로 변환
let num3 = 100;
console.log('숫자->문자', String(num3));
console.log(num3.toString());


// 실습
// 각각 값이 '100' 200 인 num1, num2를
// 형변환하여 아래와 같은 결과를 출력하시오
console.log('형변환 실습 : "100"과 200 더하기')
let num1 = '100';
let num2 = 200 ;
console.log(num1 + '과 ' + num2 +  '의 합 >> ' + (Number(num1)+num2))
console.log(`${num1}과 ${num2}의 합 >> ${Number(num1)+num2}`)

// 실습
// prompt로 숫자 2개를 입력받아서 문서에 '숫자1과 숫자2의 합은 sum입니다.' 라고 출력
let n1, n2;
n1 = Number(prompt('숫자1을 입력하세요.'));
n2 = Number(prompt('숫자2를 입력하세요.'));
document.write(`${n1}과 ${n2}의 합은 ${n1+n2}입니다.`);