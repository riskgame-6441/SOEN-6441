import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static int total_players;
    
	public static void main(String[] args) throws Exception{
        
		army o_army = new army();
        uem o_uem = new uem();
		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry();
		HashMap<String, String> country_continent = o_uem.getCountryContinent();
		ArrayList<String> continent_list = o_uem.continentlist();
		ArrayList<String> country_list = o_uem.countrylist();
		map o_map = new map();
		//o_map.validateMap(country_list, continent_list, country_continent);
		
		menu();
        
        
        Reinforcement o_reinforcement = new Reinforcement();
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
		
		
    	//System.out.println(country_continent);
        
        printtable o_printtable = new printtable();
        //int player_count = object_mainmethod.n;
        //System.out.println(player_count);
        for(int i=0;i<total_players;i++) {
        	//print table
        	o_printtable.getTable(i,country_per_player,army_per_country);
        	
        	//reinforce armies
        	int z = o_reinforcement.calReinforcementArmies(i, country_per_player.get(i), contvalue, contvalue1, country_continent);
        	System.out.println("Number of armies to Reinforcement : "+z);
        	
        	army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
        	//print table
        	o_printtable.getTable(i,country_per_player,army_per_country);
        	
        	//reinforcement ends
        	Scanner a = new Scanner(System.in);
        	System.out.println("Do you want to attack ?(y/n)");
        	String ans = a.next();
        	if(ans == "y") {
        		//attack phase
        	}else {
        		//fortification phase
        	}
        	break;
        }
        
        
        
        
    }
    
	public static void menu(){
        int i = 0;
        Scanner a = new Scanner(System.in);
        System.out.println("******WELCOME TO RISK******");
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
                    System.out.println("Exit");
                    i = i + 1;
                    break;
                default:
                    while (option > 3) {
                        System.out.println("hello");
                        break;
                    }

            }
        }

    }
    
	public static void mapo() {
        int i = 0;
        namingplayers o_namingplayers = new namingplayers();
        Scanner a = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1- Create a new map");
            System.out.println("2- Use an existing map");
            System.out.println("3- Edit an existing map");
            int option = a.nextInt();
            switch (option) {
                case 1:
                    System.out.println("go to new map");
                    i = i + 1;
                    break;
                case 2:
                    o_namingplayers.namep();
                    i = i + 1;
                    break;
                case 3:
                    System.out.println("go to edit map");
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
