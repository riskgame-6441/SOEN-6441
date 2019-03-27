import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This class is for naming players
 * @author pavan
 * @version 1.0.0
 */
public class RGPnamingPlayers  {
    RGPlisting a1 = new RGPlisting();
    int pinp = 0;
    String[] names = new String[5];
    /**
     * This method returns the total no of players
     * @return no of players
     */
    public int getPlayers() {
    	Scanner a = new Scanner(System.in);
    	System.out.println("enter no of players");
    	final int total_players = a.nextInt();
    	return total_players;
    }
    /**
     * This method check whether countries are connected or not
     * @param file contains the file path
     * @return total players
     * @throws Exception
     */
    public String[] namep(File file) throws Exception{
    	
    	RGPmap o_map = new RGPmap();
    	int a = o_map.validateConnectedContinents(file);
    	int b = o_map.validateConnectedCountries(file);
    	//System.out.println(a);
    	//System.out.println(b);
    	//System.exit(0);
    	if(a==0) {
    		System.out.println("Invalid map.(Countries are not connected.)");
    		System.exit(0);
    	}else if(b==0) {
    		System.out.println("Invalid map.(Continents are not connected.)");
    		System.exit(0);
    	}
    	
        Scanner ab = new Scanner(System.in);

        pinp = getPlayers();
        String pname;
        int i;
        for (i = 0; i < pinp; i++) {
            System.out.print("Enter the name of the player " + (i+1) + ":");
            pname = ab.next();
            names[i] = pname;
            if (i == 0){
                System.out.println("Player name : " + pname);
            }
            else if (i == 1){
                System.out.println("Player name : " + pname);
            }
            else if (i == 2){
                System.out.println("Player name : " + pname);
            }
            else if (i == 3){
                System.out.println("Player name : " + pname);
            }
            else
            {
                System.out.println("Player name : " + pname);
            }
        }
        return names;
    }
}
