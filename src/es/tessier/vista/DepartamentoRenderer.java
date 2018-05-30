package es.tessier.vista;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import es.tessier.jdbc.modelo.ElementoDepartamento;

class DepartamentoRenderer extends BasicComboBoxRenderer
{
    
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(
        JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index,
            isSelected, cellHasFocus);

        if (value != null)
        {
            ElementoDepartamento item = (ElementoDepartamento)value;
            setText( item.getdNombre());
        }

        if (index == -1)
        {
        	ElementoDepartamento item = (ElementoDepartamento)value;
            setText( "" + item.getdNombre());
        }


        return this;
    }
}

