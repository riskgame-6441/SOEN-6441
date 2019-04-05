import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RGPattack {
	
	RGPprintTable o_printtable = new RGPprintTable();
	RGPdiceroll o_dice = new RGPdiceroll();
	
	public static String getAttackingCountryAggressive(List<String> country_per_player, HashMap<String, Integer> army_per_country) {
		String a_country= " ";
		for(int j=0;j<country_per_player.size()-1;j++) {
			int x = 0;
			String country_x = " ";
			if(a_country != " ") {
				x = army_per_country.get(a_country);
				country_x = a_country;
			}else {
				x = army_per_country.get(country_per_player.get(j));
				country_x = country_per_player.get(j);
			}
			
			int y = army_per_country.get(country_per_player.get(j+1));
			String country_y = country_per_player.get(j+1);
			if(x>=y) {
				a_country = country_x;
			}else {
				a_country = country_y;
			}
		}
		return a_country;
	}
	
	public static String getAttackingCountryRandom(List<String> country_per_player, HashMap<String, Integer> army_per_country) {
		Random rand = new Random();
		String a_country= " ";
		int n = country_per_player.size();
		a_country = country_per_player.get(rand.nextInt(n));
		return a_country;
	}
	
	public List<List<String>> attackCheater(File file, int i, List<List<String>> country_per_player) throws Exception {
		for(int j=0;j<country_per_player.get(i).size();j++) {
			ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, country_per_player.get(i).get(j));
			ArrayList<String> to_be_attacked_countries = new ArrayList<String>(); 
			to_be_attacked_countries = toBeAttackedCountry(country_per_player.get(i), neighbour_countries);
			for(int k=0;k<to_be_attacked_countries.size();k++) {
				String country = to_be_attacked_countries.get(k);
				int d = o_dice.getDefenderIndex(country, country_per_player);
				country_per_player.get(i).add(country);
				country_per_player.get(d).remove(country);
			}
		}
		return country_per_player;
	}
	
	public static ArrayList<String> toBeAttackedCountry(List<String> country_per_player, ArrayList<String> neighbour_countries){
		ArrayList<String> countries = new ArrayList<String>();
		for(int i=0;i<neighbour_countries.size();i++) {
			if(!country_per_player.contains(neighbour_countries.get(i))) {
				countries.add(neighbour_countries.get(i));
			}
		}
		return countries;
	}
}
