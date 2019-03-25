import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RGPattackTest {


	RGPdiceroll o_dice = new RGPdiceroll();
	
	@Test
	void test() {
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
		
		int i = o_dice.validattcacker(Country,country_per_player,1);
		assertEquals(1, i);
		
	}
	
	
	
	void test1() throws Exception {
		
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
		String attack_country = "India";
		String defend_country = "Pakistan";
		File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
		
		ArrayList<String> country_list = new ArrayList<String>();
		country_list.add("India");
		country_list.add("China");
		country_list.add("Australia");
		country_list.add("Bangladesh");
		country_list.add("Pakistan");
		country_list.add("SriLanka");
		
		int f=1;
		int i=0;
		int j = o_dice.validdefender(file,country_per_player, attack_country,defend_country,country_list, i, f);
		assertEquals(1, j);
		
		
		
	}
		

}

