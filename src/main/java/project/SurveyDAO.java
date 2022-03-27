package project;

import java.util.List;

import project.dto.QuestionDTO;
import project.dto.ResponseDTO;
import project.dto.SurveyDTO;

import java.sql.Connection;
import java.sql.Date;
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

public class SurveyDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	// db에서 가져오기
	public SurveyDAO() {
		try {

			// JNDI
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
	
	// 리스트를 불러오기
	// select문을 적용해 db 불러오기
	public List<SurveyDTO> selectSurveyList(){
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		
		try {
			con = dataFactory.getConnection();
			System.out.println("커넥션풀 성공");
			
			String query = "";
			query += "SELECT * ";
			query += " FROM tb_survey";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int survey_id = rs.getInt("survey_id");
				String title_admin = rs.getString("title_admin");
				String title_user = rs.getString("title_user");
				String desc = rs.getString("desc");
				Date ctime = rs.getDate("ctime");
				
				
				SurveyDTO dto = new SurveyDTO();
				dto.setSurvey_id(survey_id);
				dto.setTitle_admin(title_admin);
				dto.setTitle_user(title_user);
				dto.setDesc(desc);
				dto.setCtime(ctime);
				
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
		
//		list = new ArrayList<SurveyDTO>();
		
		return list;
	}
	
	// 서치 아이디를 만들어 특정 survey아이디를 불러오게 하기
	public SurveyDTO selectSurveyList(int search_id) {
		
		SurveyDTO dto = new SurveyDTO();
		
		try {
			con = dataFactory.getConnection();
			System.out.println("커넥션풀 성공");
			
			String query = "";
			query += "SELECT * ";
			query += " FROM tb_survey where survey_id = ?";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setInt(1, search_id);
			System.out.println( ((LoggableStatement)pstmt).getQueryString() );
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int survey_id = rs.getInt("survey_id");
				String title_admin = rs.getString("title_admin");
				String title_user = rs.getString("title_user");
				String desc = rs.getString("desc");
				Date ctime = rs.getDate("ctime");
				
				
				dto.setSurvey_id(survey_id);
				dto.setTitle_admin(title_admin);
				dto.setTitle_user(title_user);
				dto.setDesc(desc);
				dto.setCtime(ctime);
				
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
			
		return dto;
	}
}
