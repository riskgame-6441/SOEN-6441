import java.util.ArrayList;

public class example {
    public void playercountryandarmy() throws Exception{
        army am = new army();
        uem a1 = new uem();
        ArrayList<String> list = a1.countrylist();
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> player4 = new ArrayList<String>();
        ArrayList<String> player5 = new ArrayList<String>();
        ArrayList<Integer> player1army = new ArrayList<Integer>();
        ArrayList<Integer> player2army = new ArrayList<Integer>();
        ArrayList<Integer> player3army = new ArrayList<Integer>();
        ArrayList<Integer> player4army = new ArrayList<Integer>();
        ArrayList<Integer> player5army = new ArrayList<Integer>();


        int n = 2;
        int i = 0;
        int j = 0;
        int m = 30;
        int k = 0;
        int l = 1;
        int a = 1;
        int q = 0;
        while (true) {
            if (n == 2) {
                player1.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player2.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
            }
            if (n == 3) {
                player1.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player2.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player3.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
            }
            if (n == 4) {
                player1.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player2.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player3.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player4.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
            }
            if (n == 5) {
                player1.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player2.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player3.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player4.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
                player5.add(list.get(j));
                j = j + 1;
                if (j == list.size()) {
                    break;
                }
            }
        }

        // while (true){
        //if (l == 30) {
        // break;
        // }
        //if (l > 1) {
        //  player1army.set(i, l);
        // }
        //if (l == 1) {
        // player1army.add(i, l);
        // }
        //  i = i + 1;
        // a = a + 1;
        //if (a == 30) {
        //  System.out.println(player1army);
        // l = 1;
        // i = 0;
        // break;
        // }
        //if (i == player1.size()) {
        //  i = 0;
        // l = l + 1;
        //}
        // }

            while (true) {
                if (l == 30) {
                break;
                }
                if (l > 1) {
                    player2army.set(i, l);
                }
                if (l == 1) {
                    player2army.add(i, l);
                }
                i = i + 1;
                a = a + 1;
                if (a == am.display()) {
                    System.out.println(player2army);
                    l = 1;
                    i = 0;
                    a = 1;
                    break;
                }
                if (i == player2.size()) {
                    i = 0;
                    l = l + 1;
                }
            }
        while (true) {
            if (l == 30) {
            break;
            }
            if (l > 1) {
                player1army.set(i, l);
            }
            if (l == 1) {
                player1army.add(i, l);
            }
            i = i + 1;
            a = a + 1;
            if (a == am.display()) {
                System.out.println(player1army);
                l = 1;
                i = 0;
                a = 1;
                break;
            }
            if (i == player1.size()) {
                i = 0;
                l = l + 1;
            }
        }
        while (true) {
            //if (l == 30) {
            //break;
            //}
            if (l > 1) {
                player3army.set(i, l);
            }
            if (l == 1) {
                player3army.add(i, l);
            }
            i = i + 1;
            a = a + 1;
            if (a == am.display()) {
                System.out.println(player3army);
                l = 1;
                i = 0;
                a = 1;
                break;
            }
            if (i == player3.size()) {
                i = 0;
                l = l + 1;
            }
        }
        while (true) {
            //if (l == 30) {
            //break;
            //}
            if (l > 1) {
                player4army.set(i, l);
            }
            if (l == 1) {
                player4army.add(i, l);
            }
            i = i + 1;
            a = a + 1;
            if (a == am.display()) {
                System.out.println(player4army);
                l = 1;
                i = 0;
                a = 1;
                break;
            }
            if (i == player4.size()) {
                i = 0;
                l = l + 1;
            }
        }
        while (true) {
            //if (l == 30) {
            //break;
            //}
            if (l > 1) {
                player5army.set(i, l);
            }
            if (l == 1) {
                player5army.add(i, l);
            }
            i = i + 1;
            a = a + 1;
            if (a == am.display()) {
                System.out.println(player5army);
                l = 1;
                i = 0;
                a = 0;
                break;
            }
            if (i == player5.size()) {
                i = 0;
                l = l + 1;
            }
        }
        }

    }
