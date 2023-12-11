// 배열 : 여러 변수를 하나의 묶음으로 다루는 구조
let numlist = []; // 빈 배열 선언
console.log(numlist);

let numlist2 = new Array(5);
console.log(numlist2);
// 5개로 선언했어도 초과 가능 -> 공간이 동적/가변적

let numlist3 = new Array(1,2,3,4,5);
console.log(numlist3);
console.log('길이는',numlist3.length);

numlist3 = [1,2,3,4,5,6];
console.log(numlist3);
console.log('3번째요소는',numlist3[2]);

numlist3[6] = 7 // 인덱스위치 6에 값 7을 추가 (값추가 가능)
console.log(numlist3);

let numlist4 = [] ;
numlist4[0] = 1;
numlist4[1] = '가나다라';
numlist4[3] = true; // 2번째 요소는 자리가 비워진 상태로 유지
console.log(numlist4);