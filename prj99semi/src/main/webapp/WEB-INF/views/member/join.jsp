<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<script src="/app/resources/js/join.js"></script>

</head>
<body>

    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>
            <h1>회원가입</h1>

            <form action="/app/member/join" method="post" enctype="multipart/form-data">
                <input type="text" name="id" placeholder="아이디">
                <button type="button" onclick="checkDup();">중복검사</button>
                <br>
                <input type="password" name="pwd" placeholder="비밀번호">
                <br>
                <input type="password" name="pwd2" placeholder="비밀번호 확인">
                <br>
                <input type="text" name="nick" placeholder="닉네임">
                <br>
                <label>프로필사진</label> <input type="file" name="profile">
                <br>
                <input type="submit" value="회원가입">
            </form>
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>