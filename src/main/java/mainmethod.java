import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mainmethod {

	List<List<String>> country_per_player = new ArrayList<List<String>>();
	
	int n;
	int i = 0;
	namingplayers object_namingplayers = new namingplayers();
	public void generateArmy() throws Exception{
		uem object_uem = new uem();
		namingplayers object_namingplayers = new namingplayers();
		//mapoptions object_mapoptions = new mapoptions();
		//int ab=5;
		int n=5; //total number of players
		//String[] p= {"Krisha","Dhruvi","Pavan","Koti","Charan"}; //players name
		int total_country = object_uem.countrylist().size();
		ArrayList<String> country_name = object_uem.countrylist();
		System.out.println(country_name);
		System.out.println(n);
		
		
		army object_army = new army();
		//total army to players
		int armies_per_player = object_army.totalArmy(n,total_country);
		System.out.println("Total No. of countries : "+total_country);
		System.out.println("Per Player armies : "+armies_per_player);
		
		//divide countries
		
		country_per_player = object_army.divideCountry(n,country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);
		
		
		//divide armies to countries
		HashMap<String,Integer> army_per_country = new HashMap<String,Integer>();
		army_per_country = object_army.armyPerCountry(n,armies_per_player,country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);
		
	}
	
	public List<List<String>> getCountryPerPlayer(){
		System.out.println();
		return country_per_player;
	}

}
