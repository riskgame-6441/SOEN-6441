import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RGPattack {
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
