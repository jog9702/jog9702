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

public class BoardInfoDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	
	public BoardInfoDAO() {
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
	
	
	public List<BoardInfoDTO> selectBoardList(){
		List<BoardInfoDTO> list = new ArrayList<BoardInfoDTO>();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "";
			query += "SELECT * ";
			query += " FROM board_info";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int boarId = rs.getInt("board_id");
				String boardTitle = rs.getString("board_title");
				String boardDesc = rs.getString("board_desc");
				String boardUser = rs.getString("board_user");
				String boardTime = rs.getString("board_time");
				String boardPassword = rs.getString("board_password");
				
				
				BoardInfoDTO dto = new BoardInfoDTO();
				dto.setBoardId(boarId);
				dto.setBoardTitle(boardTitle);
				dto.setBoardDesc(boardDesc);;
				dto.setBoardUser(boardUser);
				dto.setBoardTime(boardTime);
				dto.setBoardPassword(boardPassword);
				
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
	
	public BoardInfoDTO selectBoardInfo(int searchBoardId){
		BoardInfoDTO dto = new BoardInfoDTO();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "";
			query += "SELECT * ";
			query += " FROM board_info where board_id = ? ";
			System.out.println(query);
			pstmt = new LoggableStatement(con, query);
			pstmt.setInt(1, searchBoardId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int boardId = rs.getInt("board_id");
				String boardTitle = rs.getString("board_title");
				String boardDesc = rs.getString("board_desc");
				String boardUser = rs.getString("board_user");
				String boardTime = rs.getString("board_time");
				String boardPassword = rs.getString("board_password");
				
				

				dto.setBoardId(boardId);
				dto.setBoardTitle(boardTitle);
				dto.setBoardDesc(boardDesc);;
				dto.setBoardUser(boardUser);
				dto.setBoardTime(boardTime);
				dto.setBoardPassword(boardPassword);
				
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
	
	public void boardinsert(BoardInfoDTO dto) {
		
		try {
			con = dataFactory.getConnection();

			String query = " INSERT INTO board_info (board_id, board_title, board_desc, board_user, board_time, board_password)";
			query +=       " VALUES (board_info_seq.nextval, ?, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getBoardTitle());
			pstmt.setString(2, dto.getBoardDesc());
			pstmt.setString(3, dto.getBoardUser());
			pstmt.setString(4, dto.getBoardPassword());
	
			pstmt.executeQuery();
			
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
	
	
	public void boardDelete (int searchBoardId) {
		try {
			con = dataFactory.getConnection();

			String query = " DELETE FROM board_info ";
			query +=       " WHERE board_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, searchBoardId);
			pstmt.executeQuery();

			
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
	
	public void boardUpdate (BoardInfoDTO dto) {
		
		try {
			con = dataFactory.getConnection();

			String query = " update board_info ";
			query +=       " set";
			query +=       " board_title = ?";
			query +=       " ,board_desc = ?";
			query +=       " ,board_user = ?";
			query +=       " ,board_time = sysdate";
			query +=       " where board_id = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getBoardTitle());
			pstmt.setString(2, dto.getBoardDesc());
			pstmt.setString(3, dto.getBoardUser());
			pstmt.setInt(4, dto.getBoardId());
			
			
			int result = pstmt.executeUpdate();
			
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
}
