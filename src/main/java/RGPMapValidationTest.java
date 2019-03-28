import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

/**
 * This class is for test cases of map validation
 * @author pavan
 *  @version 1.0.0
 */
public class RGPMapValidationTest {
	File file = new File("D:/Projects/Risk/SOEN-6441/src/main/java/world.map");
	
	@Test
	public void test() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
		//});
		
	}
	
	@Test
	public void test1() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
		//});
		
	}
	
	@Test
	public void test2() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);
		//});
		
	}
	
	@Test
	public void test3() throws Exception{
		//File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		//assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);
		//});
		
	}

}
