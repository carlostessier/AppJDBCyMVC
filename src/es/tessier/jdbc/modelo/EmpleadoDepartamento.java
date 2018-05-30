package es.tessier.jdbc.modelo;

import java.io.Serializable;
import java.sql.Date;

public class EmpleadoDepartamento implements Serializable{


	private static final long serialVersionUID = 1L;
	private int empNo;
	private String apellido;
	private String oficio;
	private short dir;
	private Date fechaAlta;
	private float salario;
	private float comision;
	private int depNo;
	private String dNombre;
	private String loc;	
	
	public EmpleadoDepartamento() {
		this(0,"","",(short)0,null,0f,0f,0,"","");
	}
	
	
	public EmpleadoDepartamento(int empNo, String apellido, String oficio, short dir, Date fechaAlta, 
			float salario,float comision,int depNo, String dNombre, String loc) {
		this.empNo = empNo;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlta = fechaAlta;
		this.comision = comision;
		this.salario = salario;
		this.depNo = depNo;
		this.dNombre = dNombre;
		this.loc = loc;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public short getDir() {
		return dir;
	}
	public void setDir(short dir) {
		this.dir = dir;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		

		return " Numero Empleado: " + empNo 
		+ " - Apellido: " + apellido
		+ " - Puesto: " + oficio
		+ " - Codigo Analatico: " + dir
		+ " - Fecha Alta: " + fechaAlta
		+ " - Salario: " + salario + "€"
		+ " - Comision: " + comision + "€"
		+ " - Numero Departamento: "+ depNo
		+ " - Nombre Departamento: "+ dNombre;
	}
	
	
	
	
}
