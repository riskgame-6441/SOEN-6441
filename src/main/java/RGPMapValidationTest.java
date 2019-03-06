import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * This class is for test cases of map validation
 * @author pavan
 *  @version 1.0.0
 */
class RGPMapValidationTest {

	@Test
	public void test(){
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(1, b);
		});
		
	}
	
	@Test
	public void test1(){
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedContinents(file);
		assertEquals(0, b);
		});
		
	}
	
	@Test
	public void test2(){
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(1, b);
		});
		
	}
	
	@Test
	public void test3() {
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		RGPmap a = new RGPmap();
		assertThrows(RuntimeException.class, () -> {
		int b = a.validateConnectedCountries(file);
		assertEquals(0, b);
		});
		
	}

}
