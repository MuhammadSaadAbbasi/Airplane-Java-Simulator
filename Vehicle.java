package semesterProject;

public class Vehicle {
    private int capacity;
    private String name;
   
    public Vehicle(String name,int capacity) {
        this.capacity = capacity;
        this.setName(name);
    }

    public void start() {
        System.out.println("Vehicle is now running.");
        
    }

    public void stop() {
        System.out.println("Vehicle has stopped.");
        
    }

    public int getCapacity() {
        return capacity;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
