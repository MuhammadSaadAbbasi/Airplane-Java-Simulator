package semesterProject;
import java.util.Scanner;

public class Main {
	
    static void menu() {
        System.out.println("\n\tSelect from Option below:");
        System.out.println("1\tTake Off");
        System.out.println("2\tLand");
        System.out.println("3\tCheck Fuel");
        System.out.println("4\tDetails");
        System.out.println("5\tExit");
        System.out.print("Enter Choice: ");
    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Passenger Capacity: ");
        int passenger = sc.nextInt();
        sc.nextLine(); 

        Engine engine = new Engine();
        Navigation nav = new Navigation();
       

        Airplane myplane = new Airplane(name, passenger, engine, nav);
        
        fuelTank tank = myplane.tank;
       
        
        Cockpit cockpit = myplane.cockpit;
        

        myplane.setNavigation(nav);

        int choice;
        do {
            menu();
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Please enter a valid number.");
               
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!myplane.checkStatus()) {
                    	nav.input();
                        myplane.cockpit.takeOff();
                        try {
                            if (!nav.isAlive()) nav.start();
                            if (!tank.isAlive()) tank.start();
                        } catch (IllegalThreadStateException e) {
                            System.err.println("Thread Dead : 9/11 Successfull");
                        }
                        
                    } else {
                        System.out.println("Plane is already in the air!");
                    }
                    break;

                case 2:
                    if (myplane.checkStatus()) {
                    	myplane.cockpit.land();
                    	nav.stopNav();
                    } else {
                        System.out.println("Plane is already on the ground.");
                    }
                    break;

                case 3:
                    if (!myplane.checkStatus()) {
                        tank.displayFuel();
                        System.out.print("Refill? (y/n): ");
                        String c = sc.nextLine().trim().toLowerCase();
                        if (c.equals("y")) {
                            System.out.print("Amount: ");
                            while (!sc.hasNextDouble()) {
                                sc.nextLine();
                                System.out.print("Enter a number: ");
                            }
                            double amt = sc.nextDouble();
                            sc.nextLine();
                            tank.refill(amt);
                            tank.displayFuel();
                        }
                    } else {
                        System.out.println("Refill While Flying ??");
                    }
                    break;

                case 4:
                    System.out.println(myplane);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    nav.interrupt();
                    tank.interrupt();
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}
