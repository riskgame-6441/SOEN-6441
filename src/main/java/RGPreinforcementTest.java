import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

/**
 * 
 * @author Koti
 * @version 1.0
 * @since 04-03-2019
 *
 */
public class RGPreinforcementTest {
	
	RGPreinforcement ra = new RGPreinforcement();
	/**
	 * This method is used to test if the reinforced armies are calculated as per the risk rules when he won's one continent
	 */
	@Test
	public void calReinforcementArmiestest() {
	
	
	HashMap<String, Integer> contientValues = new HashMap<String, Integer>();
	contientValues.put("Asia",7);
	contientValues.put("Africa",3);
	contientValues.put("NA",5);
	contientValues.put("SA",6);
	
	
	List<String> countries = new ArrayList<String>();
	countries.add("India");
	countries.add("Pak");
	countries.add("Srilanka");
	countries.add("Bang");
	
	
	HashMap<String, Integer> continentCountryCount = new HashMap<String, Integer>();
	continentCountryCount.put("Asia",4);
	continentCountryCount.put("Africa",5);
	continentCountryCount.put("NA",4);
	continentCountryCount.put("SA",4);
	
	HashMap<String,String> country_continent = new HashMap<String,String>();
	country_continent.put("India","Asia");
	country_continent.put("Pak","Asia");
	country_continent.put("Srilanka","Asia");
	country_continent.put("Bang","Asia");

	

	HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
	army_per_country.put("India",15);
	army_per_country.put("Pak",1);
	army_per_country.put("Srilanka",10);
	army_per_country.put("Bang",9);
	
	


			int i=ra.calReinforcementArmies (countries,continentCountryCount,country_continent,contientValues);
			assertEquals(10,i);


	}
	/**
	 * This method is used to test if the reinforcement armies are calculated as per the risk rules when he doesnt won the continent. 
	 */
	@Test
	public void calReinforcementArmiestest1() {
	
	
	HashMap<String, Integer> contientValues = new HashMap<String, Integer>();
	contientValues.put("Asia",7);
	contientValues.put("Africa",3);
	contientValues.put("NA",5);
	contientValues.put("SA",6);
	
	
	List<String> countries = new ArrayList<String>();
	countries.add("India");
	countries.add("Pak");
	countries.add("Srilanka");
	
	
	
	HashMap<String, Integer> continentCountryCount = new HashMap<String, Integer>();
	continentCountryCount.put("Asia",4);
	continentCountryCount.put("Africa",5);
	continentCountryCount.put("NA",4);
	continentCountryCount.put("SA",4);
	
	HashMap<String,String> country_continent = new HashMap<String,String>();
	country_continent.put("India","Asia");
	country_continent.put("Pak","Asia");
	country_continent.put("Srilanka","Asia");
	country_continent.put("Bang","Asia");

	

	HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
	army_per_country.put("India",15);
	army_per_country.put("Pak",1);
	army_per_country.put("Srilanka",10);
	army_per_country.put("Bang",9);

	
			int i=ra.calReinforcementArmies (countries,continentCountryCount,country_continent,contientValues);
			assertEquals(3,i);
	}
	
	@Test
	public void endOfGameTest() {
		ArrayList<String> country_list = new ArrayList<String>();
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_list.add("Alaska");
		country_list.add("Alberta");
		country_list.add("Siam");
		country_list.add("India");
		country_per_player.add(country_list);
		int i=0;
		int x = ra.endOfGame(country_list,country_per_player,i);
		assertEquals(1,x);
	}
}









