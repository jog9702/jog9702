package project.dto;

import java.sql.Date;

public class ForeignInfoDTO {
	
	private int foreign_id;
	private String foreign_info;
	private String foreign_danger;
	private String foreign_death;
	private String foreign_time;
	
	
	public int getForeign_id() {
		return foreign_id;
	}
	public void setForeign_id(int foreign_id) {
		this.foreign_id = foreign_id;
	}
	public String getForeign_info() {
		return foreign_info;
	}
	public void setForeign_info(String foreign_info) {
		this.foreign_info = foreign_info;
	}
	public String getForeign_danger() {
		return foreign_danger;
	}
	public void setForeign_danger(String foreign_danger) {
		this.foreign_danger = foreign_danger;
	}
	public String getForeign_death() {
		return foreign_death;
	}
	public void setForeign_death(String foreign_death) {
		this.foreign_death = foreign_death;
	}
	public String getForeign_time() {
		return foreign_time;
	}
	public void setForeign_time(String foreign_time) {
		this.foreign_time = foreign_time;
	}

	
}
