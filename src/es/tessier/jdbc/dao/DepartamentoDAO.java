package es.tessier.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import es.tessier.jdbc.modelo.Departamento;

public interface DepartamentoDAO {
	
	public static final String TABLE_NAME = "departamentos";
	public static final String COLUMN_CLAVE="dept_no";
	public static final String COLUMN_DNOMBRE="dnombre";
	public static final String COLUMN_LOC="loc";
	
	/*	Crear un método que pida por al usuario un departamento e imprima el Apellido, oficio y salario de los empleados de ese departamento. 
	 *
	 */
	public ArrayList<Departamento> getDepartamentoPorEmp(int empNo);
	
	public List<Departamento> getDepartamentos();
	
	public Departamento getDepartamento(int empNo);
	
	public void updateDepartamento(Departamento departamento);
	
	public void deleteDepartamento(int depNo);

}
