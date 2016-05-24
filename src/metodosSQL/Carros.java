package metodosSQL;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Carros implements Serializable {
	private Integer idCarros;
	private String nomeCarros;
	private String ufCarros;
	private String modeloCarros;
	public Integer getIdCarros() {
		return idCarros;
	}
	public void setIdCarros(Integer idCarros) {
		this.idCarros = idCarros;
	}
	public String getNomeCarros() {
		return nomeCarros;
	}
	public void setNomeCarros(String nomeCarros) {
		this.nomeCarros = nomeCarros;
	}
	public String getUfCarros() {
		return ufCarros;
	}
	public void setUfCarros(String placaCarros) {
		this.ufCarros = ufCarros;
	}
	public String getModeloCarros() {
		return modeloCarros;
	}
	public void setModeloCarros(String modeloCarros) {
		this.modeloCarros = modeloCarros;
	}
	@Override
	public String toString() {
		return "[" + idCarros + " " + nomeCarros + "-" + modeloCarros + "-" + ufCarros + "]";
	}
	public Carros() {
		super();
	}

	
}