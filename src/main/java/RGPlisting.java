import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * This class is to get country and continent list from map file
 * This class also extends RGPcalcLine class
 * @author pavan
 * @version 1.0.0
 */
public class RGPlisting extends RGPcalcLine{
	
	main o_main = new main();
	/**
	 * This method returns country list
	 * @return returns total countries
	 * @throws Exception
	 */
    public ArrayList<String> countrylist() throws Exception{
        String fileWord = "Territories";
        String searchword = " ";
        ArrayList<String> list = new ArrayList<String>();
        int i;
        File file = o_main.file;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = line2();
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchword = sc.next();
            if (searchword.equals("[Territories]")) {
                for (i = 0; i < n-1; i++) {
                	if(!sc.hasNext()) {
                		break;
                	}
                    String text = sc.next();
                    String[] input = text.split(",");
                    //System.out.println(input[0]);
                    list.add(input[0]);
                }
                j = j + 1;
            }
        }

        return list;
    }
    /**
     * This method returns country list
     * @param file1 contains the file path of a map
     * @return returns total countries
     * @throws Exception
     */
    public ArrayList<String> countrylist(File file1) throws Exception{
        String fileWord = "Territories";
        String searchword = " ";
        ArrayList<String> list = new ArrayList<String>();
        int i;
        File file = file1;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = line2(file);
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchword = sc.next();
            if (searchword.equals("[Territories]")) {
                for (i = 0; i < n-1; i++) {
                	if(!sc.hasNext()) {
                		break;
                	}
                    String text = sc.next();
                    String[] input = text.split(",");
                    //System.out.println(input[0]);
                    list.add(input[0]);
                }
                j = j + 1;
            }
        }

        return list;
    }
    /**
     * This method returns continent list
     * @return returns total continents in a map file
     * @throws Exception
     */
    public ArrayList<String> continentlist() throws Exception{
        String searchcontinent = " ";
        ArrayList<String> continentlist = new ArrayList<String>();
        int i;
        File file = o_main.file;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = line1();
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Continents]")) {
                for (i = 0; i <= n-2; i++) {
                    String text = sc.next();
                    String[] input = text.split("=");
                    continentlist.add(input[0]);
                }
                j = j + 1;
            }
        }
        return continentlist;
    }
    /**
     * This method returns continent list
     * @param file1 contains the file path of a map
     * @return returns total continents in a map file
     * @throws Exception
     */
    public ArrayList<String> continentlist(File file1) throws Exception{
        String searchcontinent = " ";
        ArrayList<String> continentlist = new ArrayList<String>();
        int i;
        Scanner sc = new Scanner(file1);
        int j = 0;
        int n = line1(file1);
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Continents]")) {
                for (i = 0; i <= n-2; i++) {
                    String text = sc.next();
                    String[] input = text.split("=");
                    continentlist.add(input[0]);
                }
                j = j + 1;
            }
        }
        return continentlist;
    }
    
    /**
     * This method returns continent and control value
     * @return returns continent name and value 
     * @throws Exception
     */
    public HashMap<String, Integer> getcontinentandcontrolvalue() throws Exception{
    	HashMap<String, Integer> contvalue = new HashMap<String, Integer>();
    	String searchcontinent = " ";
        int i;
        File file = o_main.file;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = line1();
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Continents]")) {
                for (i = 0; i <= n-2; i++) {
                    String text = sc.next();
                    String[] input = text.split("=");
                    int x = Integer.parseInt(input[1]);
                    contvalue.put(input[0],x);
                }
                j = j + 1;
            }
        }
    	return contvalue;
    }
    /**
     * This method returns continent and control value
     * @param file1 contains the file path of a map
     * @return returns continent name and value
     * @throws Exception
     */
    public HashMap<String, Integer> getcontinentandcontrolvalue(File file1) throws Exception{
    	HashMap<String, Integer> contvalue = new HashMap<String, Integer>();
    	String searchcontinent = " ";
        int i;
        File file = file1;
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = line1();
        while (sc.hasNextLine()) {
            if (j == 1) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Continents]")) {
                for (i = 0; i <= n-2; i++) {
                    String text = sc.next();
                    String[] input = text.split("=");
                    int x = Integer.parseInt(input[1]);
                    contvalue.put(input[0],x);
                }
                j = j + 1;
            }
        }
    	return contvalue;
    }
    
    /**
     * This method returns continent and countries
     * @return returns continent name and no of countries in that continent
     * @throws Exception
     */
    public HashMap<String, Integer> getcontinentandcountry() throws Exception{
    	HashMap<String, Integer> contcountry = new HashMap<String, Integer>();
    	String searchcontinent = " ";
    	File file = o_main.file;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
        	
            if (!sc.hasNext()) {
                break;
            }
            //System.out.println(j++);
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Territories]")) {
            	while(sc.hasNextLine()){
            		if (!sc.hasNext()) {
                        break;
                    }
                	String text = sc.next();
                    String[] input = text.split(",");
                    if(contcountry.containsKey(input[3])){
                    	contcountry.put(input[3], contcountry.get(input[3])+1);
                    }else{
                    	contcountry.put(input[3], 1);
                    }
            	}
            }
            
        }
    	return contcountry;
    }
    /**
     * This method returns continent and countries
     * @param file1 contains the file path of a map
     * @return returns continent name and no of countries in continent
     * @throws Exception
     */
    public HashMap<String, Integer> getcontinentandcountry(File file1) throws Exception{
    	HashMap<String, Integer> contcountry = new HashMap<String, Integer>();
    	String searchcontinent = " ";
    	File file = file1;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
        	
            if (!sc.hasNext()) {
                break;
            }
            //System.out.println(j++);
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Territories]")) {
            	while(sc.hasNextLine()){
            		if (!sc.hasNext()) {
                        break;
                    }
                	String text = sc.next();
                    String[] input = text.split(",");
                    if(contcountry.containsKey(input[3])){
                    	contcountry.put(input[3], contcountry.get(input[3])+1);
                    }else{
                    	contcountry.put(input[3], 1);
                    }
            	}
            }
            
        }
    	return contcountry;
    }
    /**
     * This method is to get particular country of a continent
     * @return country continent
     * @throws Exception
     */
    public HashMap<String, String> getCountryContinent() throws Exception{
    	HashMap<String,String> country_continent = new HashMap<String,String>();
    	
    	String searchcontinent = " ";
    	File file = o_main.file;
    	Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
        	
            if (!sc.hasNext()) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Territories]")) {
            	while(sc.hasNextLine()){
            		if (!sc.hasNext()) {
                        break;
                    }
                	String text = sc.next();
                    String[] input = text.split(",");
                    country_continent.put(input[0], input[3]);
            	}
            }
            
        }
        
    	return country_continent;
    }
    /**
     * This method returns country from a continent
     * @param file1 contains the file path of a map
     * @return returns country name of a continent
     * @throws Exception
     */
    
    public HashMap<String, String> getCountryContinent(File file1) throws Exception{
    	HashMap<String,String> country_continent = new HashMap<String,String>();
    	
    	String searchcontinent = " ";
    	File file = file1;
    	Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
        	
            if (!sc.hasNext()) {
                break;
            }
            searchcontinent = sc.next();
            if (searchcontinent.equals("[Territories]")) {
            	while(sc.hasNextLine()){
            		if (!sc.hasNext()) {
                        break;
                    }
                	String text = sc.next();
                    String[] input = text.split(",");
                    //System.out.println(input[0]);
                    //System.out.println(input[3]);
                   // System.exit(0);
                    country_continent.put(input[0],input[3]);
            	}
            }
            
        }
        
    	return country_continent;
    }

}


