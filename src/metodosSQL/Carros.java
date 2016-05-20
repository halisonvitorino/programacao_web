package metodosSQL;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Carros implements Serializable {
	private Integer idCarros;
	private String nomeCarros;
	private String placaCarros;
	
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
	public String getPlacaCarros() {
		return placaCarros;
	}
	public void setPlacaCarros(String placaCarros) {
		this.placaCarros = placaCarros;
	}
	@Override
	public String toString() {
		return "[" + idCarros + " " + nomeCarros + "-" + placaCarros + "]";
	}
	public Carros() {
		super();
	}

	
}