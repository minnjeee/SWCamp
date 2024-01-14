/**
 * 
 */
console.log(registerForm.num);
registerForm.num.onchange = function(e){
	let val = this.value; //콜백함수가 포함된 노드 개체
	console.log(val); //num이 바뀌면 콘솔에 입력값 출력
	fetch("./checkNum.do?num="+val)
		.then((resp)=>{return resp.json()})//then() : fetch안의 통신이 끝나면 실행
		.then((obj)=>{
			console.log(obj);
			if(obj.checkNum){
				alert("이미 사용중인 num 입니다.");
			} else {
				alert("사용할 수 있는 num 입니다.");
			}
		}); 
}