// 함수 실습1 : 2개 숫자 입력받아서 더하는 함수
let num1 = Number(prompt('첫 번째 숫자를 입력 해 주세요'));
let num2 = Number(prompt('두 번째 숫자를 입력 해 주세요'));

// 1. 함수 선언문 (function 함수명(파라미터) {실행문})
function addNumber(n1, n2) {
    return n1 + n2 ;
}

// 2. 함수 표현식 (const 함수명 = function(파라미터) {실행문})
const addNumber2 = function(n1,n2) {
    return n1+n2 ;
}

// 3. 화살표 함수 (const 함수명 = (파라미터) => {실행문})
const addNumber3 = (n1, n2) => {
    return n1+n2;
}

console.log('함수선언문:', addNumber(num1, num2));
console.log('함수표현식:', addNumber2(num1, num2));
console.log('화살표함수:', addNumber3(num1, num2));