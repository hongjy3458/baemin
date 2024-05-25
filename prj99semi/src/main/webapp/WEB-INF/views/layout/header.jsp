<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header>
    <div>빈칸</div>
    <div>로고</div>
    <div>
    
    	<c:choose>
    		<c:when test="${ sessionScope.loginAdminVo != null }">
	    		<div>
	    			<span>관리자 : ${ sessionScope.loginAdminVo.nick } </span>
	    			<br>
	    			<button onclick="location.href='/app/admin/logout'">로그아웃</button>
	    		</div>
    		</c:when>
    		<c:when test="${ sessionScope.loginMemberVo != null }">
	     		<div>
		     		<a download href="/app/resources/upload/${loginMemberVo.profile}">프로필사진 다운로드 받기</a>
		     		<img 
		     			width="100px" 
		     			height="100px" 
		     			alt="프로필사진" 
		     			src="/app/resources/upload/${loginMemberVo.profile}"
		     		>
		     		<span>닉네임 : ${sessionScope.loginMemberVo.nick} </span>
		     		<br>
		     		<button onclick="location.href = '/app/member/logout'">로그아웃</button>
	    		</div>
    		</c:when>
    		<c:otherwise>
	    		<div>
			      	<button onclick="location.href='/app/member/join'">회원가입</button>
			      	<button onclick="location.href='/app/member/login'">로그인</button>
		     	</div>
    		</c:otherwise>
    	</c:choose>
    
    </div>
</header>

