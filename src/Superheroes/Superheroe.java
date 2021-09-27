package Superheroes;
import Acciones.AccionesSuperheroe;

public abstract class Superheroe {
	//Atributos
	private String nombre;
	private int vida;								//Cantidad de vida del superheroe
	private int danio;								//Cantidad de vida que quita al enemigo
	private int resistencia;						//Cantidad de ataques que puede realizar
	private int agilidad;							//Capacidad para acertar
	private int armadura;


	//Contructores
	public Superheroe() {
		this.nombre = "Vacio";
		this.vida = 0;
		this.danio = 0;
		this.resistencia = 0;
		this.agilidad = 0;
	}
	
	public Superheroe(String nombre, int vida, int danio, int resistencia, int agilidad) {
		this.nombre = nombre;
		this.vida = vida;
		this.danio = danio;
		this.resistencia = resistencia;
		this.agilidad = agilidad;
	}
	
	public Superheroe(String nombre, int vida, int danio, int resistencia, int agilidad, int armadura) {
		this.nombre = nombre;
		this.vida = vida;
		this.danio = danio;
		this.resistencia = resistencia;
		this.agilidad = agilidad;
		this.armadura = armadura;
	}
	
	//Getters y Setters
	public int getArmadura() {
		return armadura;
	}
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDanio() {
		return danio;
	}
	public void setDanio(int danio) {
		this.danio = danio;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public int getAgilidad() {
		return agilidad;
	}
	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}
	
	//Metodo con el que se realizará una accion dependiendo de la clase hija que se ejecute
	public abstract void accionARealizar(Superheroe enemigo, Superheroe jugador, AccionesSuperheroe accion);
	
	//Metodo toString
	public String toString() {
		return ("Nombre: " + getNombre() + "\nVida: " + getVida() + "\nDaño: " + getDanio() + "\nAgilidad: " + getAgilidad() + "\nResistencia: " + getResistencia());
	}
	
	//Método para calcular si falla o acierta el ataque
    public boolean probAcertar(Superheroe jugador, Superheroe enemigo){
        float probJugador = (float) (Math.random()*jugador.getAgilidad());
        float probEnemigo = (float) (Math.random()*enemigo.getAgilidad());
        
        if (probJugador < probEnemigo){
            return false; //Falla
        }else{
            return true; //Acierta
        }
    }
}
