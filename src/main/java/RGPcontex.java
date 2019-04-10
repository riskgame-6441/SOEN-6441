import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RGPcontex {
		private RGPstrategy strategy;
	
	   public RGPcontex(RGPstrategy strategy){
	      this.strategy = strategy;
	   }
	
	   public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) throws Exception{
	      strategy.reinforcement(army_per_country, country_per_player, i, contvalue1, contvalue, country_continent);
		   //return strategy.doOperation(num1, num2);
	   }
	   public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		   strategy.attack(attack_country, i, country_per_player, file, defend_country, country_list, attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country, cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, total_players);
	   }
	   public void fortify(File file, int i,List<List<String>> country_per_player,HashMap<String, Integer> army_per_country) throws Exception {
		   strategy.fortify(file, i, country_per_player, army_per_country);
	   }
}
