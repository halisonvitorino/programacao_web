package metodosSQL;


public enum UF {
	AC("AC", "Acre"), AL("AL", "Alagoas"), AM("AM", "Amazonas"), AP("AP",
			"Amap�"), BA("BA", "Bahia"), CE("CE", "Cear�"), DF("DF",
			"Distrito Federal"), ES("ES", "Esp�rito Santo"), GO("GO", "Goi�s"), MA(
			"MA", "Maranh�o"), MG("MG", "Minas Gerais"), MS("MS",
			"Mato Grosso do Sul"), MT("MT", "Mato Grosso"), PA("PA", "Par�"), PB(
			"PB", "Para�ba"), PE("PE", "Pernambuco"), PI("PI", "Piau�"), PR(
			"PR", "Paran�"), RJ("RJ", "Rio de Janeiro"), RN("RN",
			"Rio Grande do Norte"), RO("RO", "Rond�nia"), RS("RS",
			"Rio Grande do Sul"), SC("SC", "Santa Catarina"), SE("SE",
			"Sergipe"), SP("SP", "S�o Paulo"), TO("TO", "Tocantins");

	private final String codigoUF;
	private final String nomeUF;

	private UF(String codigo, String nome) {

		this.codigoUF = codigo;
		this.nomeUF = nome;
	}

	public String getCodigoUF() {
		return this.codigoUF;
	}

	public String getNomeUF() {
		return this.nomeUF;
	}

}