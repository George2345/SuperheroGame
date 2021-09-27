package Superheroes;
import Acciones.AccionesSuperheroe;

public class Hulk extends Superheroe {

	public Hulk() {
		super();
	}

	public Hulk(String nombre, int vida, int danio, int resistencia, int agilidad) {
		super(nombre, vida, danio, resistencia, agilidad);
	}
	
	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		if (enemigo.getResistencia() < 7) {
			 accion.defensa(enemigo);
		}
		else if (jugador.getVida() > 15 && jugador.getVida() <= 20)	{
			accion.ataqueEspecial(enemigo, jugador);
		}
		else if (jugador.getVida() >= 10 && jugador.getVida() < 16) {
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
