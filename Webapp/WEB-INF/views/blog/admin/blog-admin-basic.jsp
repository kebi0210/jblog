<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>

	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content" class="full-screen">
				
				<c:import url="/WEB-INF/views/includes/blog-menu.jsp"></c:import>
				
				<form action="${pageContext.request.contextPath}/${authUser.id}/admin/update" method="post" enctype="multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="title" value="${blogVo.bolgtitle}"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td> 
			      			<td><img src="${pageContext.request.contextPath }/${url}${blogVo.logofile}"></td>      			
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="logo-file"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
			      	<input type="hidden" name="userno" value="${blogVo.userno }" /> 
				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	</div>
</body>
</html>