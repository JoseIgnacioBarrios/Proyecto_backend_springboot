package model;

public class Resultado {
	
	private String url;
	private String tematica;
	private String des;
	public Resultado(String url, String tematica, String des) {
		super();
		this.url = url;
		this.tematica = tematica;
		this.des = des;
	}
	public Resultado() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	

}
