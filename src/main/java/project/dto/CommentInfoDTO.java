package project.dto;

import java.sql.Date;

public class CommentInfoDTO {
	
	private int commentId;
	private int boardId;
	private String commentDesc;
	private String commentUser;
	private String commentTime;
	private String commentPassword;
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getCommentDesc() {
		return commentDesc;
	}
	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentPassword() {
		return commentPassword;
	}
	public void setCommentPassword(String commentPassword) {
		this.commentPassword = commentPassword;
	}
	
}
