<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.SurveyDAO"
    import="project.QuestionDAO"
    import="project.ResponseDAO"
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
	div{
		border:1px solid black;
		margin:50px auto;
		padding:10px;
	}

  	footer{
  		text-align:center;
  	}
</style>
</head>
<body>
	<h1><a href="survey.jsp">설문지</a></h1>
	
	<%
		/* 1번 방법
		Enumeration element = request.getParameterNames();
		out.println();
		while(element.hasMoreElements()){
			String elem = (String) element.nextElement();
			out.println("elem : " + elem);
			out.println("<br>");
			//resp_8; [resp, 8]
			String[] name = elem.split("_");
			if(name.length > 1){
				String q_id = name[1];
				out.println("[" + q_id + "]");
				
				String recv = request.getParameter(elem);
				out.println(recv);
				out.println("<br>");
			}
		}
		*/
		
		String[] arr_question = request.getParameterValues("question_id");
		String[] arr_response = request.getParameterValues("response");

		if(arr_question.length == arr_response.length){
			
			List<ResponseDTO> list = new ArrayList();
			
			for(int i=0; i < arr_response.length; i++){
				
				String questionId = arr_question[i];
				String recv = arr_response[i];
				
				ResponseDTO dto = new ResponseDTO();
				dto.setQuestion_id( Integer.parseInt(questionId) );
				dto.setResponse(recv);

				list.add(dto);
				
//	 			Map info = new HashMap();
//	 			info.put("questionId", questionId);
//	 			info.put("recv", recv);
//	 			list.add(info);
			}
			
 			ResponseDAO dao = new ResponseDAO();
			dao.responseList(list);
		}
		
		
		int search_id = Integer.parseInt(request.getParameter("survey_id"));
		SurveyDAO surveyDAO = new SurveyDAO();
		SurveyDTO surveyDTO = surveyDAO.selectSurveyList(search_id);

		
	%>
	<div>
		<h1> <%= surveyDTO.getTitle_user() %></h1>
		<h3> 응답이 기록되었습니다 </h3>
		<a href="survey.jsp">다른 응답 제출</a>
	</div>
	
	<footer>설문지</footer>
	
</body>
</html>