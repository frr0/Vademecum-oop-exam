package ufficiotecnico;

public class Incrocio {

	private ElementoTopografico a;
	private ElementoTopografico b;
	private boolean semafori = false;
	
	public Incrocio(ElementoTopografico a, ElementoTopografico b, boolean semafori){
		this.a=a;
		this.b=b;
		this.semafori=semafori;
		
	}

	public ElementoTopografico getA() {
		return a;
	}

	public ElementoTopografico getB() {
		return b;
	}

	public boolean getSemafori() {
		return semafori;
	}
	
}
