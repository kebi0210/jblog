<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>					
							
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="wrapper">
			<div id="content" class="full-screen">
				
				<c:import url="/WEB-INF/views/includes/blog-menu.jsp"></c:import>
				
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
					
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="catename"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="description"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
	</div>
</body>

<script type="text/javascript">

var userno = ${authUser.userno}
cateList(userno);

function cateList(userno){	
	
	
	
	$.ajax({

		url : "${pageContext.request.contextPath }/api/listcate",
		type : "post",
		//contentType : "application/json",
		data : {userno : userno},
	
		dataType : "json",
		success : function(cateList){
		/*성공시 처리해야될 코드 작성*/
			//console.log(guestbooklist);
			
			for(var i=0; i<cateList.length; i++){
				render(cateList[i]);	
			}
		
		},
	
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}

		});
}							

function render(cateVo){
	var title = "";
	title += "<tr>";
	title +=	"<td>" + cateVo.cateno + "</td>";
	title +=	"<td>" + cateVo.catename +"</td>";
	title +=	"<td>0</td>";
	title +=	"<td> "+ cateVo.description +"</td>";
	title += "<td><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>";
	title += "</tr>" ;
	
	$(".admin-cat").append(title);
	
	}

	
</script>
</html>