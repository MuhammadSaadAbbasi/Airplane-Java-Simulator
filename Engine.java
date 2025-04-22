package semesterProject;

public class Engine {
    private boolean status;
	Engine(){
		this.status =false;
	}
	void startEngine() {
		status = true;
	}
	void offEngine() {
		status = false;
	}
	boolean isRunning() {
		return status;
	}

}
