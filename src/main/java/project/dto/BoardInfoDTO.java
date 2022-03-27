package project.dto;

import java.sql.Date;

public class BoardInfoDTO {
	
	private int board_id;
	private String board_title;
	private String board_desc;
	private String board_user;
	private String board_comment;
	private String board_password;
	
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_desc() {
		return board_desc;
	}
	public void setBoard_desc(String board_desc) {
		this.board_desc = board_desc;
	}
	public String getBoard_user() {
		return board_user;
	}
	public void setBoard_user(String board_user) {
		this.board_user = board_user;
	}
	public String getBoard_comment() {
		return board_comment;
	}
	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}
	public String getBoard_password() {
		return board_password;
	}
	public void setBoard_password(String board_password) {
		this.board_password = board_password;
	}
	
	
	
	
}
