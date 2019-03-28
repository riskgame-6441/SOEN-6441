import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RGPplayer{
	
	File file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
	public int reinforcement() throws Exception {
		RGParmy o_army = new RGParmy();
		RGPlisting o_uem = new RGPlisting();
		RGPfortification o_fortification = new RGPfortification();
		RGPprintTable o_printtable = new RGPprintTable();
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> army_per_country = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry();
		HashMap<String, String> country_continent = o_uem.getCountryContinent();
		ArrayList<String> continent_list = o_uem.continentlist();
		ArrayList<String> country_list = o_uem.countrylist();
		//File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
		int i = 0;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		
		int total_country = o_uem.countrylist().size();
		ArrayList<String> country_name = o_uem.countrylist();
		RGPreinforcement o_reinforcement = new RGPreinforcement();
		main a = new main();
		
		
		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent,
				contvalue);
		int extra_army = 0;
		z += extra_army;
		System.out.println("Number of armies to Reinforcement : " + z);

		army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
		
		// print table
		o_printtable.getTable(file, i, country_per_player, army_per_country);
		return z;
	}
	
	public void attack() throws Exception{
		RGParmy o_army = new RGParmy();
		RGPlisting o_uem = new RGPlisting();
		RGPfortification o_fortification = new RGPfortification();
		RGPprintTable o_printtable = new RGPprintTable();
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> army_per_country = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry();
		HashMap<String, String> country_continent = o_uem.getCountryContinent();
		ArrayList<String> continent_list = o_uem.continentlist();
		ArrayList<String> country_list = o_uem.countrylist();
		//File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
		int i = 0;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
		int attacker_armies = 0;
		int defender_armies = 0;
		int attacker_armies1 = 0;
		int defender_armies1 = 0;
		String attack_country = null;
		String defend_country = null;
		int armies1 = 0;
		int army1 = 0;
		Scanner ab = new Scanner(System.in);

		for (int k = 0; k < 100; k++) {

			System.out.println("Do you want to attack ?(y/n)");
			String ans = ab.next();
			if (ans.equalsIgnoreCase("y")) {

				// attack phase
				int flag = 0, g = 0, p = 0, h = 0;
				RGPdiceroll o_dice = new RGPdiceroll();

				while (flag == 0) {
					while (p == 0) {
						System.out.println("Enter country name from which you want to attack");
						attack_country = ab.next();
						int value = o_dice.validattcacker(attack_country, country_per_player, i);
						if (value == 0) {
							System.out.println("Please enter country that you own.");
							break;
						} else {
							flag = 1;

						}
						int j;
						ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, attack_country);
						int m = neighbour_countries.size();
						for (j = 0; j < m; j++) {
							if (country_per_player.get(i).contains(neighbour_countries.get(j))) {

								h++;
							}
						}
						if (h == m) {
							p = 0;
							System.out.println("You can't attack adjacent country which is owned by you.");
						} else {
							p = 1;
						}

					}
				}
				int f = 1;
				int value = 0;
				while (value == 0) {
					System.out.println("Enter country name on which you want to attack");
					defend_country = ab.next();
					value = o_dice.validdefender(file, country_per_player, attack_country, defend_country,
							country_list, i, f);

				}
				attacker_armies = army_per_country.get(attack_country);
				defender_armies = army_per_country.get(defend_country);
				if ((attacker_armies > 1)) {
					if (attacker_armies < 2) {
						System.out.println("You armies are not sufficient to attack ");
						o_fortification.fortification(file, i, country_per_player, army_per_country,
								attacker_armies, defender_armies, attack_country, defend_country);
						// break;
					} else {
						army_per_country = o_dice.rollDice(attacker_armies, defender_armies, file, i,
								country_per_player, army_per_country, attack_country, defend_country);
						attacker_armies = army_per_country.get(attack_country);
						defender_armies = army_per_country.get(defend_country);
						int j = 0;

						if ((attacker_armies < 1) || (defender_armies < 1)) {

							if (defender_armies < 1) {

								army_per_country = o_dice.placeAttackArmies(attacker_armies, attack_country,
										defend_country, army_per_country);
								int total_players = 0;
								country_per_player = o_dice.placeAttackCountry(total_players, attack_country,
										defend_country, country_per_player, i);

							}
						}

					}
				} else {
					System.out.println("You can't attack with one Army");
				}
				System.out.println(country_per_player.get(i));
				o_printtable.getTable(file, i, country_per_player, army_per_country);
			}
			if (ans.equalsIgnoreCase("n")) {
				break;
			}
	}

}
	
	public void fortification() throws Exception{
		RGPfortification o_fortification = new RGPfortification();
		RGPprintTable o_printtable = new RGPprintTable();
		RGPlisting o_uem = new RGPlisting();
		HashMap<String, Integer> army_per_country = o_uem.getcontinentandcontrolvalue();
		//File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
		int i = 0;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		o_fortification.fortify(file, country_per_player.get(i), army_per_country);
		o_printtable.getTable(file, i, country_per_player, army_per_country);
	}
}
