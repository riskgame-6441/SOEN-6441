import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static int total_players;
	static String[] player_names;
	static File file;
    
	public static void main(String[] args) throws Exception{
        
		RGParmy o_army = new RGParmy();
        RGPlisting o_uem = new RGPlisting();
        RGPfortification o_fortification = new RGPfortification();
        RGPcardDivision o_card = new RGPcardDivision();
	
        System.out.println("--------WELCOME TO RISK--------\n");
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
	    
		HashMap<String,Integer> cards = new HashMap<String,Integer>();
		HashMap<String,Integer> card_1 = new HashMap<String,Integer>();
		HashMap<String,Integer> card_2 = new HashMap<String,Integer>();
		HashMap<String,Integer> card_3 = new HashMap<String,Integer>();
		HashMap<String,Integer> card_4 = new HashMap<String,Integer>();
		HashMap<String,Integer> card_5 = new HashMap<String,Integer>();
		HashMap<String,Integer> card_6 = new HashMap<String,Integer>();
		cards = o_card.hm1(country_name);
		//System.out.println(cards);

		RGPprintTable o_printtable = new RGPprintTable();

        for(int i=0;i<total_players;i++) {
        	
        	//Players world domination view
        	System.out.println("Map(%) : ");
        	System.out.println("Continents : ");
        	System.out.println("Total armies : ");
        	
        	//phase view
        	System.out.println("Reinforcement Phase");
        	System.out.println("Player : "+player_names[i]);
        	System.out.println("This phase will give players reinforcement army for each turn according to countries and continents owned along with by treding cards player can get some extra army. Player can put that armies into the countries owned accordingly.");
        	System.out.println("=========================================");
        	o_printtable.getTable(file,i,country_per_player,army_per_country);
        	
        	//reinforce armies
        	System.out.println("Reinforcement Phase");
    		System.out.println("=====================================");
    		
    		//card exchange view
    		int extra_army=0;
    		if(i==0) {
    			System.out.println(card_1);
    			extra_army = o_card.trade_card(card_1);
    		}else if(i==1) {
    			System.out.println(card_2);
    			extra_army = o_card.trade_card(card_2);
    		}else if(i==2) {
    			System.out.println(card_3);
    			extra_army = o_card.trade_card(card_3);
    		}else if(i==3) {
    			System.out.println(card_4);
    			extra_army = o_card.trade_card(card_4);
    		}else if(i==4) {
    			System.out.println(card_5);
    			extra_army = o_card.trade_card(card_5);
    		}else if(i==5) {
    			System.out.println(card_6);
    			extra_army = o_card.trade_card(card_6);
    		}
    		
    		System.out.println("Extra armies : "+extra_army);
    		
    		//calculate total reinforcement army
        	int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent, contvalue);
        	z+=extra_army;
        	System.out.println("Number of armies to Reinforcement : "+z);
        	
        	army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
        	//print table
        	o_printtable.getTable(file,i,country_per_player,army_per_country);
        	
        	//reinforcement ends
        	Scanner ab = new Scanner(System.in);
        	System.out.println("Do you want to attack ?(y/n)");
        	String ans = ab.next();
        	if(ans.equalsIgnoreCase("y")) {
        		//attack phase
        		//Phase view
        		System.out.println("Attack Phase");
            	System.out.println("Player : "+player_names[i]);
            	System.out.println("Describe.");
            	System.out.println("=========================================");
        		
        		int flag = 0, g = 0;
        		String attack_country = null;
        		String defend_country = null;
        		RGPdiceroll o_dice = new RGPdiceroll();
        		System.out.println("Attack Phase");
        		while(flag==0) {
        			while(flag==0) {
        				System.out.println("Enter country name from which you want to attack");
                	 attack_country = ab.next();
        				if(!country_per_player.get(i).contains(attack_country)) {
        					System.out.println("Please enter country that you own.");
        					break;
        				}else {
        					flag=1;
        				}
        			}
        		}
        		int f = 1;
        		while(g == 0 || f == 1){
        		System.out.println("Enter country name on which you want to attack");
        		defend_country = ab.next();
        		List<String> list = new ArrayList<String>();
        		 g = o_fortification.checkConnection(file, attack_country, defend_country, country_list, list);
        		 if(country_per_player.get(i).contains(defend_country)){
        			  f = 1;
        		 }else{
        			 f = 0;
        		 }
        		 if (g != 1 || f == 1){
        			 System.out.println("Enter correct neighbouring country or other player country to attack");
        		 }
        		}
        		int attacker_armies = army_per_country.get(attack_country);
        		int defender_armies = army_per_country.get(defend_country);
        		HashMap<Integer,Integer> armies = o_dice.rollDice(attacker_armies,defender_armies,file,i,country_per_player,army_per_country);
        		int c = (int)armies.keySet().toArray()[0];
        		int army = armies.get(c);
        		System.out.println(c);
        		if(c == 0){
        			System.out.println("Defender has won"+attack_country+"country");        			
        			System.out.println("Enter no of armies to place in "+ attack_country);
        			int armies1 = ab.nextInt();
        			armies1 += army_per_country.get(attack_country);
        			army_per_country.put(attack_country, armies1);
            		int army1 = army - (armies1-1);
            		army_per_country.put(defend_country, army1);
            		o_printtable.getTable(file,i,country_per_player,army_per_country);
        		}
        	   else{
        		System.out.println("Attacker has won"+defend_country+"country");    
        		System.out.println("Enter no of armies to place in "+ defend_country);
        		int armies1 = ab.nextInt();
        		int j = 0;
        		armies1 += army_per_country.get(defend_country);        		
    			army_per_country.put(defend_country, armies1);
        		int army1 = army - (armies1-1);
        		army_per_country.put(attack_country, army1);
        		country_per_player.get(i).add(defend_country);
        		for(int l=0;l<total_players;l++){
        			if(country_per_player.get(l).contains(defend_country)){
        				j = l;
        			}   		
        		}
        		country_per_player.get(j).remove(defend_country);
        		
        		o_printtable.getTable(file,i,country_per_player,army_per_country);
        	   }
        	}
        		//fortification phase
        		//System.out.println("Fortification Phase");
        		//System.out.println("=====================================");
        		//o_fortification.fortify(file,country_per_player.get(i),army_per_country);
        		//o_printtable.getTable(file,i,country_per_player,army_per_country);
        	Scanner abc = new Scanner(System.in);
        	System.out.println("Do you want to fortify?(y/n) : ");
        	String ans1 = abc.next();
        	if(ans1=="y") {
        		//Phase view
        		System.out.println("Fortification Phase");
            	System.out.println("Player : "+player_names[i]);
            	System.out.println("Describe.");
            	System.out.println("=========================================");
            	
        		o_fortification.fortification(file,i,country_per_player,army_per_country);
        	}
        	//break;
        }
        System.out.println("The End.");
        
    }
    
	public static void menu() throws Exception{
        int i = 0;
        Scanner a = new Scanner(System.in);
        
        while(i == 0) {
        	System.out.println("************");
            System.out.println("* 1- Start *");
            System.out.println("* 2- Help  *");
            System.out.println("* 3- Exit  *");
            System.out.println("************\n");
            System.out.println("Enter your option");
            int option = a.nextInt();
            switch (option) {
                case 1:
                	mapo();
                    i = i + 1;
                    break;
                case 2:
                    System.out.println("Risk Game Help");
                    menu();
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
        player_names = o_namingplayers.names;
    }
	
}
