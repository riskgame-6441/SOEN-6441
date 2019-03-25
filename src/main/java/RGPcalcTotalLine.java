import java.io.File;
import java.util.Scanner;
/**
 * This class is to calculate total lines of map  file
 * @author pavan
 * @version 1.0.0
 */
public class RGPcalcTotalLine {

	main o_main = new main();
	/**
	 * This method is to return total lines of map file
	 * @return returns count of lines
	 * @throws Exception
	 */
    public int totallines() throws Exception{
    	File file = o_main.file;
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        return count;
    }
    /**
	 * This method is to return total lines of map file
	 * @return returns count of lines
	 * @throws Exception
	 */
    public int totallines(File file) throws Exception{
    	//File file = o_main.file;
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        return count;
    }
    /**
     * This method is to return no of territory lines of map file
     * @return returns count of territories
     * @throws Exception
     */
    public int countrylines() throws Exception{
        int a = 0;
    	File file = o_main.file;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            a++;
            if(sc.next().equals("[Territories]")){
                break;
            }
        }
        return a;
    }
    /**
     * This method is to return no of territory lines of map file
     * @return returns count of territories
     * @throws Exception
     */
    public int countrylines(File file) throws Exception{
        int a = 0;
    	//File file = o_main.file;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            a++;
            if(sc.next().equals("[Territories]")){
                break;
            }
        }
        return a;
    }
    /**
     * This method is to return no of continent lines in map file
     * @return returns count of continents
     * @throws Exception
     */
    public int continentlines() throws Exception{
        int b = 0;
    	File file = o_main.file;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            b++;
            if(sc.next().equals("[Continents]")){
                break;
            }
        }
        return b;
    }
    /**
     * This method is to return no of continent lines in map file
     * @return returns count of continents
     * @throws Exception
     */
    public int continentlines(File file) throws Exception{
        int b = 0;
    	//File file = o_main.file;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            b++;
            if(sc.next().equals("[Continents]")){
                break;
            }
        }
        return b;
    }
}