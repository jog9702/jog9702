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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			String boardTitle = request.getParameter("boardTitle");
			String boardDesc = request.getParameter("boardDesc");
			String boardUser = request.getParameter("boardUser");
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			
			BoardInfoDAO dao = new BoardInfoDAO();
			BoardInfoDTO dto = new BoardInfoDTO();
			
			dto.setBoardTitle(boardTitle);
			dto.setBoardDesc(boardDesc);
			dto.setBoardUser(boardUser);
			dto.setBoardId(boardId);
			
			dao.boardUpdate(dto);
			
			response.sendRedirect("board.jsp");
			%>
</body>
</html>