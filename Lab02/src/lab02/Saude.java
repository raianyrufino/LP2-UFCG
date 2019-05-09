package lab02;

public class Saude {

	private String saudeMental;
	private String saudeFisica;

	public void defineSaudeMental(String saudeMental) {
		this.saudeMental = saudeMental;
	}

	public void defineSaudeFisica(String saudeFisica) {
		this.saudeFisica = saudeFisica;
	}

	public String getStatusGeral() {
		if ((this.saudeFisica == "fraca") && (this.saudeMental == "fraca")) {
			return "fraca";
		} else if ((this.saudeFisica == "boa") && (this.saudeMental == "boa")) {
			return "boa";
		} else {
			return "ok";
		}
	}
}
