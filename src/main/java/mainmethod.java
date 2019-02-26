import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mainmethod {

	public static void main(String[] args) {
	
		int n=5; //total number of players
		String[] p= {"Krisha","Dhruvi","Pavan","Koti","Charan"}; //players name
		int total_country = 42;
		ArrayList<String> country_name = new ArrayList<String>();
		for(int l=0;l<total_country;l++) {
			country_name.add("c"+l);
		}
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		
		army a = new army();
		//total army to players
		int armies_per_player = a.totalArmy(n,total_country);
		System.out.println("Total No. of countries : "+total_country);
		System.out.println("Per Player armies : "+armies_per_player);
		
		//divide countries
		country_per_player = a.divideCountry(p,country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);
		
		
		//divide armies to countries
		HashMap<String,Integer> army_per_country = new HashMap<String,Integer>();
		army_per_country = a.armyPerCountry(p,armies_per_player,country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);
		
	}

}
