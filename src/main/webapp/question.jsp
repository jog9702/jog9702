<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.SurveyDAO"
    import="project.QuestionDAO"
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
	}
	form{
		width:50%
		border:1px solid black;
		margin:50px auto;

	}
	.form_question {

	    padding: 10px;
  	}
  	.form_question2 {

	    padding-top: 20px;
	    padding-bottom:20px;
  	}
  	input{
  		margin-top:10px;
  	}
  	footer{
  		text-align:center;
  	}
</style>
</head>
<body>
	<h1><a href="survey.jsp">설문지</a></h1>
	
	<%
		int search_id = Integer.parseInt(request.getParameter("survey_id"));
		int survey_id = Integer.parseInt(request.getParameter("survey_id"));
		SurveyDAO surveyDAO = new SurveyDAO();
		SurveyDTO surveyDTO = surveyDAO.selectSurveyList(search_id);
		
	%>
	<div>
		<h1> <%= surveyDTO.getTitle_user() %></h1>
		<h3> <%= surveyDTO.getDesc() %></h3>
	</div>
		
		
	<%	
		
		QuestionDAO questionDAO = new QuestionDAO();
		List<QuestionDTO> questionList = questionDAO.selectQuestionList(search_id);
		
	%>
	<form class="form_question" action="response.jsp">
	<%
		String qid = "";
		for(int i=0; i<questionList.size(); i++){
			QuestionDTO dto = (QuestionDTO) questionList.get(i);
			qid += dto.getQuestion_id() + ",";
	%>
		<div class="form_question2">
			<div>
				<hr>
				<div>질문 : <%= dto.getTitle() %></div>
				<div>상세 내용 : <%= dto.getDesc() %></div>
				<%-- <input type="text" name="resp_<%= dto.getQuestion_id() %>"/> --%>
				<input type="text" name="response">
 				<input type="hidden" name="question_id" value="<%= dto.getQuestion_id() %>">
				<hr>
			</div>
		</div>
	<%
		}
	%>
	<div>
	</div>
	<input type="submit" value="제출"/>
	<input type="reset" value="양식지우기"/>
	<input type="hidden" name="survey_id" id="<% surveyDTO.getSurvey_id(); %>" value="<%= survey_id %>"/>
	</form>
	<footer>설문지</footer>
</body>
</html>