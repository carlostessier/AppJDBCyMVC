package es.tessier.controlador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.tessier.jdbc.dao.DepartamentoDAOImp;
import es.tessier.jdbc.dao.EmpleadoDAOImp;
import es.tessier.jdbc.modelo.Departamento;
import es.tessier.jdbc.modelo.ElementoDepartamento;
import es.tessier.jdbc.modelo.Empleado;
import es.tessier.vista.EmpleadoUI;

public class ControladorEmpleado implements ActionListener {

	private EmpleadoDAOImp empleadoDAO;
	private DepartamentoDAOImp departamentoDAO;

	private EmpleadoUI vista;

	public ControladorEmpleado() {
		empleadoDAO = new EmpleadoDAOImp();
		departamentoDAO = new DepartamentoDAOImp();
		vista = new EmpleadoUI(this);
				
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		f.getContentPane().add(vista);
		f.setSize(800, 350);
		f.setVisible(true);
		setFieldData(empleadoDAO.primerEmpleado());
	}

	private boolean isEmptyFieldData() {
		
		  return (vista.getEmpNoField().getText().trim().isEmpty() &&
				  vista.getApellidoField().getText().trim().isEmpty() &&
				  vista.getFechaAltaField().getText().trim().isEmpty()  &&
				   vista.getSalarioField().getText().trim().isEmpty()) ;
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Person p = getFieldData();
		switch (e.getActionCommand()) {
		case "Save":
			System.out.println("save");		 
			break;
		case "New":
			if (isEmptyFieldData()) {
				JOptionPane.showMessageDialog(null, "Faltan datos por completas");
				return;
			}
			System.out.println("save");
					
			  if (empleadoDAO.saveEmpleado(getFieldData()).getDepNo() != 0) JOptionPane.showMessageDialog(null,
			  "Añadido correctamente el nuevo empleado");
			 
			System.out.println("New");

			break;
		case "Update":
			/*
			 * if (isEmptyFieldData()) { JOptionPane.showMessageDialog(null,
			 * "Cannot update an empty record"); return; } if (bean.update(p) != null)
			 * JOptionPane.showMessageDialog(null, "Person with ID:" +
			 * String.valueOf(p.getPersonId() + " is updated successfully"));
			 */
			System.out.println("Update");
			break;
		case "Delete":
			
			  if (vista.getEmpNoField().getText().trim().isEmpty()) { 
				  JOptionPane.showMessageDialog(null,"Debe indicar el número de empleado"); 
				  	return; 
			  }
			  int empNo = Integer.parseInt(vista.getEmpNoField().getText().trim());
			  if (empleadoDAO.deleteEmpelado(empNo)>0) {
			  JOptionPane.showMessageDialog(null, "El empleado ID:" + empNo + " ha sido borrado correctamente");
			  setFieldData(new Empleado());
			  }
			 
			System.out.println("Delete");
			break;
		case "First":
			setFieldData(empleadoDAO.primerEmpleado());
			break;
		case "Previous":
			setFieldData(empleadoDAO.anteriorEmpleado(Integer.parseInt(vista.getEmpNoField().getText())));
			break;
		case "Next":
			setFieldData(empleadoDAO.siguienteEmpleado(Integer.parseInt(vista.getEmpNoField().getText())));
			System.out.println("next");
			break;
		case "Last":
			setFieldData(empleadoDAO.ultimoEmpleado());
			break;
		default:
			JOptionPane.showMessageDialog(null, "invalid command");
		}
	}

	private Empleado getFieldData() {
		
		Empleado e = new Empleado();
		e.setEmpNo(Short.valueOf(vista.getEmpNoField().getText()));
		e.setApellido(vista.getApellidoField().getText());
		e.setOficio(vista.getOficioField().getText());
		e.setDir(Short.valueOf(vista.getDirField().getText()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = vista.getFechaAltaField().getText();
		Date date = new Date();
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e1) {

		}

		e.setFechaAlta(date);
		e.setSalario(Float.parseFloat(vista.getSalarioField().getText()));
		e.setComision(Float.parseFloat(vista.getComisionField().getText()));
	
		
		vista.getComisionField().setText(String.valueOf(e.getSalario()));
		
        ElementoDepartamento dep = (ElementoDepartamento)vista.getDeptCombo().getSelectedItem();
		e.setDepNo(dep.getDepNo());

		return e;
	}

	private void setFieldData(Empleado e) {
		vista.getEmpNoField().setText(String.valueOf(e.getEmpNo()));
		vista.getApellidoField().setText(e.getApellido());
		vista.getOficioField().setText(e.getOficio());
		vista.getDirField().setText(String.valueOf(e.getDir()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sFecha = sdf.format(e.getFechaAlta());
		
		vista.getFechaAltaField().setText(String.valueOf(sFecha));
		vista.getSalarioField().setText(String.valueOf(e.getSalario()));
		vista.getComisionField().setText(String.valueOf(e.getSalario()));
		
		Departamento dep = departamentoDAO.getDepartamento(e.getEmpNo());
		for(ElementoDepartamento elem :departamentoDAO.getVectorDepartamentos()) {
			vista.getDeptCombo().addItem(elem);
		}
        ElementoDepartamento elem = new ElementoDepartamento(dep.getDepNo(),dep.getdNombre());
        int index = departamentoDAO.getVectorDepartamentos().indexOf(elem);

        System.out.println(elem+" "+index);
		vista.getDeptCombo().setSelectedIndex(index);
		
	}
}