package semesterProject;

public class Cockpit {
	Airplane plane;
	Engine engine;
	Navigation nav;
	fuelTank tank;
	
	Cockpit(Engine engine,Navigation nav ,fuelTank tank){
		
		this.engine = engine;
		this.nav = nav ;
		this.tank = tank;

	}
	
	//Engine Saga Start
	
	 void runEngine() {
		if (!engine.isRunning()) {
         engine.startEngine();
		}
	}
	

	void offEngine() {
		
		if (engine.isRunning()) {
         engine.offEngine();
         nav.stopNav();
         //off the thread
         }
	}


//Engine Saga End
	
	void takeOff() {
		if (!engine.isRunning()) {
			
            runEngine();
            System.out.println("Tighten Your Seatbelts We are taking off.......");
  
            nav.startNav();
            tank.startMeter();
            
		}
	}
void land() {
		
		if (engine.isRunning()) {
            offEngine();
            nav.stopNav();
            tank.stopMeter();
            
            System.out.println("Landing...");
            try {
                Thread.sleep(3000); 
                
            } catch (InterruptedException e) 
            {
                System.out.println("Landing process was interrupted.");
            }
            System.out.println("Reached "+nav.destination);

            }
	}

   void displayMeter() {
	   tank.displayFuel();
   }

	
	

}
//Start Thread Saga Flight Saga

