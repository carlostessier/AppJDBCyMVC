package es.tessier.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import es.tessier.controlador.ControladorEmpleado;

public class EmpleadoUI extends JPanel {

	private ControladorEmpleado controlador;

	private JTextField empNoField ;
	private JTextField apellidoField ;
	private JTextField oficioField ;
	private JTextField dirField ;
	private JTextField fechaAltaField;
	private JTextField salarioField ;
	private JTextField comisionField ;
	// private JTextField deptField = new JTextField(2);
	private JComboBox deptComboBox;

	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton firstButton;
	private JButton previousButton;
	private JButton nextButton;
	private JButton lastButton;

	public EmpleadoUI(ControladorEmpleado controlador) {
		this.controlador = controlador;
		setBorder(new TitledBorder(new EtchedBorder(), "Detalles empleado"));
		setLayout(new BorderLayout(5, 5));
		add(initFields(), BorderLayout.NORTH);
		add(initButtons(), BorderLayout.CENTER);
	}

	private JPanel initButtons() {
		createButton = new JButton("New");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		firstButton = new JButton("First");
		previousButton = new JButton("Previous");
		nextButton = new JButton("Next");
		lastButton = new JButton("Last");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		panel.add(createButton);
		createButton.addActionListener(controlador);
		panel.add(updateButton);
		updateButton.addActionListener(controlador);
		panel.add(deleteButton);
		deleteButton.addActionListener(controlador);
		panel.add(firstButton);
		firstButton.addActionListener(controlador);
		panel.add(previousButton);
		previousButton.addActionListener(controlador);
		panel.add(nextButton);
		nextButton.addActionListener(controlador);
		panel.add(lastButton);
		lastButton.addActionListener(controlador);

		return panel;
	}

	private JPanel initFields() {
		empNoField = new JTextField(4);
		apellidoField = new JTextField(20);
		oficioField = new JTextField(30);
		dirField = new JTextField(20);
		fechaAltaField = new JTextField(20);
		salarioField = new JTextField(8);
		comisionField = new JTextField(8);
		// private JTextField deptField = new JTextField(2);

		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(8, 2);
		// layout.setHgap(10);
		// layout.setVgap(10);
		panel.setLayout(layout);
		panel.add(new JLabel("número empleado"));
		panel.add(empNoField);
		// empNoField.setEnabled(false);
		panel.add(new JLabel("Apellido"));
		panel.add(apellidoField);
		panel.add(new JLabel("oficio"));
		panel.add(oficioField);
		panel.add(new JLabel("dir"));
		panel.add(dirField);
		panel.add(new JLabel("fecha Alta"));
		panel.add(fechaAltaField);
		panel.add(new JLabel("salario"));
		panel.add(salarioField);
		panel.add(new JLabel("comison"));
		panel.add(comisionField);
		panel.add(new JLabel("departamento"));

		deptComboBox = new JComboBox();
		// deptComboBox.addActionListener(controlador);

		/*
		 * deptComboBox = new JComboBox(departamentoDAO.getVectorDepartamentos());
		 * deptComboBox.setRenderer( new DepartamentoRenderer() );
		 * deptComboBox.addActionListener(controlador);
		 */
		panel.add(deptComboBox);

		return panel;
	}

	public JTextField getEmpNoField() {
		return empNoField;
	}

	public void setEmpNoField(JTextField empNoField) {
		this.empNoField = empNoField;
	}

	public JTextField getApellidoField() {
		return apellidoField;
	}

	public void setApellidoField(JTextField apellidoField) {
		this.apellidoField = apellidoField;
	}

	public JTextField getDirField() {
		return dirField;
	}

	public void setDirField(JTextField dirField) {
		this.dirField = dirField;
	}

	public JTextField getFechaAltaField() {
		return fechaAltaField;
	}

	public void setFechaAltaField(JTextField fechaAltaField) {
		this.fechaAltaField = fechaAltaField;
	}

	public JTextField getSalarioField() {
		return salarioField;
	}

	public void setSalarioField(JTextField salarioField) {
		this.salarioField = salarioField;
	}

	public JTextField getComisionField() {
		return comisionField;
	}

	public void setComisionField(JTextField comisionField) {
		this.comisionField = comisionField;
	}

	public JComboBox getDeptCombo() {
		return deptComboBox;
	}

	public void setDeptCombo(JComboBox deptField) {
		this.deptComboBox = deptField;
	}

	public JTextField getOficioField() {
		return oficioField;
	}

	public void setOficioField(JTextField oficioField) {
		this.oficioField = oficioField;
	}

}
