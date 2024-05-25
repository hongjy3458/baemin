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
            
            <h1>게시글 작성</h1>

		    <form action="/app/board/insert" method="post" enctype="multipart/form-data">
		        <input type="text" name="title" placeholder="제목">
		        <select name="category">
		            <c:forEach var="cvo" items="${categoryVoList}">
		            	<option value="${cvo.no}">${cvo.name}</option>
		            </c:forEach>
		        </select>
		        <br>
		        <textarea name="content" placeholder="내용"></textarea>
		        <br>
		        <input type="file" name="f" multiple>
		        <input type="submit" value="작성하기">
		    </form>
            
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>