import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class fortification {

	printtable o_printtable = new printtable();
	
	public void fortify(List<String> country_list,HashMap<String,Integer> army_per_country) throws Exception {
		System.out.println(country_list);
		Scanner a = new Scanner(System.in);
		int flag = 0;
		String country1 = " ";
		String country2 = " ";
		
		while(flag==0) {
			while(flag==0) {
				System.out.println("Enter country1 : ");
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
				System.out.println("Enter country2 : ");
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
		int value = checkConnection(country1,country2,country_list,list);
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
			fortify(country_list,army_per_country);
		}
		
	}
	
	public int checkConnection(String country1,String country2,List<String> country_list,List<String> list) throws Exception {
		int flag = 0,return_value = 2;
		List<String> neighbour_list = o_printtable.getNeighbour(country1);
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
						checkConnection(neighbour_list1.get(i),country2,neighbour_list1,list);
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
}
