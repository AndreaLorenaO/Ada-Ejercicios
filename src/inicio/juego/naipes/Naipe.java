package inicio.juego.naipes;

public class Naipe {

	private NumeroNaipe numero;
	private Palo palo;

	public Naipe(NumeroNaipe numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
//		this.color = color;
	}

	public NumeroNaipe getNumero() {
		return numero;
	}

	public void setNumero(NumeroNaipe numero) {
		this.numero = numero;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public String toString() {
		return "Naipe:" + numero + "[" + palo + "] ";
	}

}
