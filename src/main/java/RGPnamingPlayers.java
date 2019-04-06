import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class is for naming players
 * @author pavan
 * @version 1.0.0
 */
public class RGPnamingPlayers  {
    RGPlisting a1 = new RGPlisting();
    int pinp = 0;
    HashMap<String,Integer> names = new HashMap<String,Integer>();
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
    public HashMap<String,Integer> namep(File file) throws Exception{
    	
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
        System.out.println("Player Type : \nHuman(1)\nAggressive(2)\nBenevolent(3)\nRandom(4)\nCheater(5)");
        pinp = getPlayers();
        String pname;
        int ptype;
        int i;
        for (i = 0; i < pinp; i++) {
            System.out.print("Enter the name of the player " + (i+1) + " and type of player :");
            pname = ab.next();
            ptype = Integer.parseInt(ab.next());
            //System.out.println(pname);
            //System.out.println(ptype);
            names.put(pname, ptype);            
            //System.out.println("Player name : " + pname);
        }
        return names;
    }
}