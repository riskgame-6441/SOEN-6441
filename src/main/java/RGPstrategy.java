import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RGPstrategy {
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) throws Exception;
	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception;
	public void fortify(File file, int i,List<List<String>> country_per_player,HashMap<String, Integer> army_per_country) throws Exception;
}
