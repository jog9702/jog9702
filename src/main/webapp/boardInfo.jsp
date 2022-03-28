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
  	form{
		width:50%
		border:1px solid black;
		margin:50px auto;

	}
	.board1 {

	    padding: 10px;
  	}
  	.board2 {

	    padding-top: 20px;
	    padding-bottom:20px;
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
			<li><a href="boardInfo.jsp">문의/건의 게시판</a></li>
			<li>로그인</li>
		</ul>
	</div>
	<hr>
	<%
		int boardId = Integer.parseInt(request.getParameter("board_id"));
		BoardInfoDAO boardInfoDAO = new BoardInfoDAO();
		List<BoardInfoDTO> boardInfoList = boardInfoDAO.selectBoardInfoList();
		
	%>
	<form class="board1" action="response.jsp">
	<%
		String qid = "";
		for(int i=0; i<boardInfoList.size(); i++){
			BoardInfoDTO dto = (BoardInfoDTO) boardInfoList.get(i);
			qid += dto.getBoardId() + ",";
	%>
		<div class="board2">
			<div>
				<hr>
				<div>게시글 번호 : <%= dto.getBoardId() %></div>
				<div>게시글 제목 : <%= dto.getBoardTitle() %></div>
				<div>게시글 내용 : <%= dto.getBoardDesc() %></div>
				<div>게시글 제목 : <%= dto.getBoardUser() %></div>
				<div>게시글 댓글 : <%= dto.getBoardComment() %></div>
				<hr>
			</div>
		</div>
	<%
		}
	%>
	</form>
</body>
</html>