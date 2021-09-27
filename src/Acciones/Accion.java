package Acciones;
import Superheroes.Superheroe;

public interface Accion {
	void ataque(Superheroe jugador, Superheroe enemigo);			
	void defensa(Superheroe superheroe);						
	void ataqueEspecial(Superheroe jugador, Superheroe enemigo);		
	void huida(Superheroe superheroe);
}
