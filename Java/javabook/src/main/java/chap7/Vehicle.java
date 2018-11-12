

package chap7;

public class Vehicle { 
	private int passengers;
	private int fuelcap;
	private int mpg; 
	
	public Vehicle(int p, int f, int m) {
		this.passengers = p;
		this.fuelcap =f ; 
		this.mpg = m;
	} 
	
	int range() {
		return mpg*fuelcap; 
			}
	
	double fuelneeded(int miles) {
		return (double) miles/mpg;
	} 
	
	// Accessor methods for instance variables
	
	int getPassengers() { return passengers ; } 
	void setPassengers(int p) { passengers = p;}
	int getFuelcap() { return fuelcap ;}
	void setFuelcap(int f) {fuelcap = f;} 
	int getMpg() {return mpg;}
	void setMpg(int m) {mpg = m;}

}
