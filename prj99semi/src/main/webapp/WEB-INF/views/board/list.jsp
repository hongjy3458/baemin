<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<link rel="stylesheet" href="/app/resources/css/board/list.css">
<script src="/app/resources/js/board/list.js"></script>
</head>
<body>

    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>
            
            <h1>게시글 목록</h1>
		
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>카테고리</th>
						<th>조회수</th>
						<c:if test="${ sessionScope.loginAdminVo != null }">
							<th> <button onclick="deleteCheckedBoard();">❌</button> </th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${voList}" var="vo">
						<tr>
							<td>${vo.no}</td>
							<td><a href="/app/board/detail?no=${vo.no}&writerNo=${vo.writerNo}">${vo.title}</a></td>
							<td>${vo.nick}</td>
							<td>${vo.categoryName}</td>
							<td>${vo.hit}</td>
							<c:if test="${ sessionScope.loginAdminVo != null }">
								<td> <input type="checkbox" value="${vo.no}"> </td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:if test="${not empty sessionScope.loginMemberVo}">
				<div>
					<button onclick="location.href='/app/board/insert'">게시글 작성</button>
				</div>
			</c:if>
			
			<div id="page-area">
				<c:if test="${pvo.currentPage > 1}">
					<a href="/app/board/list?pno=${pvo.currentPage-1}">이전</a>
				</c:if>
				<c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="x">
					<c:if test="${pvo.currentPage == x}">
						<strong>${x}</strong>
					</c:if>
					<c:if test="${pvo.currentPage != x}">
						<a href="/app/board/list?pno=${x}">${x}</a>
					</c:if>
				</c:forEach>
				<c:if test="${pvo.currentPage < pvo.maxPage }">
					<a href="/app/board/list?pno=${pvo.currentPage+1}">다음</a>
				</c:if>
				
			</div>
            
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>














