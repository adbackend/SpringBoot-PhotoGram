// (1) 회원정보 수정
function update(userId, event) {
	
	event.preventDefault(); //폼태그 액션을 막기!!
	
	let data = $("#profileUpdate").serialize();
	
	$.ajax({
		type:"put",
		url:`/api/user/${userId}`,
		data:data, //요청과 함께 서버로 데이터를 전송 할 string 또는 map
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json" //서버측에서 전송받은 데이터의 형식 
	}).done(res=>{ //httpStatus 상태코드 200번대 일때
		console.log("update 성공", res);
		location.href=`/user/${userId}/`;
	}).fail(error=>{ // httpStatus 상태코드가 200번대가 아닐때
		alert(JSON.stringify(error.responseJSON.data));
	});
}