package es.tessier.jdbc.modelo;

import java.io.Serializable;

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private int depNo;
	private String dNombre;
	private String loc;	
	
	public Departamento(){
		this(0,"","");
	}
	
	public Departamento(int depNo, String dNombre, String loc) {
		
		this.depNo = depNo;
		this.dNombre = dNombre;
		this.loc = loc;
	}
	
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public String getdNombre() {
		return dNombre;
	}
	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
