// 객체 : 여러 데이터를 하나의 변수에 저장할 수 있는 데이터 타입
    // 현실세계에 존재하는 모든 물체/개념
    // ex. 김민지 객체 -> 나이(number), 안경쓴여부(boolean), 성별(string), 공부(파라미터)(function)
        // 이러한 모든 속성 = property (함수인 property = method)
// 구조(딕셔너리 형태) -> {key1:value1, key2:value2, ...}
    // key = 객체의 속성 (property)
    // value = 속성의 값 (기본 자료형, 함수, 배열, 객체 등 모두 가능)

// 객체 생성 (속성들은 콤마로 구분)
let person = {  // 파이썬과 달리 key값은 따옴표 사용X
    name : "이호준",
    age : 30,
    wearGlassess : false,
    introduce : function(){
        console.log('오늘도 공부를 열심히 합니다');
    },
    favorite : {    // 속성 값으로 객체도 가능!!
        food : "치킨🍗",
        drink : "아메리카노☕"
    },
    smhrd : ['이람다','최성우','김윤호']
}

// 객체 접근 (객체명)
console.log(person);
// 객체의 속성 접근 (객체명.key)
// 객체의 객체속성의 속성 접근 (객체명.key1.key2)
// 객체의 배열속성의 요소 접근 (객체명.key[index])

// 객체 속성 변경/추가 (객체명.key = value)
person.name = '김민지';
person.age = 26;
person.wearGlassess = true;

person.class = 'B';
console.log(person);