import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * This is class for Benevolent strategy of player
 * @author raoko
 *
 */
public class RGPplayerBenevolent implements RGPstrategy{
	RGPattack o_attack = new RGPattack();
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	RGPreinforcement o_reinforcement = new RGPreinforcement();

	/**
	 * This method is reinforcement method
	 */
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) {
		int extra_army = 0;
		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
				country_continent, contvalue);
		z += extra_army;
		army_per_country = o_reinforcement.placeReinforceArmiesBenevolent(z, i, country_per_player,
				army_per_country);
		System.out.println("Reinforced armies : " + z);
	}

	/**
     * This method is for attack phase
     */
	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		
	}
	/**
	 * This method is for fortification phase
	 */
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
					c1 = country2;
					x = army_per_country.get(c1);
				}else {
					c1 = country_list.get(l).get(i);
					x = army_per_country.get(c1);
				}
				y = army_per_country.get(c2);
				if(x<=y) {
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
								c1 = country1;
								x = army_per_country.get(c1);
							}else {
								c1 = country_list.get(l).get(i);
								x = army_per_country.get(c1);
							}
							y = army_per_country.get(c2);
							if(x>=y) {
								country1 = c1;
							}else {
								country1 = c2;
							}
							continue;
						}
						
						if(c1 != " ") {
							c1 = country1;
							x = army_per_country.get(c1);
						}else {
							c1 = country_list.get(l).get(i);
							x = army_per_country.get(c1);
						}
						y = army_per_country.get(c2);
						if(x>=y) {
							country1 = c1;
						}else {
							country1 = c2;
						}
					}else {
						continue;
					}
				}
			}
			int f_army = army_per_country.get(country1)/2;
			int new_army = army_per_country.get(country1) - f_army;
			army_per_country.put(country1, new_army);
			f_army += army_per_country.get(country2);
			army_per_country.put(country2, f_army);	
		}
	}
}
