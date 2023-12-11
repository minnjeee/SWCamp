let nameList = ['이람다','최성우','김윤호'];
document.write('원래 데이터 : ',nameList,'<br>');

// 1. 마지막 인덱스에 데이터 추가 : push()
nameList.push('김동현'); // 값추가
document.write(`마지막에 추가 : ${nameList}<br>`);


// 2. 마지막 인덱스 데이터 삭제 : pop()
nameList.pop();
document.write(`마지막을 삭제 : ${nameList} <br>`);

// 3. 첫번째 인덱스에 데이터 추가 : unshift()
nameList.unshift('김성윤');
document.write(`첫번째에 추가 : ${nameList}<br>`);

// 4. 첫번째 인덱스 데이터 삭제 : shift()
nameList.shift();
document.write(`첫번째를 삭제 : ${nameList}<br>`);

// 5. 원하는 위치에 데이터 추가/삭제 : splice()
// nameList[3] = '박소미' : 3번째 인덱스 데이터를 제거하고 삽입
// 추가 : splice(원하는 인덱스, 0, 추가할 데이터)
nameList.splice(1,0,'김민지');
document.write(`1번 인덱스에 추가 : ${nameList}<br>`);
// 삭제 : splice(원하는 인덱스, 1)
// 두번째 파라미터인 0,1은 삭제여부 (0:삭제안함, 1:삭제함)
nameList.splice(1,1)
document.write(`1번 인덱스를 삭제 : ${nameList}<br>`);

