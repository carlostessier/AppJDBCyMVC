package es.tessier.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import es.tessier.jdbc.modelo.Departamento;
import es.tessier.jdbc.modelo.ElementoDepartamento;

public class DepartamentoDAOImp extends GestorDB implements DepartamentoDAO {

	@Override
	public ArrayList<Departamento> getDepartamentoPorEmp(int empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> getDepartamentos() {
		List<Departamento> listaDep = new ArrayList<Departamento>();
		/* Sentencia sql */
		try (Statement stmt = getConexion().createStatement()) {

			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectDepartamentos"))) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					int depNo = rs.getInt(DepartamentoDAO.COLUMN_CLAVE);
					String dNombre = rs.getString(DepartamentoDAO.COLUMN_DNOMBRE);
					String loc = rs.getString(DepartamentoDAO.COLUMN_LOC);
					listaDep.add(new Departamento(depNo,dNombre,loc));
				}

			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return listaDep;
	}

	public Vector<ElementoDepartamento> getVectorDepartamentos() {
		Vector vectorDep = new Vector();
		/* Sentencia sql */
		try (Statement stmt = getConexion().createStatement()) {

			try (ResultSet rs = stmt.executeQuery(getRb().getString("selectDepartamentos"))) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					int depNo = rs.getInt(DepartamentoDAO.COLUMN_CLAVE);
					String dNombre = rs.getString(DepartamentoDAO.COLUMN_DNOMBRE);
					vectorDep.addElement(new ElementoDepartamento(depNo,dNombre));
				}

			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return vectorDep;
	}



	@Override
	public Departamento getDepartamento(int empNo) {
		Departamento departamento = new Departamento();

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion()
				.prepareStatement(getRb().getString("selectDepartamentoPorEmpleado"))) {
			pstmt.setInt(1, empNo);
			try (ResultSet rs = pstmt.executeQuery()) {

				// Recuperacion de los datos del ResultSet
				if (rs.next()) {
					int depNo = rs.getInt(DepartamentoDAO.COLUMN_CLAVE);
					String dNombre = rs.getString(DepartamentoDAO.COLUMN_DNOMBRE);
					String loc = rs.getString(DepartamentoDAO.COLUMN_LOC);
					departamento = new Departamento(depNo, dNombre, loc);

				}

			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

		return departamento;
	}

	@Override
	public void updateDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartamento(int depNo) {
		// TODO Auto-generated method stub

	}

}
