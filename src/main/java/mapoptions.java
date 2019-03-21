import java.util.Arrays;
import java.util.Scanner;
public class mapoptions extends namingplayers{
	RGPCreatin_map a1 = new RGPCreatin_map();
    String[] name = new String[5];
    int p;
    public void mapo() throws Exception{
        int i = 0;
        Scanner a = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1- Create a new map");
            System.out.println("2- Use an existing map");
            System.out.println("3- Edit an existing map");
            int option = a.nextInt();
            switch (option) {
                case 1:
                    a1.createmap();
                    namep();
                    i = i + 1;
                    break;
                case 2:
                    namep();
                    i = i + 1;
                    break;
                case 3:
                    System.out.println("go to edit map");
                    i = i + 1;
                    break;
                default:
                    System.out.println("Enter correct option");
            }
        }
    }
    public String[] getname(){
        System.out.println(Arrays.toString(name));
        return name;
    }
}
