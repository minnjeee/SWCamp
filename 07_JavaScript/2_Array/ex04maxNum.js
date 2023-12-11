// 1. 데이터를 담은 배열 생성
let numList = [23, 54, 78, 13, 44];

// 2. 최대값을 찾아서 출력
    // alert를 이용해서 '최대값>>숫자'로 출력하기
let maxNum = numList[0];
for (let i of numList) {
    if (i > maxNum) {
        maxNum = i;
    }
}
alert(`최대값>>${maxNum}`);