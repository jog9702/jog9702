package project;

import project.dto.KoreaInfoDTO;
import project.dto.ForeignInfoDTO;
import project.dto.MapInfoDTO;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ForeignInfoDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	
	public ForeignInfoDAO() {
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	public List<ForeignInfoDTO> selectForeignInfoList(){
		List<ForeignInfoDTO> list = new ArrayList<ForeignInfoDTO>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String now = dateFormat.format(date);

//		String now = (String) new Date(0);
		
		
		try {
			con = dataFactory.getConnection();
//			int now = list.size();
			
			String query = "";
			query += "select * ";
			query += "from foreign_info where foreign_time = ?";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setString(1, now);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int foreign_id = rs.getInt("foreign_id");
				String foreign_info = rs.getString("foreign_info");
				String foreign_danger = rs.getString("foreign_danger");
				String foreign_death = rs.getString("foreign_death");
				String foreign_time = rs.getString("foreign_time");
				
				
				ForeignInfoDTO dto = new ForeignInfoDTO();
				dto.setForeign_id(foreign_id);
				dto.setForeign_info(foreign_info);
				dto.setForeign_danger(foreign_danger);
				dto.setForeign_death(foreign_death);
				dto.setForeign_time(foreign_time);
				
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
		
		return list;
	}
	
}
