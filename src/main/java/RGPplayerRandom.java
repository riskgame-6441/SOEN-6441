import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RGPplayerRandom implements RGPstrategy {
	RGPattack o_attack = new RGPattack();
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	RGPreinforcement o_reinforcement = new RGPreinforcement();

	
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) {
		int extra_army = 0;
		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
				country_continent, contvalue);
		z += extra_army;
		army_per_country = o_reinforcement.placeReinforceArmiesRandom(z, i, country_per_player,
				army_per_country);
		System.out.println("Reinforced armies : " + z);
	}


	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		String a_country = o_attack.getAttackingCountryRandom(country_per_player.get(i), army_per_country);
		System.out.println("Attacker Country : " + a_country);
		ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
		ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i),
				neighbour_countries);
		int a_armies = army_per_country.get(a_country);
		System.out.println("Attacker Armies : " + a_armies);

		for (int l = 0; l < to_be_attacked_countries.size(); l++) {
			if (a_armies <= 1) {
				break;
			}
			String d_country = to_be_attacked_countries.get(l);
			int d = o_dice.getDefenderIndex(d_country, country_per_player);
			int d_armies = army_per_country.get(d_country);

			army_per_country = o_dice.rollDiceRandom(a_armies, d_armies, file, i, country_per_player,
					army_per_country, a_country, d_country);
			a_armies = army_per_country.get(a_country);
			d_armies = army_per_country.get(d_country);

			if (d_armies == 0) {
				army_per_country = o_dice.placeAttackArmiesRandom(a_armies, a_country, d_country,
						army_per_country);
				country_per_player = o_dice.placeAttackCountryRandom(a_country, d_country,
						country_per_player, i, d, out_players);
			}
			System.out.println(army_per_country);
			System.out.println(country_per_player);
		}
	}
	public void  fortify(File file, int l, List<List<String>> country_list,HashMap<String,Integer> army_per_country) throws Exception {
		String country1 = " ";
		String country2 = " ";
		
		Random rand = new Random();
		int n = country_list.size();
		country1 = country_list.get(l).get(rand.nextInt(n));
		int m = army_per_country.get(country1);
		int flag=0;
		while(m == 1) {
			country1 = country_list.get(l).get(rand.nextInt(n));
			m = army_per_country.get(country1);
			flag++;
			if(flag==country_list.get(l).size()) {
				break;
			}
		}
		if(flag!=country_list.size()) {
			country2 = country_list.get(l).get(rand.nextInt(n));
			while(country1 == country2) {
				country2 = country_list.get(l).get(rand.nextInt(n));
			}
			
			int f_army = rand.nextInt(m-1);
			int new_army = army_per_country.get(country1) - f_army;
			army_per_country.put(country1, new_army);
			f_army += army_per_country.get(country2);
			army_per_country.put(country2, f_army);
		}
	}
}
