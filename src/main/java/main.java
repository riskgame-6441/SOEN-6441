import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static int total_players;
	static File file;
    
	public static void main(String[] args) throws Exception{
        
		RGParmy o_army = new RGParmy();
        RGPlisting o_uem = new RGPlisting();
        RGPfortification o_fortification = new RGPfortification();
	
        System.out.println("******WELCOME TO RISK******");
		menu();
        
		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry();
		HashMap<String, String> country_continent = o_uem.getCountryContinent();
		ArrayList<String> continent_list = o_uem.continentlist();
		ArrayList<String> country_list = o_uem.countrylist();
		
        RGPreinforcement o_reinforcement = new RGPreinforcement();
        int total_country = o_uem.countrylist().size();
        ArrayList<String> country_name = o_uem.countrylist();
		System.out.println(country_name);
		System.out.println(total_players);
		
        int armies_per_player = o_army.totalArmy(total_players,total_country);
        System.out.println("Total No. of countries : "+total_country);
		System.out.println("Per Player armies : "+armies_per_player);
		
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_per_player = o_army.divideCountry(total_players,country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);
		
		HashMap<String,Integer> army_per_country = new HashMap<String,Integer>();
		army_per_country = o_army.armyPerCountry(total_players,armies_per_player,country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);
	        
        RGPprintTable o_printtable = new RGPprintTable();

        for(int i=0;i<total_players;i++) {
        	//print table
        	System.out.println("Player : "+(i+1));
        	System.out.println("=========================================");
        	o_printtable.getTable(i,country_per_player,army_per_country);
        	
        	//reinforce armies
        	System.out.println("Reinforcement Phase");
    		System.out.println("=====================================");
        	int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent);
        	System.out.println("Number of armies to Reinforcement : "+z);
        	
        	army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
        	//print table
        	o_printtable.getTable(i,country_per_player,army_per_country);
        	
        	//reinforcement ends
        	Scanner ab = new Scanner(System.in);
        	System.out.println("Do you want to attack ?(y/n)");
        	String ans = ab.next();
        	if(ans == "y") {
        		//attack phase
        	}else {
        		//fortification phase
        		System.out.println("Fortification Phase");
        		System.out.println("=====================================");
        		o_fortification.fortify(country_per_player.get(i),army_per_country);
        		o_printtable.getTable(i,country_per_player,army_per_country);
        	}
        	//break;
        }
        
        
    }
    
	public static void menu() throws Exception{
        int i = 0;
        Scanner a = new Scanner(System.in);
        
        while(i == 0) {
            System.out.println("1- Start");
            System.out.println("2- Help");
            System.out.println("3- Exit");
            System.out.println("Enter your option");
            int option = a.nextInt();
            switch (option) {
                case 1:
                	mapo();
                    i = i + 1;
                    break;
                case 2:
                    System.out.println("Help");
                    i = i + 1;
                    break;
                case 3:
                    System.exit(option);
                    i = i + 1;
                    break;
                default:
                    while (option > 3) {
                        System.out.println("Enter one of the given options ");
                        break;
                    }

            }
        }

    }
    
	public static void mapo() throws Exception{
        int i = 0;
        RGPmapCentral mapob = new RGPmapCentral();
        RGPeditMap o_editOptions = new RGPeditMap();
        RGPnamingPlayers o_namingplayers = new RGPnamingPlayers();
        RGPcreateMap o_RGPCreatin_map = new RGPcreateMap();
        Scanner a = new Scanner(System.in);
        
        while (i == 0) {
            System.out.println("1- Create a new map");
            System.out.println("2- Use an existing map");
            System.out.println("3- Edit an existing map");
            System.out.println("4- Go back");
            
            int option = a.nextInt();
            file = mapob.mapOption(option);
            switch (option) {
                case 1:
                	o_RGPCreatin_map.createmap(file);
                	o_namingplayers.namep(file);
                    i = i + 1;
                    break;
                case 2:
                    o_namingplayers.namep(file);
                    i = i + 1;
                    break;
                case 3:
                    o_editOptions.editMap();
                    o_namingplayers.namep(file);
                    i = i + 1;
                    break;
                case 4:
                	menu();
                	i = i + 1;
                	break;
                default:
                    System.out.println("Enter correct option");
            }
        }
        total_players = o_namingplayers.pinp;
    }
	
}
