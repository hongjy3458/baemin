<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>정보수정</h1>

    <form action="/app/member/edit" method="post">
    	<input type="hidden" name="no" value="${sessionScope.loginMemberVo.no}">
        <input type="text" name="id" placeholder="아이디" readonly value="${sessionScope.loginMemberVo.id}">
        <br>
        <input type="password" name="pwd" placeholder="변경할 비밀번호">
        <br>
        <input type="password" name="pwd2" placeholder="변경할 비밀번호 확인">
        <br>
        <input type="text" name="nick" placeholder="닉네임" readonly value="${sessionScope.loginMemberVo.nick}">
        <br>
        <input type="submit" value="수정하기">
        <input type="button" value="탈퇴하기" onclick="location.href='/app/member/quit'">
    </form>

</body>
</html>






