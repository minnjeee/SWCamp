// 함수 실습2 : 삼각형 만들기
// 두 가지 정보(1.이모티콘, 2.숫자) 입력
// 숫자만큼의 길이(층)을 가진 직각삼각형 만들기

let heart = prompt('이모티콘을 입력하세요');
let number = Number(prompt('숫자를 입력하세요'));

const triangle = (h, n) => {
    for (let i=1; i<=n; i++){
        document.write(h.repeat(i),'<br>'); // 문자열.repeat(n) : 문자열을 n번 반복
        
    }
}
triangle(heart, number);

document.write('<hr>');

// 선생님 풀이
// function triangle2(icon, row){
//     for(let i=1; i<=row; i++){
//         for(let j=1; j<=i; j++){
//             document.write(icon);
//         }
//         document.write('<br>');
//     }
// }
// triangle2(heart, number);