<%@page import="project.dto.BoardInfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.KoreaInfoDAO"
    import="project.dto.KoreaInfoDTO"
    import="project.ForeignInfoDAO"
    import="project.dto.ForeignInfoDTO"
    import="project.MapInfoDAO"
    import="project.dto.MapInfoDTO"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>위드코로나</title>
<style>
	body{
		height:500px;
		text-align:center;
	}
  	a{
  		text-decoration:none;
  	}
  	#menu{
  	
  	}
  	ul{
	  	list-style:none;
	  	height:40px;
	  	line-height:30px;
	  	vertical-align: middle;
	  	text-align:center;
  	}
  	li{
	  	line-height:30px;
	  	vertical-align: middle;
	  	position:relative;
	  	margin:5px 30px;
	  	padding:0;
	  	display:inline-block;
  	}
  	form{
		width:50%
		border:1px solid black;
		margin:50px auto;

	}
	table{
		width:50%
		border:1px solid black;
		margin:100px auto;
		border-collapse: separate;
  		border-spacing: 0 10px;
	}
	th, td {
	    border-top: 1px solid #444444;
	    border-bottom: 1px solid #444444;
	    padding: 10px;
 	}
</style>
</head>
<body>
	<a href="main.jsp"><h2>위드 코로나</h2></a>
	
	<div id="menu">	
		<ul>
			<li><a href="koreaInfo.jsp">국내 정보</a></li>
			<li><a href="foreignInfo.jsp">해외 정보</a></li>
			<li><a href="map.jsp">보건소 정보</a></li>
			<li><a href="board.jsp">문의/건의 게시판</a></li>
		</ul>
	</div>
	<hr>
	<%
		String searchMapLocal = request.getParameter("mapLocal");
		MapInfoDAO mapInfoDAO = new MapInfoDAO();
		List<MapInfoDTO> mapInfoList = mapInfoDAO.selectMapInfo(searchMapLocal);
	%>
	<table>
		<tr>
			<td>지역 번호</td>
			<td>지역 이름</td> 
			<td>보건소 위치</td>
			<td>전화번호</td>
		</tr>
	<%
		for(int i=0; i<mapInfoList.size(); i++){
			MapInfoDTO dto = (MapInfoDTO) mapInfoList.get(i);
	%>
		<tr>
			<td><%= dto.getMapId() %></td>
			<td><%= dto.getMapLocal() %></td> 
			<td><%= dto.getMaplocalInfo() %></td>
			<td><%= dto.getMapTel() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>