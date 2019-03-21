import java.util.Scanner;
public class mainmenu extends mapoptions{
    public void menu() throws Exception{
        int i = 0;
        Scanner a = new Scanner(System.in);
        System.out.println("******WELCOME TO RISK******");
        while(i == 0) {
            System.out.println("1- Start");
            System.out.println("2- Help");
            System.out.println("3- Exit");
            System.out.println("Enter your option");
            int option = a.nextInt();
            switch (option) {
                case 1:
                    mapo();
                    i = i + 1;
                    break;
                case 2:
                    System.out.println("Help");
                    i = i + 1;
                    break;
                case 3:
                    System.out.println("Exit");
                    i = i + 1;
                    break;
                default:
                    while (option > 3) {
                        System.out.println("hello");
                        break;
                    }

            }
        }

    }
}
