import java.io.File;
import java.util.Scanner;

public class calculatinglines {

    public int totallines() throws Exception{
    	File file = new File("D:\\\\Risk game Git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\world.map");
    	//File file = new File("E:/Risk Game Git/SOEN-6441/src/main/java/world.map");
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        return count;
    }
    public int countrylines() throws Exception{
        int a = 0;
        File file = new File("D:\\\\Risk game Git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\world.map");
        //File file = new File("E:/Risk Game Git/SOEN-6441/src/main/java/world.map");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            a++;
            if(sc.next().equals("[Territories]")){
                break;
            }
        }
        return a;
    }
    public int continentlines() throws Exception{
        int b = 0;
        File file = new File("D:\\\\Risk game Git\\\\SOEN-6441\\\\src\\\\main\\\\java\\\\world.map");
        //File file = new File("E:/Risk Game Git/SOEN-6441/src/main/java/world.map");
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
