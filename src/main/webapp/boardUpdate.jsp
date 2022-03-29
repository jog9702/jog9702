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
		width:80%
		border:1px solid black;
		margin:100px auto;
		border-collapse: separate;
  		border-spacing: 0 10px;
	}
	th, td {
	    padding: 10px;
  	}
  	textarea{
  		width:300px;
  		height:200px;
  	}
  	input{
  		width:300px;
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
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardDesc = request.getParameter("boardDesc");
		String boardUser = request.getParameter("boardUser");
		
		BoardInfoDAO boardInfoDAO = new BoardInfoDAO();
		List<BoardInfoDTO> boardInfoList = boardInfoDAO.selectBoardList();
		
	%>
	<form method="post" action="boardUpdateResult.jsp">
	<table>
		<tr>
			<td>
			제목
			</td>
			<td>
			<input type="text" name="boardTitle" value="<%= boardTitle %>">
			</td>
		</tr>
		<tr>
			<td>
			내용
			</td>
			<td>
			<textarea name="boardDesc"><%= boardDesc %></textarea>
			</td>
		</tr>
		<tr>
			<td>
			작성자
			</td>
			<td>
			<input type="text" name="boardUser" value="<%= boardUser %>">
			</td>
		</tr>
	</table>
	<button>수정하기</button>
	<input type="hidden" name="boardId" value="<%= boardId %>">
	</form>
	
</body>
</html>