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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			String boardPassword = request.getParameter("boardPassword");
			
			BoardInfoDAO dao = new BoardInfoDAO();
			BoardInfoDTO dto = new BoardInfoDTO();
			
			dto.setBoardTitle(boardTitle);
			dto.setBoardDesc(boardDesc);
			dto.setBoardUser(boardUser);
			dto.setBoardPassword(boardPassword);
			
			dao.boardinsert(dto);
			
		%>
		<c:redirect url="/board.jsp">
		</c:redirect>

</body>
</html>