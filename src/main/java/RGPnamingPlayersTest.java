import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * This class contains test case for testing naming players
 * @author pavan
 * @version 1.0.0
 */
class RGPnamingPlayersTest {

	@Test
	void test() {
		RGPnamingPlayers a = new RGPnamingPlayers();
		int f = a.getPlayers();
		Assertions.assertEquals(1, f);
	}

}
