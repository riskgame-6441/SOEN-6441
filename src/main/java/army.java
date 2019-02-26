import java.util.ArrayList;
import java.util.Arrays;

public class army{
    int infantry;
    public int display() throws Exception {
        int n = 5;
        if (n == 3){
            infantry = 35;
        }
        else if(n == 4){
            infantry = 30;
        }
        else if(n == 5){
            infantry = 25;
        }
        else {
            infantry = 20;
        }
    return infantry;
    }
}