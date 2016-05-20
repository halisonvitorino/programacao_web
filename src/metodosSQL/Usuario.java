package metodosSQL;



public class Usuario {
	private String chaveUsuario;
	private String senhaUsuario;

	public Usuario() {
		super();
	}

	public String getChaveUsuario() {
		return chaveUsuario;
	}

	public void setChaveUsuario(String chaveUsuario) {
		this.chaveUsuario = chaveUsuario;
	}

	protected String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chaveUsuario == null) ? 0 : chaveUsuario.hashCode());
		result = prime * result + ((senhaUsuario == null) ? 0 : senhaUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (chaveUsuario == null) {
			if (other.chaveUsuario != null)
				return false;
		} else if (!chaveUsuario.equals(other.chaveUsuario))
			return false;
		if (senhaUsuario == null) {
			if (other.senhaUsuario != null)
				return false;
		} else if (!senhaUsuario.equals(other.senhaUsuario))
			return false;
		return true;
	}
}
