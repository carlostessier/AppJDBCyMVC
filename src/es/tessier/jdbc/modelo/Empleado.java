package es.tessier.jdbc.modelo;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable{


	private static final long serialVersionUID = 1L;
	private int empNo;
	private String apellido;
	private String oficio;
	private short dir;
	private Date fechaAlta;
	private float salario;
	private float comision;
	private int depNo;

	
	public Empleado() {
		this(0,"","",(short)0,new Date(),0f,0f,0);
	}
	
	
	public Empleado(int empNo, String apellido, String oficio, short dir, Date fechaAlta, float salario, float comision, int depNo) {
		this.empNo = empNo;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
		this.depNo = depNo;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	
}
