// 함수 : 특정 기능을 수행하는 소스코드를 하나로 묶어서 필요할 때마다 사용하기 위한 구조
// 파이썬의 경우 -> def function ~~~
// 자바스크립트의 경우 -> function 함수명() {소스코드}
function 소개() {
    document.write('SW반에서 요정을 맡은 김동현입니다.<br>');
}
소개(); // 함수 호출

// 매개변수
function 함수(파라미터){
    document.write(`SW반에서 비주얼을 담당하고 있는 ${파라미터}입니다.<br>`);
}
함수('신희진');
함수('서민국');

// 매개변수 + return
function 함수2(파라미터){
    return `SW반에서 귀여움을 맡고 있는 ${파라미터}입니다.`
}
함수2('이호준'); // return은 가지고 있을 뿐 출력x -> document.write()이용
document.write(함수2('이호준'));

