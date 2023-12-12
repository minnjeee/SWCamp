// 호이스팅 : 선언문이 코드의 선두로 끌어올려진 것처럼 동작하는 현상
// 소스코드 처리 과정 : 평가 -> 실행
// 소스코드 평가 : 모든 선언문(변수,함수 등) 등록
// 소스코드 실행 (런타임)

// 1. 변수 호이스팅 : 선언한 시점과 상관 없이 끌어올려져서 선언 된 것처럼 작동한다
console.log(goHome); // goHome선언 없으면 정의되지 않았다는 에러 발생 (undefiend로 저장)
var goHome = '집에가고 싶다'; // goHome 선언을 하면서 변수 선언만 호이스팅 되고 값은 저장x
                            // 위의 코드는 에러는 사라지지만 undefined
console.log(goHome); // goHome 선언 후에 작성된 코드에는 goHome에 값이 할당 되어있음


// 2. 함수 호이스팅

func1('위 : '); // 함수선언이 아래에 있어도 함수적용
// func2('위 : '); // 에러
// 소개(); //에러

// (1)함수 선언문
function func1(파라미터) {
    document.write(파라미터, '함수 선언문<br>');
}
func1('아래 : ');

// (2)변수에 함수 할당
const func2 = function(파라메터) { // 함수를 변수에 선언하면 호이스팅 적용x (아래 소스코드만 적용됨)
    document.write(파라메터, '함수 선언문 변수에 할당<br>');
}
func2('아래 : ');

// (3)화살표 함수
var 소개 = () => {
    document.write('화살표함수 사용! sw반입니당~')
}
소개();
// 화살표 함수 : 함수 표현식 형태 (function키워드 대신 =>를 사용)
// let a = function() {}
// let a = () => {}
// -> 호이스팅을 막기 위해 사용하는 방법