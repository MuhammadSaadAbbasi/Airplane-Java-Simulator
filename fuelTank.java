package semesterProject;

public class fuelTank extends Thread{
	double fuel;
	Airplane plane;
	double capacity;
	private boolean running;
	
	fuelTank(){
		this.fuel = 500;
		this.capacity = 1000;
	
				}
	void updateFuel(){
		this.fuel--;
	}
	
	
	public void setPlane(Airplane plane) {
	    this.plane = plane;
	}
	
	void refill(double fuel) {
		
		if(!plane.checkStatus()) {
		if((this.fuel+fuel)<capacity) {
			
			if(fuel>0) {
		   this.fuel += fuel;
			}
			else {
				System.out.println("Fuel Shoul be more than 0");
			}
		}
		else
			System.out.println("Fuel can not be more than Capacity of tank");
	}
	
	
	else
	
		System.out.println("No refill in Mid Air");
	}
	void displayFuel() {
		System.out.println("Fuel is " + fuel);

	}
	void startMeter() {
		running=true;
	}
	void stopMeter() {
		running=false;
	}
	public void run() {
		try {
			
			while(true) {
				if(plane.checkStatus() && running) {
				displayFuel();
				updateFuel();
				Thread.sleep(4000);
			}
			
			else if(!running && !plane.checkStatus()) {
				displayFuel();
				Thread.sleep(5000);
			}
			}
		}
			catch (InterruptedException e) {
	            System.out.println(" Display Fuel stopped.");
	}
 }
}