// 1. 데이터를 담은 배열 생성
let numList = [1,2,3,4,5,6,7,8,9];

// 2. 데이터에서 홀수인 숫자를 찾고 갯수를 세 준다.
// 홀수를 넣어줄 배열 생성하고, 갯수를 세어서 출력
let oddList = new Array();
let oddCnt=0;
for (let i of numList) {
    if (i % 2 != 0) {
        oddList[oddCnt] = i;
        oddCnt += 1;
    }
}
alert(`list에 들어있는 홀수는 ${oddList}이며, 총 ${oddCnt}개 입니다.`);