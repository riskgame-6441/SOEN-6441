import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This class will perform fortification phase.
 * 
 * @author dhruvi
 * 
 * @version 1.0.0
 * */
public class RGPfortification {

	RGPprintTable o_printtable = new RGPprintTable();
	
	/**
	 * This method will perform fortification.
	 * 
	 * @param country_list This parameter contains list of countries owned by particular player.
	 * 
	 * @param army_per_country This parameter contains hash map of armies for each country.
	 * */
	public void  fortify(File file,List<String> country_list,HashMap<String,Integer> army_per_country) throws Exception {
		System.out.println(country_list);
		Scanner a = new Scanner(System.in);
		int flag = 0;
		String country1 = " ";
		String country2 = " ";
		
		while(flag==0) {
			while(flag==0) {
				System.out.println("From country1 : ");
				country1 = a.next();
				if(!country_list.contains(country1)) {
					System.out.println("Please enter country that you own.");
					break;
				}else {
					flag=1;
				}
			}
		}
		while(flag==1) {
			while(flag==1) {
				System.out.println("To country2 : ");
				country2 = a.next();
				if(!country_list.contains(country2)) {
					System.out.println("Please enter country that you own.");
					break;
				}else {
					flag=0;
				}
			}
		}
		
		List<String> list = new ArrayList<String>();
		int value = checkConnection(file,country1,country2,country_list,list);
		if(value == 1) {
			int flag2=0;
			while(flag2==0) {
				while(flag2==0) {
					System.out.println("Enter armies to fortify(max "+(army_per_country.get(country1)-1)+") : ");
					int f_army = a.nextInt();
					if(f_army < army_per_country.get(country1)) {
						flag2=1;
						int army1 = army_per_country.get(country1) - f_army;
						army_per_country.put(country1, army1);
						int army2 = army_per_country.get(country2) + f_army;
						army_per_country.put(country2, army2);
					}else {
						System.out.println("You can fortify upto "+(army_per_country.get(country1)-1)+" armies only.");
						break;
					}
				}
			}
		}else if(value == 0 || value == 2) {
			System.out.println("Please enter valid countries which are connected.");
			fortify(file,country_list,army_per_country);
		}
		
	}
	
	/**
	 * This method will check if given two countries are connected or not.
	 * 
	 * @param country1 This parameter contains country value from which army will be fortify.
	 * 
	 * @param country2 This parameter contains country value to which army will be fortify.
	 * 
	 * @return This method will return integer value if given countries are connected(1) or not(0).
	 * */
	public int checkConnection(File file,String country1,String country2,List<String> country_list,List<String> list) throws Exception {
		int flag = 0,return_value = 2;
		List<String> neighbour_list = o_printtable.getNeighbour(file,country1);
		List<String> neighbour_list1 = neighbour_list;
		
		Iterator<String> iter = neighbour_list.iterator();
		while(iter.hasNext()){
		    String str = iter.next();
		    if( !country_list.contains(str)){
		        iter.remove();
		    }
		}
		
		while(flag==0) {
			if( neighbour_list1.contains(country2) ) {
				return_value = 1;
				flag=1;
				break;
			}else {
				list.add(country1);
				for(int i=0;i<neighbour_list1.size();i++) {
					if(!list.contains(neighbour_list1.get(i))) {
						checkConnection(file,neighbour_list1.get(i),country2,neighbour_list1,list);
					}else {
						break;
					}
				}
				return_value = 0;
				break;
			}
			
		}
		return return_value;
	}
	/**
	 * This method is for fortification phase
	 * @param file is file name
	 * @param i is index of current player
	 * @param country_per_player no of countries per player
	 * @param army_per_country no of armies per country
	 * @param attack_army no of attacker armies
	 * @param defend_army no of defender armies
	 * @param attack_country is name of attacker country
	 * @param defend_country is name of defender country
	 * @throws Exception
	 */
	public void fortification(File file, int i, List<List<String>> country_per_player, HashMap<String,Integer> army_per_country) throws Exception
	{
		 RGPfortification o_fortification = new RGPfortification();
		 RGPprintTable o_printtable = new RGPprintTable();
		 
		System.out.println("Fortification Phase");
		System.out.println("=====================================");
		
		o_fortification.fortify(file,country_per_player.get(i),army_per_country);
		o_printtable.getTable(file,i,country_per_player,army_per_country);
	
	}
}
