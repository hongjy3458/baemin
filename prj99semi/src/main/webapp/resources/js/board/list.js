function deleteCheckedBoard(){
	
	//체크박스 전부 가져오기
	const checkboxArr = document.querySelectorAll("main>table>tbody input[type=checkbox]");
	console.log("checkboxArr : " , checkboxArr);
	
	//체크박스 순회하며, 체크상태인 요소만 챙기기
	//해당 체크박스들의 value 값을 이용하여 no 값 채우기
	let str = "";
	for(let i = 0; i < checkboxArr.length; ++i){
		if (checkboxArr[i].checked){
			console.log(checkboxArr[i].value);
			str += "no=" + checkboxArr[i].value;
			str += "&";
		} 
	}
	
	location.href="http://127.0.0.1:8888/app/board/admin/delete?" + str;
	
}//deleteCheckedBoard





