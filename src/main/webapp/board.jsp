<%@page import="project.dto.BoardInfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.KoreaInfoDAO"
    import="project.dto.KoreaInfoDTO"
    import="project.ForeignInfoDAO"
    import="project.dto.ForeignInfoDTO"
    import="project.BoardInfoDAO"
    import="project.dto.BoardInfoDTO"
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
			<li>보건소 정보</li>
			<li><a href="board.jsp">문의/건의 게시판</a></li>
			<li>로그인</li>
		</ul>
	</div>
	<hr>
	<%
		BoardInfoDAO boardInfoDAO = new BoardInfoDAO();
		List<BoardInfoDTO> boardInfoList = boardInfoDAO.selectBoardInfoList();
		
	%>
	<table>
		<tr>
			<td>게시글 번호</td>
			<td>게시글 이름</td> 
			<td>게시글 작성자</td>
		</tr>
	<%
		for(int i=0; i<boardInfoList.size(); i++){
			// 화면에 목록 표시
			BoardInfoDTO dto = (BoardInfoDTO) boardInfoList.get(i);
	%>
		<tr onClick="location.href='/project/boardInfo.jsp?board_id=<%= dto.getBoardId() %>'">
			<td><%= dto.getBoardId() %></td>
			<td><%= dto.getBoardTitle() %></td> 
			<td><%= dto.getBoardUser() %></td>
		</tr>
	<%
		}
	%>
	</table>
	
</body>
</html>