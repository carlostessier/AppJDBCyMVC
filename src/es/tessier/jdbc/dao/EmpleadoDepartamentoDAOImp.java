package es.tessier.jdbc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.tessier.jdbc.modelo.EmpleadoDepartamento;

public class EmpleadoDepartamentoDAOImp extends GestorDB implements EmpleadoDepartamentoDAO{
	
	private static final String SELECT_EMPLEADO_DEPARTAMENTO_QUERY =
			"SELECT * FROM empleados INNER JOIN departamentos ON empleados.dept_no = departamentos.dept_no";

	
	
	public EmpleadoDepartamentoDAOImp() {
		super();
		
		
	}


	public EmpleadoDepartamentoDAOImp(String url, String baseDatos, String user, String pass) {
		super(url, baseDatos, user, pass);
		// TODO Auto-generated constructor stub
	}



	@Override
	public List<EmpleadoDepartamento> getEmpleadosyDepartamentos() {
		List<EmpleadoDepartamento> listado = new ArrayList<EmpleadoDepartamento>();
		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery(SELECT_EMPLEADO_DEPARTAMENTO_QUERY)) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					int empNo = rs.getInt(EmpleadoDAO.COLUMN_CLAVE);
					String apellido = rs.getString(EmpleadoDAO.COLUMN_APELLIDO);					
					String oficio = rs.getString(EmpleadoDAO.COLUMN_OFICIO);
					short dir = rs.getShort(EmpleadoDAO.COLUMN_DIR);
					Date fechaAlta = rs.getDate(EmpleadoDAO.COLUMN_FECHA_ALT);
					float salario = rs.getFloat(EmpleadoDAO.COLUMN_SALARIO);
					float comision = rs.getFloat(EmpleadoDAO.COLUMN_COMISION);
					int depNo = rs.getInt(DepartamentoDAO.COLUMN_CLAVE);
					String dNombre = rs.getString(DepartamentoDAO.COLUMN_DNOMBRE);				
					String loc  = rs.getString(DepartamentoDAO.COLUMN_DNOMBRE);

					EmpleadoDepartamento empDep = 
							new EmpleadoDepartamento (empNo,  apellido,  oficio,  dir,  fechaAlta,
									salario, comision, depNo,  dNombre,  loc);					
					
				
					listado.add(empDep);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return listado;
	}

}
