import java.util.ArrayList;
import java.util.HashMap;

public class sample {
    public static void main(String[] args) throws Exception{
    	uem a = new uem();
    	HashMap<String, Integer> contvalue1 = a.getcontinentandcountry();
    	System.out.println(contvalue1);
    }
}
