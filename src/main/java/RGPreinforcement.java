import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is performing reinforcement phase which calculates the number of reinforcement armies and also helps placing the armies in the players respective countries
 * @author koti
 * @version 1.0.0
 */
public class RGPreinforcement {

	int tradeCount;
	int numOfPlayers;
	Map<String, Integer> contientValues;
	String countryName;
	String[] p;
	int totalCountry;
	String[] continentwon;
    /**
     * This method is a constructor
     * @param totalCountry get total no of countries
     * @param contientValues get continent values
     */
	public RGPreinforcement(int totalCountry, Map<String, Integer> contientValues) {
		this.totalCountry = totalCountry;
		this.contientValues = contientValues;
		tradeCount = 0;
	}
	
	public RGPreinforcement() {
		
	}
	
	/**
	 * This method will calculate reinforcement armies.
	 * 
	 * @param countries This parameter contains list of countries for current player.
	 * 
	 * @param continent_country_count This parameter contains continents and total number of countries in each continent.
	 * 
	 * @param country_continent This parameter contains countries mapped to it's continent.
	 * 
	 * @return This method will return calculated reinforced armies.
	 * */
	public Integer calReinforcementArmies(List<String> countries, Map<String, Integer> continent_country_count, Map<String, String> country_continent, Map<String, Integer> continent_value) {
		int reinforced_armies = Math.max(countries.size() / 3, 3);
		int n = countries.size();
		List<String> new_continent = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			String continent = country_continent.get(countries.get(i));
			if(new_continent.contains(continent)) {
				break;
			}
			new_continent.add(continent);
			int continent_have_countries = continent_country_count.get(continent);
			int flag = continent_have_countries;
			for(int j=0;j<n;j++) {
				if(continent == country_continent.get(countries.get(j))) {
					flag--;
				}
				if(flag == 0)
					break;
			}
			if(flag == 0) {
				reinforced_armies += continent_value.get(continent);
			}
		}
		return reinforced_armies;
	}
	/**
	 * This method is to check the end of game play
	 * @param country_list is total country list
	 * @param country_per_player is country per player
	 * @param i is player index
	 * @return returns player has won the game or not
	 */
	public int endOfGame(ArrayList<String> country_list,List<List<String>> country_per_player,int i){
		int value = 0;
		if(country_per_player.get(i).equals(country_list)){
			value = 1;
		}
		else{
			value = 0;
		}
		return value;
	}
	
	/**
	 * This method will perform placing of reinforced armies to countries.
	 * 
	 * @param z This parameter contains calculated reinforced armies.
	 * 
	 * @param i This parameter contains index of current player.
	 * 
	 * @param country_per_player This parameter contains list of countries for each player.
	 * 
	 * @param army_per_country This parameter contains hash map of countries and armies.
	 * 
	 * @return This method will return updated hash map of countries and armies.
	 */
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

	/**
	 * This function used to access continents owned by players.
	 * 
	 *  @author Dhruvi Gadhiya
	 * 
	 *  @param country_per_player This parameter contains List of List that contains country list for each player
	 *  
	 *  @param country_continent This parameter contains HashMap of country and it's continent
	 *  
	 *  @param contvalue This parameter contains HashMap of continent and number of countries in that continent.
	 *  
	 *  @return This method will return list of continents owned by each player.
	 */
	public static List<List<String>> getContinent(List<List<String>> country_per_player, HashMap<String, String> country_continent, HashMap<String, Integer> contvalue){
		List<List<String>> continents = new ArrayList<List<String>>();
		for(int i=0;i<country_per_player.size();i++) {
			HashMap<String,Integer> e = new HashMap<String,Integer>();
			//add continents and its count in hashmap to check how many countries of same continent
			for(int j=0;j<country_per_player.get(i).size();j++) {
				String continent = country_continent.get(country_per_player.get(i).get(j));
				if(e.containsKey(continent)) {
					int v = e.get(continent);
					e.put(continent, v+1);
				}else {
					e.put(continent, 1);
				}
			}
			//get continents own by player by compairing two hashmap
			List<String> keys = new ArrayList(e.keySet());
			//System.out.println(keys);
			//System.out.println(contvalue);
			//System.out.println(e);
			int v = 0;
			int v1 = 0;
			for(int k=0;k<keys.size();k++) {
				//System.out.println(keys.get(k));
				v = e.get(keys.get(k));
				v1 = contvalue.get(keys.get(k));
				//System.out.println(v);
				//System.out.println(v1);
				if(v != v1) {
					e.remove(keys.get(k));
					keys.remove(k);
					k--;
				}
			}
			List<String> final_continent = new ArrayList(e.keySet());
			continents.add(final_continent);
		}
		return continents;
	}
}
