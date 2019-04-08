import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;

/**
 * This class is for test cases of map validation
 * @author pavan
 *  @version 1.0.0
 */
public class RGPMapValidationTest {
	File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");

	@Test
	public void test() throws Exception{
		RGPmap a = new RGPmap();
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
	}
	
	@Test
	public void test1() throws Exception{
		RGPmap a = new RGPmap();
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
	}
	
	@Test
	public void test2() throws Exception{
		RGPmap a = new RGPmap();
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);		
	}
	
	@Test
	public void test3() throws Exception{
		RGPmap a = new RGPmap();
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);		
	}

}
