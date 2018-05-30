package es.tessier.jdbc.modelo;

public class ElementoDepartamento {
	
	private int depNo;
	private String dNombre;
	
	public int getDepNo() {
		return depNo;
	}
	
	public ElementoDepartamento() {
		this(0,"");
	}
	

	public ElementoDepartamento(int depNo, String dNombre) {
		super();
		this.depNo = depNo;
		this.dNombre = dNombre;
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
	
	
	@Override
	public String toString() {
		return dNombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dNombre == null) ? 0 : dNombre.hashCode());
		result = prime * result + depNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoDepartamento other = (ElementoDepartamento) obj;
		
		if (depNo != other.depNo)
			return false;
		return true;
	}
	
	
	
}
