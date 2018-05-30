package es.tessier.jdbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import es.tessier.jdbc.modelo.Empleado;

public class EmpleadoDAOImp extends GestorDB implements EmpleadoDAO {

	private JdbcRowSet rowSet;

	public EmpleadoDAOImp() {
		
		try {
			rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Empleado> getEmpleadoPorDep(int depNo) {
		List<Empleado> listado = new ArrayList<Empleado>();

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion()
				.prepareStatement( getRb().getString("selectEmpleadoPorDepartamento"))) {
			pstmt.setInt(1, depNo);

			try (ResultSet rs = pstmt.executeQuery()) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {

					Empleado emp = getEmpleadoResultSet(rs);

					listado.add(emp);
				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return listado;
	}

	@Override
	public Empleado getEmpleadoMaxSalario() {
		Empleado empleado = new Empleado();

		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectEmpleadoMaxSalario"))) {

				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);
				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		int filas = 0;
		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("insertEmpleado"))) {
			pstmt.setInt(1, empleado.getEmpNo());
			pstmt.setString(2, empleado.getApellido());
			pstmt.setString(3, empleado.getOficio());
			pstmt.setInt(4, empleado.getDir());
			java.sql.Date sqlDate = new java.sql.Date(empleado.getFechaAlta().getTime());
			pstmt.setDate(5, sqlDate);
			pstmt.setFloat(6, empleado.getSalario());
			pstmt.setFloat(7, empleado.getComision());
			pstmt.setInt(8, empleado.getDepNo());

			filas = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());

		}
		if (filas == 0) {
			return new Empleado();
		} else
			return empleado;
	}

	@Override
	public List<Empleado> getEmpleados() {
		List<Empleado> listado = new ArrayList<Empleado>();
		try (Statement stmt = getConexion().createStatement()){			
			
			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectEmpleados"))) {
				while (rs.next()) {
					Empleado emp = getEmpleadoResultSet(rs);
					listado.add(emp);
				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return listado;
	}

	@Override
	public Empleado getEmpleado(int empNo) {
		Empleado empleado = new Empleado();

		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("selectEmpleadoPorClave"))) {
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);
				}
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		Empleado emp = new Empleado();
		int filas = 0;
		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("updateEmpleado"))) {
			pstmt.setString(1, empleado.getApellido());
			pstmt.setString(2, empleado.getOficio());
			pstmt.setInt(3, empleado.getDir());
			java.sql.Date sqlDate = new java.sql.Date(empleado.getFechaAlta().getTime());
			pstmt.setDate(4, sqlDate);
			pstmt.setFloat(5, empleado.getSalario());
			pstmt.setFloat(6, empleado.getComision());
			pstmt.setInt(7, empleado.getDepNo());
			pstmt.setInt(8, empleado.getEmpNo());		
			filas = pstmt.executeUpdate();
			emp = empleado;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());

		}
		return emp;
	}

	@Override
	public int deleteEmpelado(int empNo) {
		int filas = 0;
		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("deleteEmpleado"))) {
			pstmt.setInt(1, empNo);
		
			filas = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());

		}
		if (filas == 0) {
			return 0;
		} else
			return empNo;
	}

	

	@Override
	public Empleado primerEmpleado() {
		Empleado empleado = new Empleado();

		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectPrimerEmpleado"))) {
				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);
				}
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	@Override
	public Empleado ultimoEmpleado() {
		Empleado empleado = new Empleado();

		/* Sentencia sql */
		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectUltimoEmpleado"))) {

				// Recuperacion de los datos del ResultSet
				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);

				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	public Empleado siguienteEmpleado(int empNo) {
		Empleado empleado = new Empleado();

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("selectSigEmpleado"))) {
			pstmt.setInt(1, empNo);

			try (ResultSet rs = pstmt.executeQuery()) {

				// Recuperacion de los datos del ResultSet
				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);

				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	public Empleado anteriorEmpleado(int empNo) {
		Empleado empleado = new Empleado();

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(getRb().getString("selectEmpleadoAnterior"))) {
			pstmt.setInt(1, empNo);

			try (ResultSet rs = pstmt.executeQuery()) {

				// Recuperacion de los datos del ResultSet
				if (rs.next()) {
					empleado = getEmpleadoResultSet(rs);

				}
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return empleado;
	}

	private Empleado getEmpleadoResultSet(ResultSet rs) throws SQLException {
		Empleado empleado;
		int empNo = rs.getInt(EmpleadoDAO.COLUMN_CLAVE);
		String apellido = rs.getString(EmpleadoDAO.COLUMN_APELLIDO);
		String oficio = rs.getString(EmpleadoDAO.COLUMN_OFICIO);
		short dir = rs.getShort(EmpleadoDAO.COLUMN_DIR);
		Date fechaAlta = rs.getDate(EmpleadoDAO.COLUMN_FECHA_ALT);
		float salario = rs.getFloat(EmpleadoDAO.COLUMN_SALARIO);
		float comision = rs.getFloat(EmpleadoDAO.COLUMN_COMISION);
		int depNo = rs.getInt(EmpleadoDAO.COLUMN_DEPT_NO);

		empleado = new Empleado(empNo, apellido, oficio, dir, fechaAlta, salario, comision, depNo);
		return empleado;
	}

}
