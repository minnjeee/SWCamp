// 카페 메뉴 입력받기
let cafeMenu = prompt('어떤 음료로 하시겠어요?');

// 조건1 : 아메리카노이면 바로 나오고, 아니면 대기시간 5분.
// 조건 ? 참일 때 : 거짓일 때 ;
document.write('<strong>조건1 : 아메리카노이면 바로 나오고, 아니면 대기시간 5분.</strong> <br/>');
cafeMenu == "아메리카노"
? document.write('주문하신 메뉴 나왔습니다.')
: document.write(`${cafeMenu}는 대기시간 5분입니다.`);

document.write('<br/><br/>');

// 조건2 : (조건추가) 딸기라떼는 시즌아웃 (겨울한정메뉴)
// if (조건문) {참일 때 실행문} else if (조건문) {참일 때 실행문} else {그 외일 때 실행문};
document.write('<strong>조건2 : 아메리카노는 바로, 딸기라떼는 시즌아웃(겨울한정메뉴), 나머지는 5분 대기시간.</strong> <br/>');
if (cafeMenu ==  "아메리카노") {
    document.write('주문하신 메뉴 나왔습니다.');
} else if (cafeMenu == "딸기라떼") {
    document.write('겨울 한정 메뉴입니다.');
} else {
    document.write(`${cafeMenu}는 대기시간 5분입니다.`);
}
// 딸기라떼인 경우 겨울 한정 메뉴 출력
// 조건문 && 참일 때 실행문
cafeMenu == "딸기라떼" && document.write('겨울 한정 메뉴');

document.write('<br/><br/>');

// 조건3 : 메뉴 4개(아메리카노, 카페라떼, 카라멜마끼아또, 딸기라떼), 각 메뉴마다 대기시간 다르게 출력, 딸기메뉴는 겨울한정메뉴
// switch (조건대상) {case 상태1 : 실행문1; break; case 상태2:실행문2; break;}
document.write('<strong>조건3 : 메뉴는 아메리카노, 카페라떼, 카라멜마끼아또, 딸기라떼 중 선택, 대기시간은 각 음료마다 다름.</strong> <br/>');
switch(cafeMenu) {
    case "아메리카노" :
        document.write('주문하신 메뉴 나왔습니다.');
        break;
    case "카페라떼" :
        document.write('카페라떼는 대기시간 3분입니다.');
        break;
    case "카라멜마끼아또" :
        document.write('카라멜 마끼아또는 대기시간 4분입니다.');
        break;
    case "딸기라떼":
        document.write('딸기라떼는 겨울 한정 메뉴입니다.');
        break;
}

