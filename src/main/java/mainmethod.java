import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mainmethod {

	public void generateArmy() throws Exception{
		uem object_uem = new uem();
		namingplayers object_namingplayers = new namingplayers();
		int ab=5;
		int n=object_namingplayers.getPlayers(ab); //total number of players
		String[] p= {"Krisha","Dhruvi","Pavan","Koti","Charan"}; //players name
		int total_country = object_uem.countrylist().size();
		ArrayList<String> country_name = object_uem.countrylist();
		
		
		
		army object_army = new army();
		//total army to players
		int armies_per_player = object_army.totalArmy(n,total_country);
		System.out.println("Total No. of countries : "+total_country);
		System.out.println("Per Player armies : "+armies_per_player);
		
		//divide countries
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_per_player = object_army.divideCountry(p,country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);
		
		
		//divide armies to countries
		HashMap<String,Integer> army_per_country = new HashMap<String,Integer>();
		army_per_country = object_army.armyPerCountry(p,armies_per_player,country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);
		
	}

}
