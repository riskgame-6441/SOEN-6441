import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Reinforcement {

	int tradeCount;
	int numOfPlayers;
	Map<String, Integer> contientValues;
	String countryName; // Country where you place your army
	String[] p; // Player names
	int totalCountry; // total num of countries in the map
	String[] continentwon;//String of continents own for any player;

	public Reinforcement(int totalCountry, Map<String, Integer> contientValues) {
		this.totalCountry = totalCountry;
		this.contientValues = contientValues;
		tradeCount = 0;
	}
	
	public Reinforcement() {
		
	}
	

	// how many reinforcement to give based on countries he has, how many continents
	public Integer calReinforcementArmies(int playerNum, List<String> countries, Map<String,Integer> contientValues, Map<String, Integer> continentCountryCount, Map<String, String> country_continent) {
		//System.out.println(contientValues);
		//System.out.println(continentCountryCount);
		//System.out.println(country_continent);
		int reinforced_armies = Math.max(countries.size() / 3, 3);
		//System.out.println(reinforced_armies);
		int n = countries.size();
		for(int i=0;i<n;i++) {
			//System.out.println(countries.get(i));
			String continent = country_continent.get(countries.get(i));
			//System.out.println(continent);
			int continent_have_countries = continentCountryCount.get(continent);
			int flag = continent_have_countries;
			for(int j=0;j<n;j++) {
				if(continent == country_continent.get(countries.get(j))) {
					flag--;
				}
				if(flag == 0)
					break;
			}
			if(flag == 0) {
				reinforced_armies += contientValues.get(continent);
				//System.out.println(reinforced_armies);
			}
		}
		return reinforced_armies;
	}
	

	// placing reinforcement armies in countries
	// country, numOfArmies
	public HashMap<String, Integer> placeReinforceArmies(int z, int i, List<List<String>> country_per_player, HashMap<String, Integer> army_per_country) {
		int flag=0;
		String a_country= " ";
		int a_army;
    	while(z!=0) {
    		Scanner a = new Scanner(System.in);
    		while(flag==0) {
    			System.out.println("Enter country name to place army : ");
        		a_country = a.next();
        		if(a_country.getClass().getName() != "java.lang.String" ){
        			System.out.println("Please enter valid country which will be string value.");
        			break;
        		}
        		if(!country_per_player.get(i).contains(a_country)) {
        			System.out.println("You entered country which is not owned by you.");
        			break;
        		}else {
        			flag=1;
        		}
    		}
    		while(flag==1) {
    			System.out.println("Enter number of armies to place : ");
        		if(!a.hasNextInt()) {
        			System.out.println("Please enter valid number of army which will be integer value.");
        			break;
        		}else {
        			a_army = a.nextInt();
        		}
        		if(a_army>z) {
        			System.out.println("You can only place until "+z+" armies.");
        			break;
        		}else {
        			z=z-a_army;
        			a_army += army_per_country.get(a_country);
        			army_per_country.put(a_country, a_army);
        			flag=0;
        		}
    		}
    	}
    	return army_per_country; 
	}

}
