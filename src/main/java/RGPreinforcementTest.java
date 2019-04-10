import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@Test
	public void  placeReinforceArmiesCheaterTest(){
		
		int i = 1;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("Bang");
		country_per_player2.add("Pak");
		country_per_player2.add("Srilanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country.put("India",15);
		army_per_country.put("Pak",1);
		army_per_country.put("Srilanka",10);
		army_per_country.put("Bang",9);
		
		HashMap<String, Integer> armyCheater = ra.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
		assertEquals(15,armyCheater.get("India"));
		
	}
	
	@Test
	public void  placeReinforceArmiesCheaterTest2(){
		
		int i = 1;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("Bang");
		country_per_player2.add("Pak");
		country_per_player2.add("Srilanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country.put("India",15);
		army_per_country.put("Pak",1);
		army_per_country.put("Srilanka",10);
		army_per_country.put("Bang",9);
		
		HashMap<String, Integer> armyCheater = ra.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
		assertEquals(15,armyCheater.get("India"));
		
	}
	
	@Test
	public void  placeReinforceArmiesCheaterTest3(){
		
		int i = 1;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("Bang");
		country_per_player2.add("Pak");
		country_per_player2.add("Srilanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country.put("India",15);
		army_per_country.put("Pak",1);
		army_per_country.put("Srilanka",10);
		army_per_country.put("Bang",9);
		
		HashMap<String, Integer> armyCheater = ra.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
		assertEquals(15,armyCheater.get("India"));
		
	}
	
	@Test
	public void  placeReinforceArmiesCheaterTest4(){
		
		int i = 1;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("Bang");
		country_per_player2.add("Pak");
		country_per_player2.add("Srilanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country.put("India",15);
		army_per_country.put("Pak",1);
		army_per_country.put("Srilanka",10);
		army_per_country.put("Bang",9);
		
		HashMap<String, Integer> armyCheater = ra.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
		assertEquals(15,armyCheater.get("India"));
		
	}
	
}









