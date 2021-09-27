package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Acciones.AccionesSuperheroe;
import GUI.TextDemo;
import GUI.VentanaDatos;
import Superheroes.CapitanAmerica;
import Superheroes.Hulk;
import Superheroes.IronMan;
import Superheroes.Jugador;
import Superheroes.OjoDeHalcon;
import Superheroes.Superheroe;
import Superheroes.Thor;
import Superheroes.ViudaNegra;

import java.io.*;

public class Juego {

	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Bienvenido a mi juego, disfruta!");
		String nombre = JOptionPane.showInputDialog(null, "Introduzca su nombre:");
		int puntosHabilidad = 20;
		int aux, vida = 20, danio = 0, agilidad = 0, resistencia = 0;
		
		System.out.println("Creando jugador. Habilidades: daño, agilidad y resistencia");
		
		/*VentanaDatos ventanaDatos = new VentanaDatos();
		ventanaDatos.setVisible(true);*/
		
		//Se piden los datos para crear a un jugador
		do {
			try {
				System.out.println("Te quedan " + puntosHabilidad + " puntos");
				System.out.println("Añadir puntos de daño: ");
				aux = reader.nextInt();
				if (puntosHabilidad - aux >= 0 && aux + danio > 0 && aux + danio <= 20 && puntosHabilidad != 0) {
					danio += aux;
					if (aux < 0) {
						puntosHabilidad += aux;
					}
					else {
						puntosHabilidad -= aux;
					}
				}
				else {
					throw new Exception("No se permite asignar más de " + puntosHabilidad + " puntos");
				}
				if (puntosHabilidad == 0) {
					break;
				}
				System.out.println("Te quedan " + puntosHabilidad + " puntos");
				System.out.println("Añadir puntos de agilidad: ");
				aux = reader.nextInt();
				if (puntosHabilidad - aux >= 0 && aux + agilidad <= 20 && aux + agilidad > 0 && puntosHabilidad != 0) {
					agilidad += aux;
					if (aux < 0) {
						puntosHabilidad += aux;
					}
					else {
						puntosHabilidad -= aux;
					}
				}
				else {
					throw new Exception("No se permite asignar más de " + puntosHabilidad + " puntos");
				}
				if (puntosHabilidad == 0) {
					break;
				}
				System.out.println("Te quedan " + puntosHabilidad + " puntos");
				System.out.println("Añadir puntos de resistencia:  ");
				aux = reader.nextInt();
				if (puntosHabilidad - aux >= 0 && aux + resistencia <= 20 && aux + resistencia > 0 && puntosHabilidad != 0) {
					resistencia += aux;
					if (aux < 0) {
						puntosHabilidad += aux;
					}
					else {
						puntosHabilidad -= aux;
					}
				}
				else {
					throw new Exception("No se permite asignar más de " + puntosHabilidad + " puntos");
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Daño: " + danio + "\nAgilidad: " + agilidad + "\nResistencia: " + resistencia + "\n");
			
		} while (puntosHabilidad != 0);
		
		TextDemo textDemo = new TextDemo("Atributos finales:\nNombre: " + nombre + "\nVida: " + vida + "\nDaño: " + danio + "\nAgilidad: " + agilidad + "\nResistencia: " + resistencia);
		textDemo.setVisible(true);
		System.out.println();
		Jugador jugador = new Jugador(nombre, vida, danio, resistencia, agilidad);
		
		//Superheroes
		CapitanAmerica capitanAmerica = new CapitanAmerica();
		Hulk hulk = new Hulk();
		IronMan ironMan = new IronMan();
		OjoDeHalcon ojoDeHalcon = new OjoDeHalcon();
		Thor thor = new Thor();
		ViudaNegra viudaNegra = new ViudaNegra();

		
		System.out.println("Creando superheroes");
		
		File fichero = new File("superheroes.txt");
		Scanner s;
		
		//Lectura de los atributos de los superheroes desde un fichero txt
		try {
			 s = new Scanner(fichero);
			 while (s.hasNextLine()) {
				 String linea = s.nextLine();
				 Scanner sl = new Scanner(linea);
				 sl.useDelimiter(";");
				 String nombreSh = sl.next();
				 String vidaShAux = sl.next();
				 int vidaSh = Integer.parseInt(vidaShAux);
				 String danioShAux = sl.next();
				 int danioSh = Integer.parseInt(danioShAux);
				 String resistenciaShAux = sl.next();
				 int resistenciaSh = Integer.parseInt(resistenciaShAux);
				 String agilidadShAux = sl.next();
				 int agilidadSh = Integer.parseInt(agilidadShAux);
				 sl.close();
				 
				 switch (nombreSh) {
				 case "Capitan America":
					 capitanAmerica = new CapitanAmerica(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh);
					 break;
				 case "Hulk":
					 hulk = new Hulk(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh);
					 break;
				 case "IronMan":
					 ironMan = new IronMan(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh, 20);
					 break;
				 case "Ojo de halcon":
					 ojoDeHalcon = new OjoDeHalcon(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh);
					 break;
				 case "Thor":
					 thor = new Thor(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh, 10);
					 break;
				 case "Viuda Negra": 
					 viudaNegra = new ViudaNegra(nombreSh, vidaSh, danioSh, resistenciaSh, agilidadSh);
					 break;
				default:
					System.out.println("No existe el superheroe");
					break;
				 }
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Comienzo de la partida
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				combate(jugador, capitanAmerica, i + 1);
				break;
			case 1:
				combate(jugador, hulk, i + 1);
				break;
			case 2:
				combate(jugador, ironMan, i + 1);
				break;
			case 3:
				combate(jugador, ojoDeHalcon, i + 1);
				break;
			case 4:
				combate(jugador, thor, i + 1);
				break;
			case 5:
				combate(jugador, viudaNegra, i + 1);
				break;
			}
			
		}
	}

	//Realiza el combate entre el jugador y enemigo
	private static void combate(Superheroe jugador, Superheroe enemigo, int i) {
		System.out.println("Combate " + i);
		Scanner s = new Scanner(System.in);
		System.out.println(jugador.getNombre() + " vs " + enemigo.getNombre());
		boolean huida = false, flag;
		AccionesSuperheroe accion = new AccionesSuperheroe();
		
		while (enemigo.getVida() > 0 && jugador.getVida() > 0) {
			System.out.println("Turno del jugador: ");
			System.out.println("1-Atacar\n2-Defender\n3-Ataque Especial\n4-Huida");
			
			int opcion = 0;
			do {
				try {
					flag = false;
					opcion = s.nextInt();
					switch (opcion) {
					//El jugador ataca al enemigo, pierde 3 de resistencia
					case 1: 
						accion.ataque(jugador, enemigo);
						break;
					//El jugador se defiende y obtiene resistencia dependiendo de su agilidad
					case 2: 
						accion.defensa(jugador);
						break;
					//El jugador hace un ataque especial que le quita 7 de resistencia
					case 3:
						accion.ataqueEspecial(jugador, enemigo);
						break;
					case 4:
						accion.huida(jugador);
						huida = true;
						break;
					default:
						System.out.println("Escoje una accion");
						break;
					}
					System.out.println();
				}
				catch (InputMismatchException e) {
					System.out.println("Debe ingresar obligatoriamente un número entero.");
					s.next();
					flag = true;
				}
			} while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 || flag == true);
			
			if (huida == true) {
				break;
			}
			
			System.out.println("\nTurno del enemigo. Vida: " + enemigo.getVida()); 
			enemigo.accionARealizar(enemigo, jugador, accion);
			
			System.out.println("Atributos actuales:\nVida: " + jugador.getVida() + "\nDaño: " + jugador.getDanio() + "\nAgilidad: " + jugador.getAgilidad() + "\nResistencia: " + jugador.getResistencia());

			System.out.println();
			if (enemigo.getVida() <= 0) {
				System.out.println("Has ganado el combate!");
				System.out.println("Se ha generado un fichero con los resultados del combate");
				String frase1 = (jugador.getNombre() + " ha vencido a " + enemigo.getNombre());
				escrituraDatos(jugador, enemigo, frase1, i);
				break;
			}
			else if (jugador.getVida() <= 0) {
				System.out.println("Has perdido el combate");
				System.out.println("Se ha generado un fichero con los resultados del combate");
				String frase2 = (enemigo.getNombre() + " ha vencido a " + jugador.getNombre());
				escrituraDatos(jugador, enemigo, frase2, i);
				break;
			}
		}
		if (huida == false) {
			jugador.setVida(jugador.getVida() + 20);
			jugador.setResistencia(jugador.getResistencia() + 10);
		}
	}
	
	//Escribe en un nuevo fichero los resultados finales del útimo combate
	private static void escrituraDatos(Superheroe jugador, Superheroe enemigo, String combate, int i) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("DatosCombate" + i + ".txt");
			pw = new PrintWriter(fichero);
			pw.println(combate);
			pw.println("Atributos finales del jugador: ");
			pw.println(jugador.toString());
			pw.println("\nAtributos finales del enemigo");
			pw.println(enemigo.toString());
			
		} catch (Exception e) {
			System.out.println("No se ha podido crear el fichero");
		}
		finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            }catch (Exception e2) {
            	e2.printStackTrace();
            }
        }
	}
}
