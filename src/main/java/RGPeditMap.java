
import java.util.List;
import java.util.Scanner;

public class RGPeditMap {
    public void editMap() throws Exception{
        RGPeditMapCalculations a = new RGPeditMapCalculations();
        System.out.println("Edit Menu");
        System.out.println("1- Add continent.");
        System.out.println("2- Delete continent");
        System.out.println("3- Add country");
        System.out.println("4- Delete country");
        Scanner sc = new Scanner(System.in);
        System.out.println("Plaese enter your option");
        int option = sc.nextInt();
        switch(option){
            case 1:
                a.addContinent();
                break;
            case 2:
                a.deleteContinent();
                break;
            case 3:
                a.addCountry();
                break;
            case 4:
                a.deleteCountry();
                break;
            default:
            	System.out.println("Enter correct option");
        }
    }
}


