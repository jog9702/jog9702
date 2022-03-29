package project;

import project.dto.KoreaInfoDTO;
import project.dto.ForeignInfoDTO;
import project.dto.MapInfoDTO;
import project.dto.BoardInfoDTO;

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

public class MapInfoDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	
	public MapInfoDAO() {
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

	
	public List<MapInfoDTO> selectMapInfo(String searchMapLocal){
		List<MapInfoDTO> list = new ArrayList<MapInfoDTO>();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "";
			query += "SELECT * ";
			query += " FROM map_info where map_local = ?";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setString(1, searchMapLocal);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int mapId = rs.getInt("map_id");
				String mapLocal = rs.getString("map_local");
				String mapLocalInfo = rs.getString("map_local_info");
				String mapTel = rs.getString("map_tel");
				
				
				MapInfoDTO dto = new MapInfoDTO();
				dto.setMapId(mapId);
				dto.setMapLocal(mapLocal);
				dto.setMaplocalInfo(mapLocalInfo);
				dto.setMapTel(mapTel);
				
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