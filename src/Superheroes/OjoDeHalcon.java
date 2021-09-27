package Superheroes;
import Acciones.AccionesSuperheroe;

public class OjoDeHalcon extends Superheroe {

	public OjoDeHalcon() {
		super();
	}

	public OjoDeHalcon(String nombre, int vida, int danio, int resistencia, int agilidad) {
		super(nombre, vida, danio, resistencia, agilidad);
	}
	
	public void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion) {
		 if (enemigo.getResistencia() < 7) {
			 accion.defensa(enemigo);
		 }
		 else if (jugador.getVida() > 9 && jugador.getVida() <= 20)	{
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
