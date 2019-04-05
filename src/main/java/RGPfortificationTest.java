import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class RGPfortificationTest {

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

}
