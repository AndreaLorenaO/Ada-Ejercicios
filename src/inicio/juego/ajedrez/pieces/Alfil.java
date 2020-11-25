package inicio.juego.ajedrez.pieces;

import inicio.juego.ajedrez.Color;
import inicio.juego.ajedrez.Fichas;
import inicio.juego.ajedrez.Figura;
import inicio.juego.ajedrez.Posiciones;

public class Alfil extends Fichas {

	public Alfil(Figura figura, Color color, int numero) {
		super(figura, color, numero);
	}

	@Override
	public boolean validateMove(Posiciones origen, Posiciones dest) {
		if (origen.getColor().equals(dest.getColor())) {
			if (dest.getFicha() != null && dest.getFicha().getColor().equals(origen.getFicha().getColor())) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	@Override
	public boolean move(Posiciones origen, Posiciones dest) {
		// TODO Auto-generated method stub
		return false;
	}

}
