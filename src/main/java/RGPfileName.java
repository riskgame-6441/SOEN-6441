import java.util.Scanner;

public class RGPfileName {

	public static void mapo (){
		  int i = 0;
	        namingplayers o_namingplayers = new namingplayers();
	        RGPCreatin_map o_RGPCreatin_map = new RGPCreatin_map();
	        Scanner a = new Scanner(System.in);
	        while (i == 0) {
	            System.out.println("1- Create a new map");
	            System.out.println("2- Use an existing map");
	            System.out.println("3- Edit an existing map");
	            int option = a.nextInt();
	            switch (option) {
	                case 1:
	                	o_RGPCreatin_map.createmap();
	                	String filename = "/Users/Guest1/SOEN-6441/create.map";
	                    i = i + 1;
	                    break;
	                case 2:
	                     filename = "/Users/Guest1/SOEN-6441/world.map";
	                    o_namingplayers.namep();
	                    
	                    i = i + 1;
	                    break;
	                case 3:
	                    System.out.println("go to edit map");
	                     filename = "";
	                    i = i + 1;
	                    break;
	                default:
	                    System.out.println("Enter correct option");
	            }
	        }
	        total_players = o_namingplayers.pinp;
	        /*for(i=0;i<total_players;i++) {
	        	System.out.println(o_namingplayers.names[i]);
	        }*/
	    }

	

}
