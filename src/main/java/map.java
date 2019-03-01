import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class map {
	
	calcline a = new calcline();
	printtable o_printtable = new printtable();
	
	public void validateMap(ArrayList<String> country_list, ArrayList<String> continent_list, HashMap<String, String> country_continent) throws Exception {
		
		ArrayList<String> neighbour_country = new ArrayList<String>();
		int n = country_list.size();
		String country=" ",country1;
		int flag=0;
		
		System.out.println(country_list);
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				neighbour_country = o_printtable.getNeighbour(country_list.get(i));
				System.out.println(country_list.get(i));
				System.out.println(neighbour_country);
				
				if(flag == 0) {
					country = country_list.get(i);
					flag=1;
				}else if(country == country_list.get(i)) {
					
				}
				if(country_list.contains(country)) {
					country_list.remove(country);
					
						country1 = neighbour_country.get(0);
					
					country = country1;
				}
				
			}
			
		}
		
		/*
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
      //  Scanner sc = new Scanner(file);
        int n;
		String searchword = " ";
        
		printtable o_printtable = new printtable();
		
		System.out.println(country_list);
		//System.out.println(continent_list);
		//System.out.println(country_continent);
		int flag = 0,flag1=0;
		String country=" ";
		String country1;
		for(int k = 0; k<country_list.size();k++) {
			flag1=0;
			n = a.line2();
    		//System.out.println("Inside for");
			//Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
	        	if(!sc.hasNext()) {
	        		System.out.println("Inside if1");
	        		break;
	        	}
	        	searchword = sc.next();
	            if (searchword.equals("[Territories]")) {
	            	for (int i = 0; i < n-1; i++) {
	                	if(!sc.hasNext()) {
	                		System.out.println("Inside if3");
	                		break;
	                	}
	                    String text = sc.next();
	                    String[] input = text.split(",");
	                    if(flag == 0) {
	                    	country = input[0];
	                    	System.out.println(country);
	                    	flag++;
	                    }
	                    if(country == input[0]) {
	                    	country_list.remove(country);
	                    }else {
	                    	break;
	                    }
	                    
	                    for(int j=4;j<input.length && flag1 == 0;j++) {
	                    	country1 = input[4];
	                    	if(country_list.contains(country1)) {
	                    		country = country1;
	                    		flag1=1;
	                    	}else {
	                    		break;
	                    	}
	                    	System.out.println(country);
	                    	System.out.println(country_list);
	                    }
	                    flag1=0;
	                }
	            }
	    
			}
		}*/
	}
}
