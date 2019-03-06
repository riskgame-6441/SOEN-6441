import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class will work on printing values related country, continent, number of armies for each countries for each players.
 * 
 * @author Dhruvi Gadhiya
 * 
 * @version 1.0.0
 * */
public class RGPprintTable {
	
	RGPcalcLine a = new RGPcalcLine();
	int i = 0;
	main o_main = new main();
	
	/**
	 * This method is used to get neighbour countries for given country.
	 * 
	 * @param newword This parameter contains country name.
	 * 
	 * @return This method will return array list of neighbour countries.
	 * */
	public ArrayList<String> getNeighbour(File file1, String newword) throws Exception{
		ArrayList<String> neighbour = new ArrayList<String>();
		String searchword = " ";
		File file = file1;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = a.line2();
        while (sc.hasNextLine()) {
        	if(!sc.hasNext()) {
        		break;
        	}
        	searchword = sc.next();
            if (searchword.equals("[Territories]")) {
                for (i = 0; i < n-1; i++) {
                	if(!sc.hasNext()) {
                		break;
                	}
                    String text = sc.next();
                    String[] input = text.split(",");
                    int size = input.length;
                    if(input[0].equals(newword)) {
                    	for (j = 4; j < size ; j++) {
                    		neighbour.add(input[j]);
                    		
                    	}
                    }
                }
            }
        }
        return neighbour;
	}
	
	/**
	 * This method is used to print table containing information about countries, neighbour countries and their armies.
	 * 
	 * @param player This parameter contains index of current player.
	 * 
	 * @param country_per_player This parameter contains list of list of countries for each player.
	 * 
	 * @param army_per_country This parameter contains hash map of countries(key) and armies for that country(value).
	 */
	public void getTable(File file, int player, List<List<String>> country_per_player, HashMap<String,Integer> army_per_country) throws Exception{
		
		int n = country_per_player.get(player).size();
		for(int i=0;i<n;i++) {
			String country_name = country_per_player.get(player).get(i);
			int c_army = army_per_country.get(country_per_player.get(player).get(i));
			System.out.println("\nCountry Name : "+country_name+"("+c_army+")");
			ArrayList<String> neighbour_countries = getNeighbour(file, country_name);
			int m = neighbour_countries.size();
			for(int j=0;j<m;j++) {
				int army = army_per_country.get(neighbour_countries.get(j));
				System.out.println("=> "+neighbour_countries.get(j)+"("+army+")");
			}
		}
	}
}
