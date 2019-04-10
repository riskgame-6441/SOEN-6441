import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * This method is to test save and game load
 * @author raoko
 *
 */
public class RGPsaveTest {
	
	RGPGameElements ge = new RGPGameElements();
	
	RGPsaveLoadGame sl = new RGPsaveLoadGame();
	/**
	 * This method is to test save game test
	 */
	@Test
	public void saveGameTest() {
		
		RGPGameElements gameElements;
		
		int total_players = 2;
		
		HashMap<String, Integer> player_names = new HashMap<String, Integer>();
		player_names.put("Charan",1);
		player_names.put("Koti",2);
		
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\src\\main\\java\\world.map");
		
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		List<String> country_per_player1 = new ArrayList<String>();
		List<String> country_per_player2 = new ArrayList<String>();
		country_per_player1.add("India");
		country_per_player1.add("Bang");
		country_per_player2.add("Pak");
		country_per_player2.add("Srilanka");
		country_per_player.add(country_per_player1);
		country_per_player.add(country_per_player2);

		ArrayList<String> country_list = new ArrayList<String>();
		country_list.add("India");
		country_list.add("Bang");
		country_list.add("Pak");
		country_list.add("Srilanka");
		
		
		ArrayList<String> country_name = new ArrayList<String>();
		country_name.add("India");
		country_name.add("Bang");
		country_name.add("Pak");
		country_name.add("Srilanka");
		
		int armies_per_player = 10;
		
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country.put("India",15);
		army_per_country.put("Pak",1);
		army_per_country.put("Srilanka",10);
		army_per_country.put("Bang",9);
		
		
		ArrayList<String> continent_list = new ArrayList<String>();
		continent_list.add("Asia");
		continent_list.add("SA");
		
		List<List<String>> continent_list_per_player = new ArrayList<List<String>>();
		List<String> continent_list_per_player1 = new ArrayList<String>();
		List<String> continent_list_per_player2 = new ArrayList<String>();
		continent_list_per_player1.add("NA");
		continent_list_per_player2.add("NA");
		continent_list_per_player.add(continent_list_per_player1);
		continent_list_per_player.add(continent_list_per_player2);
		
		int total_country = 45;
	
		
		
		HashMap<String, String> country_continent = new HashMap<String, String>();
		country_continent.put("India","Asia");
		country_continent.put("Pak","Asia");
		country_continent.put("Srilanka","SA");
		country_continent.put("Bang","SA");
		
		HashMap<String, Integer> contvalue = new HashMap<String, Integer>();
		contvalue.put("Asia",7);
		contvalue.put("SA",6);
		
		HashMap<String, Integer> contvalue1 = new HashMap<String, Integer>();
		contvalue1.put("Asia",7);
		contvalue1.put("SA",6);
		
	

				int i=1;

				gameElements = sl.gameelements(armies_per_player, army_per_country,
				 continent_list, country_continent,country_list, country_per_player,
				 total_players, file,player_names, continent_list_per_player,contvalue,contvalue1,
				 total_country,country_name,i);

		
		boolean result = sl.saveGame(gameElements);
		

		assertEquals(true, result);
    

	}

	
	/**
	 * This method is to test save game test
	 */
		@Test
		public void saveGameTest1() {
			
			RGPGameElements gameElements;
			
			int total_players = 2;
			
			HashMap<String, Integer> player_names = new HashMap<String, Integer>();
			player_names.put("Charan",1);
			player_names.put("Koti",2);
			
			File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\src\\main\\java\\world.map");
			
			List<List<String>> country_per_player = new ArrayList<List<String>>();
			List<String> country_per_player1 = new ArrayList<String>();
			List<String> country_per_player2 = new ArrayList<String>();
			country_per_player1.add("India");
			country_per_player1.add("Bang");
			country_per_player2.add("Pak");
			country_per_player2.add("Srilanka");
			country_per_player.add(country_per_player1);
			country_per_player.add(country_per_player2);

			ArrayList<String> country_list = new ArrayList<String>();
			country_list.add("India");
			country_list.add("Bang");
			country_list.add("Pak");
			country_list.add("Srilanka");
			
			
			ArrayList<String> country_name = new ArrayList<String>();
			country_name.add("India");
			country_name.add("Bang");
			country_name.add("Pak");
			country_name.add("Srilanka");
			
			int armies_per_player = 10;
			
			HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
			army_per_country.put("India",15);
			army_per_country.put("Pak",1);
			army_per_country.put("Srilanka",10);
			army_per_country.put("Bang",9);
			
			
			ArrayList<String> continent_list = new ArrayList<String>();
			continent_list.add("Asia");
			continent_list.add("SA");
			
			List<List<String>> continent_list_per_player = new ArrayList<List<String>>();
			List<String> continent_list_per_player1 = new ArrayList<String>();
			List<String> continent_list_per_player2 = new ArrayList<String>();
			continent_list_per_player1.add("NA");
			continent_list_per_player2.add("NA");
			continent_list_per_player.add(continent_list_per_player1);
			continent_list_per_player.add(continent_list_per_player2);
			
			int total_country = 45;
		
			
			
			HashMap<String, String> country_continent = new HashMap<String, String>();
			country_continent.put("India","Asia");
			country_continent.put("Pak","Asia");
			country_continent.put("Srilanka","SA");
			country_continent.put("Bang","SA");
			
			HashMap<String, Integer> contvalue = new HashMap<String, Integer>();
			contvalue.put("Asia",7);
			contvalue.put("SA",6);
			
			HashMap<String, Integer> contvalue1 = new HashMap<String, Integer>();
			contvalue1.put("Asia",7);
			contvalue1.put("SA",6);
			
		

					int i=1;

					gameElements = sl.gameelements(armies_per_player, army_per_country,
					 continent_list, country_continent,country_list, country_per_player,
					 total_players, file,player_names, continent_list_per_player,contvalue,contvalue1,
					 total_country,country_name,i);

			
			boolean result = sl.saveGame(gameElements);
			

			assertNotEquals(false, result);
	    
}
		
}


