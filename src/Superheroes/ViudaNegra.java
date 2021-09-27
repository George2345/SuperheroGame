package Superheroes;
import Acciones.AccionesSuperheroe;

public class ViudaNegra extends Superheroe {

	public ViudaNegra() {
		super();
	}

	public ViudaNegra(String nombre, int vida, int danio, int resistencia, int agilidad) {
		super(nombre, vida, danio, resistencia, agilidad);
	}

	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		 if (enemigo.getResistencia() < 7) {
			 accion.defensa(enemigo);
		 }
		 else if (jugador.getVida() > 7 && jugador.getVida() <= 20)	{
			 accion.ataque(enemigo, jugador);
		 }
		 else {
			 accion.ataqueEspecial(enemigo, jugador);
		 }
	}
	
	public String toString() {
		return ("Nombre: " + getNombre() + "\nVida: " + getVida() + "\nDaño: " + getDanio() + "\nAgilidad: " + getAgilidad() + "\nResistencia: " + getResistencia());
	}
}
