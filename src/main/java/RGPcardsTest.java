import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;

/**
 * This class is for testing cards functionality
 * 
 *  @author Dhruvi Gadhiya
 *  @version 1.0.0
 * */
public class RGPcardsTest {
	
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
	/**
	 * This method will test trading value for three Infantry cards  
	 * */
	public void test1() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 1);
		c2.put("China", 1);
		c3.put("Rusia", 1);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(4, extra_army);
	}
	
	@Test
	/**
	 * This method will test trading value for three Cavalry cards  
	 * */
	public void test2() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 2);
		c2.put("China", 2);
		c3.put("Rusia", 2);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(6, extra_army);
	}
	
	@Test
	/**
	 * This method will test trading value for three Artillery cards  
	 * */
	public void test3() {
		RGPcardDivision o_card = new RGPcardDivision();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c2 =new HashMap<String,Integer>();
		HashMap<String,Integer> c3 =new HashMap<String,Integer>();
		c1.put("India", 3);
		c2.put("China", 3);
		c3.put("Rusia", 3);
		int extra_army = o_card.check_cards_deal(c1,c2,c3);
		assertEquals(8, extra_army);
	}

	@Test
	/**
	 * This method will test input of cards and trading of cards
	 * */
	public void test4() {
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
	
}
