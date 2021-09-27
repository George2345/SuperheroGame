package Superheroes;
import Acciones.AccionesSuperheroe;

public class Jugador extends Superheroe {
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, int vida, int danio, int resistencia, int agilidad) {
		super(nombre, vida, danio, resistencia, agilidad);
	}

	@Override
	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		
		
	}

}
