<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<link rel="stylesheet" href="/app/resources/css/home.css">
<script src="/app/resources/js/home.js"></script>



<script>
	<c:if test="${not empty alertMsg}">
		alert("${alertMsg}");
	</c:if>
</script>

<c:remove var="alertMsg" scope="session" />