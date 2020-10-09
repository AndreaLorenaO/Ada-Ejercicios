package inicio.teatro;

public class Butaca {

	private int posicion;
	private boolean ocupado;

	public Butaca() {
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public void mostrarPrecio() {
		switch (posicion / 10) {
		case 0:
			System.out.println("La butaca has seleccionado cuesta $100");
			break;
		case 1:
			System.out.println("La butaca has seleccionado cuesta $80");
			break;
		case 2:
			System.out.println("La butaca has seleccionado cuesta $60");
			break;
		case 3:
			System.out.println("La butaca has seleccionado cuesta $40");
			break;
		case 4:
			System.out.println("La butaca has seleccionado cuesta $20");
			break;
		default:
			System.out.println("Numero no valido");
			break;
		}
	}

}
