import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This class is for testing no of armies
 * @author pavan
 * @version 1.0.0
 */
class RGParmyTest {

	@Test
	/**
	 * This method is test case1 for total armies
	 */
	void test() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(2, 35);
		assertEquals(33,b);
	}
	/**
	 * This method is test case2 for total armies
	 */
	void test1() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(3, 35);
		assertEquals(29, b);
	}
	/**
	 * This method is test case3 for total armies
	 */
	void test2() {
		RGParmy a = new RGParmy();
		int b = a.totalArmy(4, 35);
		assertEquals(25, b);
	}

}
