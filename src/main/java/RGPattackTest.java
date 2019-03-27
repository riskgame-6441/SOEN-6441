import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class RGPattackTest {

	RGPdiceroll o_dice = new RGPdiceroll();

	@Test
	public void test() {
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
	public void test6() {
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
	public void test2() {

		int[] dicevalues = { 1, 5, 6 };

		int m = o_dice.minOfArray(dicevalues);
		assertEquals(1, m);
	}
	@Test
	public void test7() {

		int[] dicevalues = { 1, 5, 6 };

		int m = o_dice.minOfArray(dicevalues);
		assertNotEquals(6, m);
	}
	@Test
	public void test3() {
		
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
	public void test4() throws Exception {
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
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\src\\main\\java\\world.map");
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
	assertEquals(0, m);
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
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\src\\main\\java\\world.map");
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
	public void test5() {
	
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
	public void test10() {
	
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
	
}






