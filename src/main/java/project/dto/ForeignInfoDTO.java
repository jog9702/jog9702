package project.dto;

import java.sql.Date;

public class ForeignInfoDTO {
	
	private int foreignId;
	private int foreignInfo;
	private int foreignDanger;
	private int foreignDeath;
	private String foreignLocal;
	private int foreignLocalInfo;
	private String foreignTime;
	
	
	public int getForeignId() {
		return foreignId;
	}
	public void setForeignId(int foreignId) {
		this.foreignId = foreignId;
	}
	public int getForeignInfo() {
		return foreignInfo;
	}
	public void setForeignInfo(int foreignInfo) {
		this.foreignInfo = foreignInfo;
	}
	public int getForeignDanger() {
		return foreignDanger;
	}
	public void setForeignDanger(int foreignDanger) {
		this.foreignDanger = foreignDanger;
	}
	public int getForeignDeath() {
		return foreignDeath;
	}
	public void setForeignDeath(int foreignDeath) {
		this.foreignDeath = foreignDeath;
	}
	public String getForeignLocal() {
		return foreignLocal;
	}
	public void setForeignLocal(String foreignLocal) {
		this.foreignLocal = foreignLocal;
	}
	public int getForeignLocalInfo() {
		return foreignLocalInfo;
	}
	public void setForeignLocalInfo(int foreignLocalInfo) {
		this.foreignLocalInfo = foreignLocalInfo;
	}
	public String getForeignTime() {
		return foreignTime;
	}
	public void setForeignTime(String foreignTime) {
		this.foreignTime = foreignTime;
	}
	
	
	
	
}
