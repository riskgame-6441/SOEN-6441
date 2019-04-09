import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RGPsaveLoadGame implements Serializable{
	/**
	 * This method is to save the game
	 * @param gameElements is game elements object
	 */
	public  boolean saveGame(RGPGameElements gameElements){
			
		 boolean saved = false;
		
	        try
	        {  
	            FileOutputStream saveFile=new FileOutputStream("savegame.ser");
	            ObjectOutputStream save = new ObjectOutputStream(saveFile);
	            save.writeObject(gameElements);
	            save.close();
	            saved=true;
	        }
	        catch(Exception exc)
	        {
	            exc.printStackTrace(); 
	            saved=false;
	        }        
	        return saved;
	}
	
	/**
	 * This method is to load the game
	 * @return game element object
	 */
	public RGPGameElements  loadGame(){
		RGPGameElements gameElements = new RGPGameElements();
		try
        {
            FileInputStream saveFile = new FileInputStream("savegame.ser");
            ObjectInputStream save = new ObjectInputStream(saveFile);           
            gameElements = (RGPGameElements ) save.readObject();
            //System.out.println(gameElements.r_flag); 
            save.close();

        }
        catch(Exception exc)
        {
            exc.printStackTrace(); 
        }
        return gameElements;
	}
	
	/**
	 * This method is to store game values in to game element object
	 * @param armies_per_player is no of armies per player
	 * @param army_per_country is no of armies per country
	 * @param continent_list is total continent list
	 * @param country_continent is countries per continent
	 * @param country_list is total country list
	 * @param country_per_player is countries per player
	 * @param total_players is total no of players
	 * @param file is map file
	 * @param player_names is player names
	 * @param continent_list_per_player is continent list per players
	 * @param contvalue is continent value
	 * @param contvalue1 is continent value
	 * @param total_country is total no of countries
	 * @param country_name is countries names
	 * @return game element object
	 */
 public RGPGameElements gameelements(Integer armies_per_player, HashMap<String, Integer> army_per_country,
		 ArrayList<String> continent_list, HashMap<String, String> country_continent,
		 ArrayList<String> country_list, List<List<String>> country_per_player,
		 int total_players, File file,HashMap<String, Integer> player_names, List<List<String>>continent_list_per_player,
		 HashMap<String, Integer> contvalue, HashMap<String, Integer> contvalue1,
		 int total_country,ArrayList<String> country_name,int i)
 {
	 RGPGameElements gameElements = new RGPGameElements();
	 gameElements.armies_per_player = armies_per_player;
		gameElements.army_per_country = army_per_country;
		gameElements.continent_list = continent_list;
		gameElements.country_continent = country_continent;
		gameElements.country_list = country_list;
		gameElements.country_per_player = country_per_player;
		gameElements.total_players = total_players;
		gameElements.file = file;
		gameElements.player_names = player_names;
		gameElements.continent_list_per_player = continent_list_per_player;
		gameElements.contvalue = contvalue;
		gameElements.contvalue1 = contvalue1;
		gameElements.total_country = total_country;
		gameElements.country_name = country_name;
		gameElements.file = file;
		gameElements.i = i;
		return gameElements;
 }
}
