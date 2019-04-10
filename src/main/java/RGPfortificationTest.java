import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class RGPfortificationTest {

	RGPfortification ft = new RGPfortification(); 
	@Test
	/**
	 * This method will test trading value for three different types of card
	 * */
	public void test() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 1);
		c2.put("China", 2);
		c3.put("Rusia", 3);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(10, extra_army);
	}
	@Test
	public void fortifytest1() {
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\world.map");
		String country1 = "Alaska";
		String country2 = "Kamchatka";
		List<String> country_list =  new ArrayList<String>();
		country_list.add("Alaska");
		country_list.add("NorthwestTerritory");
		country_list.add("Alberta");
		country_list.add("Kamchatka");
		country_list.add("Ontario");
		country_list.add("Greenland");
		
		List<String> list = new ArrayList<String>();
		
		{
		 int rv =2;
		 try {
			 rv = ft.checkConnection(file,country1,country2,country_list,list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   assertEquals (1,rv);
					
		}
		
	}
	
	
	@Test
	public void fortifytest2() {
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\world.map");
		String country1 = "Alaska";
		String country2 = "Kamchatka";
		List<String> country_list =  new ArrayList<String>();
		country_list.add("Alaska");
		country_list.add("NorthwestTerritory");
		country_list.add("Alberta");
		country_list.add("Kamchatka");
		country_list.add("Ontario");
		country_list.add("Greenland");
		
		List<String> list = new ArrayList<String>();
		
		{
		 int rv =2;
		 try {
			 rv = ft.checkConnection(file,country1,country2,country_list,list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   assertNotEquals (2,rv);
					
		}
		
	}
	
	@Test
	public void fortifytest3() {
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\world.map");
		String country1 = "Alaska";
		String country2 = "Ontario";
		List<String> country_list =  new ArrayList<String>();
		country_list.add("Alaska");
		country_list.add("NorthwestTerritory");
		country_list.add("Alberta");
		country_list.add("Kamchatka");
		country_list.add("Ontario");
		country_list.add("Greenland");
		
		List<String> list = new ArrayList<String>();
		
		{
		 int rv =2;
		 try {
			 rv = ft.checkConnection(file,country1,country2,country_list,list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   assertNotEquals (2,rv);
					
		}
		
	}
	
	@Test
	public void fortifytest4() {
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\world.map");
		String country1 = "Alaska";
		String country2 = "Ontario";
		List<String> country_list =  new ArrayList<String>();
		country_list.add("Alaska");
		country_list.add("NorthwestTerritory");
		country_list.add("Alberta");
		country_list.add("Kamchatka");
		country_list.add("Ontario");
		country_list.add("Greenland");
		
		List<String> list = new ArrayList<String>();
		
		{
		 int rv =2;
		 try {
			 rv = ft.checkConnection(file,country1,country2,country_list,list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   assertEquals (0,rv);
					
		}
		
	}
}
