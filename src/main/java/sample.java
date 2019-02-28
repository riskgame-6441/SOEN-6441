import java.util.ArrayList;
import java.util.HashMap;

public class sample {
    public static void main(String[] args) throws Exception{
    	uem a = new uem();
    	ArrayList<String> continent_list = a.continentlist();
    	HashMap<String, Integer> contvalue1 = a.getcontinentandcountry(continent_list);
    	System.out.println(contvalue1);
    }
}
