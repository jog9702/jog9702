<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.KoreaInfoDAO"
    import="project.dto.KoreaInfoDTO"
    import="project.ForeignInfoDAO"
    import="project.dto.ForeignInfoDTO"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위드코로나</title>
<style>
	body{
		height:500px;
		text-align:center;
	}
  	a{
  		text-decoration:none;
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
	
	<%
		KoreaInfoDAO koreaInfoDAO = new KoreaInfoDAO();
		List<KoreaInfoDTO> koreaInfoList = (List<KoreaInfoDTO>) koreaInfoDAO.selectKoreaInfoList();
		
		KoreaInfoDTO dto = (KoreaInfoDTO) koreaInfoList.get(0);
		
		
	%>
	
	<hr>
	<br><br><br><br><br><br>
	<div><h2>일일 확진자 수 : <%= dto.getKoreaInfo() %> 명</h2></div>
	<br><br>
	<div>위중증자 수 : <%= dto.getKoreaDanger() %> 명 &nbsp&nbsp 사망자 수 : <%= dto.getKoreaDeath() %> 명</div>
</body>
</html>