package project.dto;


public class MapInfoDTO {
	
	private int mapId;
	private String mapLocal;
	private String maplocalInfo;
	private	String mapTel;
	
	
	public int getMapId() {
		return mapId;
	}
	public String getMapTel() {
		return mapTel;
	}
	public void setMapTel(String mapTel) {
		this.mapTel = mapTel;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getMapLocal() {
		return mapLocal;
	}
	public void setMapLocal(String mapLocal) {
		this.mapLocal = mapLocal;
	}
	public String getMaplocalInfo() {
		return maplocalInfo;
	}
	public void setMaplocalInfo(String maplocalInfo) {
		this.maplocalInfo = maplocalInfo;
	}
	
	

	
}
