import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class is aggressive strategy of player
 * @author pavan
 *
 */
public class RGPaggressive {

	RGPattack o_attack = new RGPattack();
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	RGPfortification o_fortification = new RGPfortification();
	/**
	 * This method is for attack phase
	 */
	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception{
		String a_country = " ";
		a_country = o_attack.getAttackingCountryAggressive(country_per_player.get(i), army_per_country);
		System.out.println("Attacker Country : "+a_country);
		ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
		ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i), neighbour_countries);
		int a_armies = army_per_country.get(a_country);
		System.out.println("Attacker Armies : "+a_armies);
		
		for(int l=0;l<to_be_attacked_countries.size();l++) {
			if(a_armies<=1) {
				break;
			}
			String d_country = to_be_attacked_countries.get(l);
			int d = o_dice.getDefenderIndex(d_country, country_per_player);
			int d_armies = army_per_country.get(d_country);
								
			army_per_country = o_dice.rollDiceAggressive(a_armies, d_armies, file, i, country_per_player, army_per_country, a_country, d_country);
			a_armies = army_per_country.get(a_country);
			d_armies = army_per_country.get(d_country);
			
			if(d_armies == 0) {
				army_per_country = o_dice.placeAttackArmiesAggressive(a_armies, a_country, d_country, army_per_country);
				country_per_player = o_dice.placeAttackCountryAggressive(a_country, d_country, country_per_player, i, d, out_players);
			}
			System.out.println(army_per_country);
			System.out.println(country_per_player);
		}
		o_printtable.getTable(file, i, country_per_player, army_per_country);
	}
	
	/**
	 * This method is for fortification phase
	 */
	public void fortify(File file, int i,List<List<String>> country_per_player,HashMap<String, Integer> army_per_country) throws Exception{
		o_fortification.fortifyAggressive(file, country_per_player.get(i), army_per_country);
		System.out.println("Fortification Phase done");
		o_printtable.getTable(file, i, country_per_player, army_per_country);
	}
}
