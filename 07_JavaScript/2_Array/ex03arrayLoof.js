// 배열에 저장된 데이터를 반복문으로 출력하기

// for문
let nameList = ['김민지🐱', '최성우쌤🦊','김윤호쌤🐧', '이람다쌤🐰'];
for (let i=0; i<nameList.length; i++) {
    document.write(nameList[i]);
}
document.write('<br>');

// for-of 문
let foodList = ['치킨🍗', '피자🍕','팬케이크🥞','아이스크림🍦','햄버거🍔','크로와상🥐'];
for (let i of foodList) {
    document.write(i);
}
document.write('<br>');

// forEach 문
let colorList = new Array('빨강❤️','노랑💛','초록💚','파랑💙','보라💜');
colorList.forEach((element, index) => {
    document.write(index, element);
})
document.write('<br>');
