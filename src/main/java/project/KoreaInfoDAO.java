package project;

import java.util.List;

import project.dto.KoreaInfoDTO;
import project.dto.ForeignInfoDTO;
import project.dto.MapInfoDTO;

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
		
		try {
			con = dataFactory.getConnection();
			
			String query = "";
			query += "select * ";
			query += "from korea_info";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int korea_id = rs.getInt("korea_id");
				String korea_info = rs.getString("korea_info");
				String korea_danger = rs.getString("korea_danger");
				String korea_death = rs.getString("korea_death");
				String korea_seoul = rs.getString("korea_seoul");
				String korea_chungnam = rs.getString("korea_chungnam");
				String korea_time = rs.getString("korea_time");
				
				
				KoreaInfoDTO dto = new KoreaInfoDTO();
				dto.setKorea_id(korea_id);
				dto.setKorea_info(korea_info);
				dto.setKorea_danger(korea_danger);
				dto.setKorea_death(korea_death);
				dto.setKorea_seoul(korea_seoul);
				dto.setKorea_chungnam(korea_chungnam);
				dto.setKorea_time(korea_time);
				
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
