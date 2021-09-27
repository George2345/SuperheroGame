package Acciones;
import Superheroes.Superheroe;

public class AccionesSuperheroe implements Accion {

	@Override
	public void ataque(Superheroe jugador, Superheroe enemigo) {
		System.out.println(jugador.getNombre() + " ataca a " + enemigo.getNombre());
		boolean acertar = jugador.probAcertar(jugador, enemigo);
		if (jugador.getResistencia() < 3) {
			System.out.println("No tienes resistencia (defiendete para ganar resistencia)");
		}
		else if (acertar == true && jugador.getResistencia() > 2) {
			System.out.println("Acertaste!");
			int vidaActualizada = 0;
	        vidaActualizada = enemigo.getVida() - jugador.getDanio();
	        enemigo.setVida(vidaActualizada);
	        jugador.setResistencia(jugador.getResistencia() - 3);
		}
		else if (acertar == false) {
			System.out.println("Has fallado!");
			jugador.setResistencia(jugador.getResistencia() - 3);
		}
        
	}

	@Override
	public void defensa(Superheroe superheroe) {
		System.out.println(superheroe.getNombre() + " se defiende");
		superheroe.setResistencia(superheroe.getResistencia() + 10);
	}

	@Override
	public void ataqueEspecial(Superheroe jugador, Superheroe enemigo) {
		System.out.println(jugador.getNombre() + " realiza un ataque especial sobre " + enemigo.getNombre());
		boolean acertar = jugador.probAcertar(jugador, enemigo);
		if (jugador.getResistencia() < 7) {
			System.out.println("No tienes resistencia (defiendete para ganar resistencia)");
		}
		else if (acertar == true) {
			System.out.println("Acertaste!");
			switch (jugador.getNombre()) {
			case "Capitan America":
				if (enemigo.getVida() < 8) {
					enemigo.setVida(0);
				}
				else {
					jugador.setResistencia(jugador.getResistencia() + 3);
					enemigo.setVida(enemigo.getVida() - 2);
				}
				break;
			case "Hulk":
				jugador.setVida(jugador.getVida() / 2);
				enemigo.setVida(enemigo.getVida() - 10);
				break;
			case "Iron Man": 
				enemigo.setVida(enemigo.getVida() / 2);
				jugador.setVida(jugador.getVida() + jugador.getArmadura());
				jugador.setAgilidad(jugador.getAgilidad() - 2);
				break;
			case "Ojo de halcon":
				enemigo.setDanio(enemigo.getDanio() - 5);
				enemigo.setVida(enemigo.getVida() - jugador.getResistencia());
				break;
			case "Thor":
				jugador.setDanio(jugador.getDanio() + 5);
				enemigo.setVida(enemigo.getVida() - jugador.getArmadura());
				break;
			case "Viuda negra":
				enemigo.setResistencia(enemigo.getResistencia() - 5);
				enemigo.setVida(enemigo.getVida() - 5);
				break;
			default:
				enemigo.setVida(enemigo.getVida() - (jugador.getDanio() + 5));
				break;
			}
			jugador.setResistencia(jugador.getResistencia() - 7);
		}
		else if (acertar == false) {
			System.out.println("Has fallado!");
			jugador.setResistencia(jugador.getResistencia() - 7);
		} 
	}

	@Override
	public void huida(Superheroe superheroe) {
		System.out.println(superheroe.getNombre() + " es un cobarde");
	}

}
