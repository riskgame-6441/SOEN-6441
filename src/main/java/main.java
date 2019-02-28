import java.util.Scanner;

public class main extends mainmenu {
    public static void main(String[] args) throws Exception{
        //mainmenu a = new mainmenu();
        //a.menu();
        
        namingplayers o_namingplayers = new namingplayers();
        int i = 0;
        Scanner ab = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1- Create a new map");
            System.out.println("2- Use an existing map");
            System.out.println("3- Edit an existing map");
            int option = ab.nextInt();
            switch (option) {
                case 1:
                    System.out.println("go to new map");
                    i = i + 1;
                    break;
                case 2:
                    o_namingplayers.namep();
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
        System.out.println(o_namingplayers.pinp);
        for(i=0;i<o_namingplayers.names.length;i++) {
        System.out.println(o_namingplayers.names[i]);
        }
        /*
        mainmethod object_mainmethod = new mainmethod();
        object_mainmethod.generateArmy();
                
        printtable object_printtable = new printtable();
        //int player_count = object_mainmethod.n;
        //System.out.println(player_count);
        int n=5;
        for(int i=0;i<n;i++) {
        	object_printtable.getTable(i);
        }*/
    }
}
