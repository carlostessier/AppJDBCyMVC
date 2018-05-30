package es.tessier.jdbc.dao;

import java.util.List;

import es.tessier.jdbc.modelo.Empleado;

public interface EmpleadoDAO {
	
	public static final String TABLE_NAME = "empleados";
	public static final String COLUMN_CLAVE="emp_no";
	public static final String COLUMN_APELLIDO="apellido";
	public static final String COLUMN_OFICIO="oficio";
	public static final String COLUMN_DIR="dir";
	public static final String COLUMN_FECHA_ALT="fecha_alt";
	public static final String COLUMN_SALARIO="salario";
	public static final String COLUMN_COMISION="comision";
	public static final String COLUMN_DEPT_NO=DepartamentoDAO.COLUMN_CLAVE; 


	

	/*	Crear un método que devuelva en todos los objetos empleados de un departamento dado. */
	public List<Empleado> getEmpleadoPorDep(int depNo);

	
	/*Crear un método que devuelva el objeto empleado con el máximo salario.*/
	
	public Empleado getEmpleadoMaxSalario();
	
	public List<Empleado> getEmpleados();	
	
	public Empleado getEmpleado(int empNo);
	
	public Empleado saveEmpleado(Empleado empleado);
	
	public Empleado updateEmpleado(Empleado empleado);
	
	public int deleteEmpelado(int empNo);
	
	public Empleado primerEmpleado();
	
	public  Empleado ultimoEmpleado();



}
