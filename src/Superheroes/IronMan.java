package Superheroes;
import Acciones.AccionesSuperheroe;

public class IronMan extends Superheroe {

	public IronMan() {
		super();
	}
	
	public IronMan(String nombre, int vida, int danio, int resistencia, int agilidad, int armadura) {
		super(nombre, vida, danio, resistencia, agilidad, armadura);
	}
	
	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		if (enemigo.getResistencia() < 7) {
			accion.defensa(enemigo);
		}
		if (jugador.getVida() > 10 && jugador.getVida() <= 20)	{
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
