package Superheroes;
import Acciones.AccionesSuperheroe;

public class Thor extends Superheroe {

	public Thor() {
		super();
	}

	public Thor(String nombre, int vida, int danio, int resistencia, int agilidad, int armadura) {
		super(nombre, vida, danio, resistencia, agilidad, armadura);
	}

	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		 if (enemigo.getResistencia() < 7) {
			 accion.defensa(enemigo);
		 }
		 else if (jugador.getVida() > 16 && jugador.getVida() <= 20 || jugador.getResistencia() > 13)	{
			 accion.ataque(enemigo, jugador);
		 }
		 else if (jugador.getVida() > 9 && jugador.getVida() < 17) {
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
