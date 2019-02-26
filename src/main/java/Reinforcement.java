import java.util.List;
import java.util.Map;


public class Reinforcement {

	int tradeCount;
	int numOfPlayers;
	Map<String, Integer> contientValues;
	String countryName; // Country where you place your army
	String[] p; // Player names
	int totalCountry; // total num of countries in the map
	String playerNo;

	public Reinforcement(int totalCountry, Map<String, Integer> contientValues) {
		this.totalCountry = totalCountry;
		this.contientValues = contientValues;
		tradeCount = 0;
	}
	

	// how many reinforcement to give based on countries he has, how many continents
	public Integer calReinforcementArmies(int playerNum, List<List<String>> countries, List<String> continents) {
		int reinforced_armies = Math.max(countries.get(playerNum).size() / 3, 3);
		for (String continet : continents) {
			reinforced_armies += contientValues.get(continet);
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
