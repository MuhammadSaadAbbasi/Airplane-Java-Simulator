package semesterProject;

public class Airplane extends Vehicle{
	
    
	 Engine engine;
	 Cockpit cockpit;
	 Navigation nav;
	 fuelTank tank;
	
	
	Airplane(String name , int capacity,Engine engine , Navigation nav) {
		super(name,capacity);
		
	    this.engine=engine;
	    this.nav =nav;
	    tank = new fuelTank();
		tank.plane = this;
		//Composition Aggregation(Engine)
		cockpit = new Cockpit(this.engine,this.nav,tank);
		cockpit.plane = this;
		
				//Aggregation
		nav.plane = this ;
	}

		

	boolean checkStatus() {
		return engine.isRunning();
	}

	public String toString() {
		
		return "Name of Plane : " + getName() + "\nCapacity : "+getCapacity() ; 
	}



	public void setNavigation(Navigation nav) {
	
		this.nav = nav;
	    this.nav.plane = this;
		
	}
}
