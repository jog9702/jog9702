<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.SurveyDAO"
    import="project.dto.SurveyDTO"
    import="project.dto.ResponseDTO"
    import="project.dto.QuestionDTO"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		height:500px;
		text-align:center;
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
	<a href="survey.jsp">설문지</a> <input type="text" name="search"/>

	<%
		SurveyDAO surveyDAO = new SurveyDAO();
		List<SurveyDTO> surveyList = surveyDAO.selectSurveyList();
		
		if(surveyList.size() == 0){
	%>
		<h1>설문지 없음</h1>
	<%	
		}
	%>
	<table>
	<%
		for(int i=0; i<surveyList.size(); i++){
			// 화면에 목록 표시
			SurveyDTO dto = (SurveyDTO) surveyList.get(i);
	%>
		<tr onClick="location.href='/exam08/question.jsp?survey_id=<%= dto.getSurvey_id() %>'">
			<td><%= dto.getSurvey_id() %></td>
			<td><%= dto.getTitle_admin() %></td> 
			<td><%= dto.getTitle_user() %></td>
			<td><%= dto.getCtime() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>