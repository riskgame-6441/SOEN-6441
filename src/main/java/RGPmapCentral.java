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
		//File file = new File("C:\\Users\\raoko\\Documents\\GitHub\\SOEN-6441\\src\\main\\java\\world.map");

		//File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
		File file = new File("C:\\Users\\Mr.P\\Desktop\\git\\RISK\\SOEN-6441\\src\\main\\java\\world.map");

		// TODO Auto-generated method stub
		int option = value;
		if (option == 1)
		{
			//file = new File("C:\\\\Users\\\\raoko\\\\Documents\\\\GitHub\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\cmap.map");

			//file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/cmap.map");
			file = new File("C:\\Users\\Mr.P\\Desktop\\git\\RISK\\SOEN-6441\\src\\main\\java\\cmap.map");
		}
		if (option == 2)
		{
			//file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
			file = new File("C:\\Users\\Mr.P\\Desktop\\git\\RISK\\SOEN-6441\\src\\main\\java\\world.map");
		}	


	
		if (option == 3)
		{
	         //file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/newworld.map");
			file = new File("C:\\Users\\Mr.P\\Desktop\\git\\RISK\\SOEN-6441\\src\\main\\java\\newworld.map");

	        //file = new File("C:\\\\Users\\\\raoko\\\\Documents\\\\GitHub\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\newworld.map");
		}
		
		return file;
	}
}