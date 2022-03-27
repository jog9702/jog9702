package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.dto.QuestionDTO;


public class QuestionDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public QuestionDAO() {
		try {

			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void connDB() {
		try {
			
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("Connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<QuestionDTO> selectQuestionList(int search_id){
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		
		try {
			con = dataFactory.getConnection();
			System.out.println("커넥션풀 성공");
			
			String query = "";
			query += "SELECT * ";
			query += " FROM tb_question where survey_id = ?";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setInt(1, search_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int question_id = rs.getInt("question_id");
				int survey_id = rs.getInt("survey_id");
				String title = rs.getString("title");
				String desc = rs.getString("desc");
				String type = rs.getString("type");
				String order = rs.getString("order");
				String mandatory = rs.getString("mandatory");
				
				
				QuestionDTO dto = new QuestionDTO();
				dto.setQuestion_id(question_id);
				dto.setSurvey_id(survey_id);
				dto.setTitle(title);
				dto.setDesc(desc);
				dto.setType(type);
				dto.setOrder(order);
				dto.setMandatory(mandatory);
				
				list.add(dto);
			}
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		list = new ArrayList<QuestionDTO>();
		
		return list;
	}
	
}
