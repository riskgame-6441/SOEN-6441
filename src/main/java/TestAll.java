import static org.junit.Assert.*;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;



public class TestAll {

	//for army test
	@Test
	/**
	 * This method is test case1 for total armies
	 */
	public void test() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(2, 35);
		assertEquals(33,b);
	}
	@Test
	/**
	 * This method is test case2 for total armies
	 */
	public void test1() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(3, 35);
		assertEquals(29, b);
	}
	@Test
	/**
	 * This method is test case3 for total armies
	 */
	public void test2() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(4, 35);
		assertEquals(25, b);
	}

	//for attack test
	RGPdiceroll o_dice = new RGPdiceroll();

	@Test
	public void test3() {
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		String Country = "SriLanka";

		int i = o_dice.validattcacker(Country, country_per_player, 1);
		assertEquals(1, i);

	}
	@Test
	public void test4() {
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		String Country = "SriLanka";

		int i = o_dice.validattcacker(Country, country_per_player, 1);
		assertNotEquals(0, i);

	}
	@Test
	public void test5() {

		int[] dicevalues = { 1, 5, 6 };

		int m = o_dice.minOfArray(dicevalues);
		assertEquals(1, m);
	}
	@Test
	public void test6() {

		int[] dicevalues = { 1, 5, 6 };

		int m = o_dice.minOfArray(dicevalues);
		assertNotEquals(6, m);
	}
	@Test
	public void test7() {
		
		int[] dicevalues = {1,5,6};
		
	int m= o_dice.maxOfArray(dicevalues);
	assertEquals(6, m);
	}
	@Test
	public void test8() {
		
		int[] dicevalues = {1,5,6};
		
	int m= o_dice.maxOfArray(dicevalues);
	assertNotEquals(1, m);
	}
	
	@Test
	public void test9() throws Exception {
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		File file = new File("D:/Projects/Risk/SOEN-6441/src/main/java/world.map");
		String attack_country = "India";
		String defend_country = "Bangladesh";
		
		ArrayList<String> country_list = new ArrayList<String>();
		country_list.add("India");
		country_list.add("China");
		country_list.add("Australia");
		country_list.add("Pakistan");
		country_list.add("Bangladesh");
		country_list.add("SriLanka");
		
		int i =1;
		int f =1;
		
		int m = o_dice.validdefender(file, country_per_player,attack_country, defend_country, country_list, i,f);
		assertEquals(0, m);
	}
	
	@Test
	public void test10() throws Exception {
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);
		File file = new File("D:/Projects/Risk/SOEN-6441/src/main/java/world.map");
		String attack_country = "India";
		String defend_country = "Bangladesh";
		
		ArrayList<String> country_list = new ArrayList<String>();
		country_list.add("India");
		country_list.add("China");
		country_list.add("Australia");
		country_list.add("Pakistan");
		country_list.add("Bangladesh");
		country_list.add("SriLanka");
		
		
		int i =1;
		int f =1;
		
	int m = o_dice.validdefender(file, country_per_player,attack_country,
			defend_country, country_list, i,f);
	assertNotEquals(1, m);
	}
	
	@Test
	public void test11() {
	
		int total_players = 2;
		String attack_country = "India";
		String defend_country = "Pakistan";
		List<List<String>> a = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		a.add(country_per_player1);
		a.add(country_per_player2);
		
		int i = 1;
	
		List<List<String>> o = o_dice.placeAttackCountry(total_players, attack_country,defend_country,
			a,  i);
		
		assertEquals(a.get(0),o.get(0));
		
		
	 
	}
	@Test
	public void test12() {
	
		int total_players = 2;
		String attack_country = "India";
		String defend_country = "Pakistan";
		List<List<String>> a = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("China");
		country_per_player1.add("Australia");
		country_per_player2.add("Bangladesh");
		country_per_player2.add("Pakistan");
		country_per_player2.add("SriLanka");
		a.add(country_per_player1);
		a.add(country_per_player2);
		
		int i = 1;
	
		List<List<String>> o = o_dice.placeAttackCountry(total_players, attack_country,defend_country,
			a,  i);
		
		assertNotEquals(a.get(1),o.get(0));
	}
	
	//for cards test
	@Test
	/**
	 * This method will test trading value for three different types of card
	 * */
	public void test13() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 1);
		c2.put("China", 2);
		c3.put("Rusia", 3);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(10, extra_army);
	}
	
	@Test
	/**
	 * This method will test trading value for three Infantry cards  
	 * */
	public void test14() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 1);
		c2.put("China", 1);
		c3.put("Rusia", 1);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(4, extra_army);
	}
	
	@Test
	/**
	 * This method will test trading value for three Cavalry cards  
	 * */
	public void test15() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 2);
		c2.put("China", 2);
		c3.put("Rusia", 2);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(6, extra_army);
	}
	
	@Test
	/**
	 * This method will test trading value for three Artillery cards  
	 * */
	public void test16() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 3);
		c2.put("China", 3);
		c3.put("Rusia", 3);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(8, extra_army);
	}

	@Test
	/**
	 * This method will test input of cards and trading of cards
	 * */
	public void test17() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> cards =new HashMap<String,Integer>();
		cards.put("India", 1);
		cards.put("China", 2);
		cards.put("Rusia", 3);
		cards.put("Mongolia", 3);
		cards.put("Africa", 2);
		int extra_army = o_card.trade_card(cards);
		assertEquals(10, extra_army);
	}
	
	//for map validation test
	File file = new File("D:/Projects/Risk/SOEN-6441/src/main/java/world.map");
	
	@Test
	public void test18() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
		//});
		
	}
	
	@Test
	public void test19() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(0, b);
		//});
		
	}
	
	@Test
	public void test20() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);
		//});
		
	}
	
	@Test
	public void test21() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(0, b);
		//});
		
	}
	
	//for naming players test
	@Test
	public void test22() {
		RGPnamingPlayers a = new RGPnamingPlayers();
		int f = a.getPlayers();
		assertEquals(1, f);
	}
	
	//for reinforcement test
	RGPreinforcement ra = new RGPreinforcement();
	/**
	 * This method is used to test if the reinforced armies are calculated as per the risk rules when he won's one continent
	 */
	@Test
	public void test23() {
	
	
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
	public void test24() {
	
	
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
	/**
	 * End of the game test
	 * */
	public void test25() {
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
