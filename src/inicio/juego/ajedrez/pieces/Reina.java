package inicio.juego.ajedrez.pieces;

import inicio.juego.ajedrez.Color;
import inicio.juego.ajedrez.Fichas;
import inicio.juego.ajedrez.Figura;
import inicio.juego.ajedrez.Posiciones;

public class Reina extends Fichas {

	public Reina(Figura figura, Color color, int numero) {
		super(figura, color, numero);
	}

	@Override
	public boolean validateMove(Posiciones origen, Posiciones dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(Posiciones origen, Posiciones dest) {
		// TODO Auto-generated method stub
		return false;
	}

}
