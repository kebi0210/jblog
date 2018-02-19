<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 블로그 해더 -->
		
		<div id="header">
				
			<h1><a href="${pageContext.request.contextPath}/${authUser.id}"> ${blogVo.bolgtitle}</a></h1>
		
			<ul>
				<!-- 로그인 전 메뉴 -->
			<c:choose>
			<c:when test="${authUser == null}">
				<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			</c:when>
			</c:choose>		
					
				<!-- 로그인 후 메뉴 -->
				<c:choose>
			    <c:when test="${authUser != null}">
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin">내블로그 관리</a></li>
				</c:when>
				</c:choose>
			</ul>
		</div>
		<!-- /블로그 해더 -->