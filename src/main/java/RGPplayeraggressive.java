import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RGPplayeraggressive implements RGPstrategy{
	
	RGPattack o_attack = new RGPattack();
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	RGPreinforcement o_reinforcement = new RGPreinforcement();

	
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) {
		int extra_army = 0;
		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent, contvalue);
		z += extra_army;
		army_per_country = o_reinforcement.placeReinforceArmiesAggressive(z, i, country_per_player,
				army_per_country);
		System.out.println("Reinforced armies : " + z);
	}


	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		
		RGPprintTable o_printtable = new RGPprintTable();
		Scanner ab = new Scanner(System.in);
		RGPcardDivision o_card = new RGPcardDivision();
		RGPfortification o_fortification = new RGPfortification();
		RGPreinforcement o_reinforcement = new RGPreinforcement();
		
		String a_country = o_attack.getAttackingCountryAggressive(country_per_player.get(i),
				army_per_country);
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

			army_per_country = o_dice.rollDiceAggressive(a_armies, d_armies, file, i, country_per_player,
					army_per_country, a_country, d_country);
			a_armies = army_per_country.get(a_country);
			d_armies = army_per_country.get(d_country);

			if (d_armies == 0) {
				army_per_country = o_dice.placeAttackArmiesAggressive(a_armies, a_country, d_country,
						army_per_country);
				country_per_player = o_dice.placeAttackCountryAggressive(a_country, d_country,
						country_per_player, i, d, out_players);
			}
			System.out.println(army_per_country);
			System.out.println(country_per_player);
		}
	}
	public void  fortify(File file, int l, List<List<String>> country_list,HashMap<String,Integer> army_per_country) throws Exception {
		if(country_list.size()==1) {
			
		}else {
			int flag = 0;
			String country1 = " ";
			String country2 = " ";
			String c1 = " "; 
			String c2 = " ";
			for(int i=0;i<country_list.get(l).size()-1;i++) {
				int x = 0;
				int y = 0;
				c2 = country_list.get(l).get(i+1);
				
				if(c1 != " ") {
					ArrayList<String> neighbour_countries_x = o_printtable.getNeighbour(file, country2);
					ArrayList<String> to_be_attacked_countries_x = o_attack.toBeAttackedCountry(country_list.get(l), neighbour_countries_x);
					x = to_be_attacked_countries_x.size();
				}else {
					c1 = country_list.get(l).get(i);
					ArrayList<String> neighbour_countries_x = o_printtable.getNeighbour(file, c1);
					ArrayList<String> to_be_attacked_countries_x = o_attack.toBeAttackedCountry(country_list.get(l), neighbour_countries_x);
					x = to_be_attacked_countries_x.size();
				}
				ArrayList<String> neighbour_countries_y = o_printtable.getNeighbour(file, c2);
				ArrayList<String> to_be_attacked_countries_y = o_attack.toBeAttackedCountry(country_list.get(l), neighbour_countries_y);
				y = to_be_attacked_countries_y.size();
				if(x>=y) {
					country2 = c1;
				}else {
					country2 = c2;
				}
			}
			c1 = " ";
			c2 = " ";
			for(int i=0;i<country_list.size()-1;i++) {
				if(country_list.size() == 2) {
					if(country_list.get(l).get(0)==country2) {
						country1 = country_list.get(l).get(1);
					}else {
						country1 = country_list.get(l).get(0);
					}
				}else {
					if(country_list.get(l).get(i)!=country2) {
						int x = 0;
						int y = 0;
						c2 = country_list.get(l).get(i+1);
						if(country_list.get(l).get(i+1)==country2) {
							i++;
							c2 = country_list.get(l).get(i);
							if(c1 != " ") {
								x = army_per_country.get(country1);
							}else {
								c1 = country_list.get(l).get(i);
								x = army_per_country.get(country_list.get(l).get(i));
							}
							y = army_per_country.get(c2);
							if(x>=y) {
								country1 = c1;
							}else {
								country1 = c2;
							}
							continue;
						}else {
							if(c1 != " ") {
								x = army_per_country.get(country1);
							}else {
								c1 = country_list.get(l).get(i);
								x = army_per_country.get(country_list.get(l).get(i));
							}
							y = army_per_country.get(country_list.get(l).get(i+1));
							if(x>=y) {
								country1 = c1;
							}else {
								country1 = c2;
							}
						}
					}
				}
			}
			int f_army = army_per_country.get(country1)-1;
			army_per_country.put(country1, 1);
			f_army += army_per_country.get(country2);
			army_per_country.put(country2, f_army);
		}
	}
}
