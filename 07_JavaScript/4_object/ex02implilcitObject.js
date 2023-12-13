// 내장 객체 : 자바스트립트에서 제공하는 객체
// Math, Date, Array 등
    // Array는 인덱스를 key, 값을 value로 객체로 볼 수 있음
    // let 변수 = new Array() -> new는 객체 생성자!

// Date 내장 객체
let today = new Date(); // 오늘날짜
console.log(today);

let yesterday = new Date(2023, 4, 9); // Date(년, 월-1, 일)
console.log(yesterday); 

let tYear = today.getFullYear(); // 연도
console.log(tYear);
let tMonth = today.getMonth() + 1; // 월, 0~11로 반환하여 +1 해주기
let tDate = today.getDate(); // 일
let tDay = today.getDay(); // 요일, 0(일)~6(토)로 반환

switch(tDay) {
    case 0 : tDay = '일'; break;
    case 1 : tDay = '월'; break;
    case 2 : tDay = '화'; break;
    case 3 : tDay = '수'; break;
    case 4 : tDay = '목'; break;
    case 5 : tDay = '금'; break;
    case 6 : tDay = '토'; break;
}

// 0000년 00월 00일 00요일 00시 00분 00초 입니다.
console.log(`${today.getFullYear()}년 ${today.getMonth()+1}월 ${today.getDate()}일 ${tDay}요일 ${today.getHours()}시 ${today.getMinutes()}분 ${today.getSeconds()}초 입니다.`);

