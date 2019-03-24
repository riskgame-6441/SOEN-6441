import java.io.File;
/**
 * This class is make file path global
 * @author pavan
 * @version 1.0.0
 */
public class RGPmapCentral {
    /**
     * This method is make file path global based on user input
     * @param value contains user option
     * @return
     */
	public File mapOption(int value) {
		File file = new File("C:\\Misc\\Concordia\\6441-git\\SOEN-6441\\src\\main\\java\\world.map");
		// TODO Auto-generated method stub
		int option = value;
		if (option == 1)
		{
			file = new File("C:\\\\Misc\\\\Concordia\\\\6441-git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\cmap.map");
		}
		if (option == 2)
		{
	         file = new File("C:\\\\Misc\\\\Concordia\\\\6441-git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\world.map");

		}
		if (option == 3)
		{
	         file = new File("C:\\\\Misc\\\\Concordia\\\\6441-git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\newworld.map");

		}
		
		return file;
	}
}
