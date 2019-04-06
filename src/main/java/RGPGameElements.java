import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RGPGameElements implements Serializable {

	static int total_players;
	static String[] player_names;
	static File file;
	List<List<String>> country_per_player = new ArrayList<List<String>>();
	int armies_per_player;
	HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
	HashMap<String, Integer> cards = new HashMap<String, Integer>();
	
	
	int army_per_player;
	HashMap<String, Integer> contvalue1 =  new HashMap<String,Integer>();
	HashMap<String, String> country_continent = new HashMap<String, String>();
	HashMap<String, Integer> contvalue = new HashMap<String,Integer>();
	ArrayList<String> country_list;
	ArrayList<String> continent_list;
	ArrayList<String> neighbour_countries;
	HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
	//List<List<String>> country_list_for_player = new ArrayList<List<String>>();
}
