package Superheroes;
import Acciones.AccionesSuperheroe;

public class CapitanAmerica extends Superheroe {
	
	public CapitanAmerica() {
		super();
	}

	public CapitanAmerica(String nombre, int vida, int danio, int resistencia, int agilidad) {
		super(nombre, vida, danio, resistencia, agilidad);
	}

	@Override
	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		 if (enemigo.getResistencia() < 7) {
			 accion.defensa(enemigo);
		 }
		 else if (jugador.getVida() > 12 && jugador.getVida() <= 20)	{
			 accion.ataque(enemigo, jugador);
		 }
		 else if (jugador.getVida() > 6 && jugador.getVida() < 13) {
			 accion.ataqueEspecial(enemigo, jugador);
		 }
		 else {
			 accion.ataque(enemigo, jugador);
		 }
	}
	
	public String toString() {
		return ("Nombre: " + getNombre() + "\nVida: " + getVida() + "\nDaño: " + getDanio() + "\nAgilidad: " + getAgilidad() + "\nResistencia: " + getResistencia());
	}
}
