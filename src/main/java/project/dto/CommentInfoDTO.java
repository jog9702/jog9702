package project.dto;

import java.sql.Date;

public class CommentInfoDTO {
	
	private int comment_id;
	private int board_id;
	private String comment_desc;
	private String comment_user;
	private String comment_time;
	private String comment_password;
	
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getComment_desc() {
		return comment_desc;
	}
	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}
	public String getComment_user() {
		return comment_user;
	}
	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_password() {
		return comment_password;
	}
	public void setComment_password(String comment_password) {
		this.comment_password = comment_password;
	}
	
}
