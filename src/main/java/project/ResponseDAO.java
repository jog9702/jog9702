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
import project.dto.ResponseDTO;

public class ResponseDAO {
	

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public ResponseDAO() {
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
	
	public void response(ResponseDTO dto) {
		
		try {
			con = dataFactory.getConnection();
			System.out.println("커넥션풀 성공");

			String query = " INSERT INTO tb_response (response_id, question_id, response, ctime)";
			query +=       " VALUES (tb_response_seq.nextval, ?, ?, SYSDATE)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dto.getQuestion_id());
			pstmt.setString(2, dto.getResponse());

			
			pstmt.executeQuery();


			System.out.println("insert 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (con != null) con.close(); 
				if (pstmt != null) pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}	
	}
	
	public void responseList(List<ResponseDTO> list) {
		
		for(int i=0; i<list.size(); i++) {
			ResponseDTO dto = list.get(i);
			response(dto);
		}
		
	}
}
