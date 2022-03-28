package project;

import java.util.List;

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
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class KoreaInfoDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	
	public KoreaInfoDAO() {
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
	
	
	public List<KoreaInfoDTO> selectKoreaInfoList(){
		List<KoreaInfoDTO> list = new ArrayList<KoreaInfoDTO>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String now = dateFormat.format(date);
		
		try {
			con = dataFactory.getConnection();
			
			String query = "";
			query += "select * ";
			query += "from korea_info where korea_time = ?";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setString(1, now);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int koreaId = rs.getInt("korea_id");
				int koreaInfo = rs.getInt("korea_info");
				int koreaDanger = rs.getInt("korea_danger");
				int koreaDeath = rs.getInt("korea_death");
				String koreaLocal = rs.getString("korea_local");
				int koreaLocalInfo = rs.getInt("korea_local_info");
				String koreaTime = rs.getString("korea_time");
				
				
				KoreaInfoDTO dto = new KoreaInfoDTO();
				dto.setKoreaId(koreaId);
				dto.setKoreaInfo(koreaInfo);
				dto.setKoreaDanger(koreaDanger);
				dto.setKoreaDeath(koreaDeath);
				dto.setKoreaLocal(koreaLocal);
				dto.setKoreaLocalInfo(koreaLocalInfo);
				dto.setKoreaTime(koreaTime);
				
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
