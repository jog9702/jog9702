<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.KoreaInfoDAO"
    import="project.dto.KoreaInfoDTO"
    import="project.ForeignInfoDAO"
    import="project.dto.ForeignInfoDTO"
    import="project.MapInfoDAO"
    import="project.dto.MapInfoDTO"
    import="project.BoardInfoDAO"
    import="project.dto.BoardInfoDTO"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int searchBoardId = Integer.parseInt(request.getParameter("board_id"));
		BoardInfoDAO boardInfoDAO = new BoardInfoDAO();
		BoardInfoDTO boardInfo = boardInfoDAO.selectBoardInfo(searchBoardId);
		
		boardInfoDAO.boardDelete(searchBoardId);
		
		response.sendRedirect("board.jsp");
	%>
</body>
</html>