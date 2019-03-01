import java.util.List;
import java.util.Map;


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
	public Map<String, Integer> placeReinforceArmies(Map<String, Integer> countryArmies, String country,
			int numOfArmies) {
		if (countryArmies.containsKey(country)) {
			int currentArmies = countryArmies.get(country);
			countryArmies.put(country, currentArmies + numOfArmies);
		} else {
			countryArmies.put(country, numOfArmies);
		}
		return countryArmies;
	}

}
