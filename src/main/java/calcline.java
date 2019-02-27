public class calcline{
    public int line1() throws Exception{
        calculatinglines c = new calculatinglines();
        int a=c.countrylines();
        int b=c.continentlines();
        int d=c.totallines();
        int continentline = a - b;
        int countryline = (d-a)-2;
        return continentline;
    }
    public int line2() throws Exception{
        calculatinglines c = new calculatinglines();
        int a=c.countrylines();
        int b=c.continentlines();
        int d=c.totallines();
        int continentline = a - b;
        int countryline = (d-a)-2;
        return countryline;
    }
}