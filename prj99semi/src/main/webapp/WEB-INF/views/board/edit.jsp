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
            
            <h1>게시글 수정</h1>
            
            <form action="/app/board/edit" method="post">
            	<input type="hidden" name="no" value="${vo.no}">
	            <input type="text" name="title" value="${requestScope.vo.title}">
	            <div>작성자 : ${requestScope.vo.nick}</div>
	            <div>조회수 : ${requestScope.vo.hit}</div>
	            
	            <select name="categoryNo">
	            	<c:forEach var="x" items="${categoryVoList}">
		            	<c:if test="${vo.categoryNo ne x.no}">
		            		<option value="${x.no}">${x.name}</option>
		            	</c:if>
		            	<c:if test="${vo.categoryNo eq x.no}">
		            		<option selected value="${x.no}">${x.name}</option>
		            	</c:if>
	            	</c:forEach>
	            </select>
	            
	            <div>작성일시 : ${requestScope.vo.createDate}</div>
	            <textarea name="content"> ${requestScope.vo.content} </textarea>
	            <input type="submit" value="수정하기">
            </form>
            
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>


