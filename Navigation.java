package semesterProject;
import java.util.Scanner;

public class Navigation extends Thread{
	Scanner sc = new Scanner(System.in);
	Airplane plane;
  
    private double latitude;
    private double longitude;
    private boolean running;
    String current ;
    String destination;
    
    public Navigation() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }
    
    void setDestination(String current ,String destination) {
    	this.current = current;
        this.destination =destination;
    }
    void input() {
    	System.out.print("Enter Current Place: ");
        String current = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();
        
        setDestination(current ,destination);
    }

    
    public void setLocation(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
        System.out.println("Current location: Latitude " + lat + ", Longitude " + lon);
    }
    
    
    void startNav() {

    		running = true;
    	}
    void stopNav() {
 
    		running = false;
    
	
    }

   
    public void run() {
        try {
            
        	while(true) {
            	 if(plane.checkStatus() && running) {
                latitude += Math.random() * 0.01;
                longitude += Math.random() * 0.01;
                System.out.println(" Navigating... Current position -> Lat: " + latitude + ", Lon: " + longitude);
                System.out.println(" We are flying "+current+" to "+ destination);
                
                Thread.sleep(4000); 
            	 }
            	 else if(!running && !plane.checkStatus()) {
            		 Thread.sleep(10000);    	 
            	 }
            }
        } catch (InterruptedException e) {
            System.out.println(" Navigation system stopped.");
        }
    }
}
