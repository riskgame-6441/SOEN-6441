import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RGPplayerCheater implements RGPstrategy{
	RGPattack o_attack = new RGPattack();
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	RGPreinforcement o_reinforcement = new RGPreinforcement();

	
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) {
		army_per_country = o_reinforcement.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
	}


	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		country_per_player = o_attack.attackCheater(file, i, country_per_player, out_players);
		/*for(int j=0;j<country_per_player.get(i).size();j++) {
			ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, country_per_player.get(i).get(j));
			ArrayList<String> to_be_attacked_countries = new ArrayList<String>(); 
			to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i), neighbour_countries);
			for(int k=0;k<to_be_attacked_countries.size();k++) {
				String country = to_be_attacked_countries.get(k);
				int d = o_dice.getDefenderIndex(country, country_per_player);
				country_per_player.get(i).add(country);
				country_per_player.get(d).remove(country);
				if(country_per_player.get(d).size()==0) {
					out_players.add(d);
				}
			}
		}*/
	}
	public void  fortify(File file, int l, List<List<String>> country_list,HashMap<String,Integer> army_per_country) throws Exception {
		for(int i=0;i<country_list.get(l).size();i++) {
			ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, country_list.get(l).get(i));
			ArrayList<String> to_be_attacked_countries = new ArrayList<String>(); 
			to_be_attacked_countries = o_attack.toBeAttackedCountry(country_list.get(l), neighbour_countries);
			if(to_be_attacked_countries.size() >= 1) {
				int army = army_per_country.get(country_list.get(l).get(i));
				army+=army;
				army_per_country.put(country_list.get(l).get(i),army);
			}
		}
	}
}
