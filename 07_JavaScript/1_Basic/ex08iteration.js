// 반복문 : 어떤 조건을 만족할 때까지 같은 처리를 반복하여 실행하는 구문

// 1. while문
console.log('------ while문 ------');

// while (조건식) {조건이 참일 경우 반복할 실행문}
console.log('num1');
let num1 = 0;
while (num1 < 3) {
    console.log(num1);
    num1++;
}

console.log('num2');
let num2 = 3;
while(true) {
    console.log(num2);
    num2++;
    if (num2 > 6) break;
}


let num3 = 9;
console.log('num3')
while (num3 < 9) {
    console.log('while문',num3);
}

// 2. do while문
console.log('------ do while문 ------');

console.log('num3')
do {
    console.log('do-while문',num3);
} while(num3 < 9)


// 3. for 문
console.log('------ for문 ------');

// for (초기값; 조건; 증감식) {조건이 참일 때 반복할 실행문}

console.log('num4')
for (let num4=9; num4<12; num4++) { // 안에서 변수 선언 가능
    console.log(num4);
}