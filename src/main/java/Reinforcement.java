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
	

	// how many reinforcement to give based on countries he has, how many continents
	public Integer calReinforcementArmies(int playerNum, List<List<String>> countries, Map<String,Integer> contientValues) {
		int reinforced_armies = Math.max(countries.get(playerNum).size() / 3, 3);
		
		for(int i=0;i<contientValues.size();i++) {
		String continent = (String)contientValues.keySet();
		}
		for (String continent : contientValues) {
			reinforced_armies += contientValues.get(continetValues);
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
