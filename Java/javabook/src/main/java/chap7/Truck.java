package chap7;

public class Truck extends Vehicle{
    private int cargocap;
	
	public Truck(int p, int f, int m ,int c) {
		super(p, f, m);
		// TODO Auto-generated constructor stub  
		cargocap = c;
	} 
	
	// Accessor methods for cargocap 
	int getCargo() { return cargocap ; } 
	void putCargo(int c) { cargocap = c ; } 
	
	

}
