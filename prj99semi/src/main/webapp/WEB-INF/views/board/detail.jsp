<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>

    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>
            <h1 align="center">게시글 상세조회</h1>
            
            <div>제목 : ${requestScope.vo.title}</div>
            <div>작성자 : ${requestScope.vo.nick}</div>
            <div>조회수 : ${requestScope.vo.hit}</div>
            <div>카테고리이름 : ${requestScope.vo.categoryName}</div>
            <div>작성일시 : ${requestScope.vo.createDate}</div>
            <div>내용 : ${requestScope.vo.content}</div>
            
            <c:forEach items="${attVoList}" var="x">
	            <img width="100px" height="100px" alt="${x.originName}" src="/app/resources/upload/${x.changeName}">
            </c:forEach>
            
            <c:if test="${requestScope.vo.writerNo == sessionScope.loginMemberVo.no}">
	            <button onclick="location.href='/app/board/edit?no=${vo.no}'">수정</button>
	            <button onclick="location.href='/app/board/delete?no=${vo.no}'">삭제</button>
            </c:if>
            
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>