/**
 * This class is to calculate lines in map text file
 * @author pavan
 * @version 1.0.0
 */
public class RGPcalcLine{
	/**
	 * This method is to calculate continent lines in text file
	 * @return number of continent lines
	 * @throws Exception
	 */
    public int line1() throws Exception{
        RGPcalcTotalLine c = new RGPcalcTotalLine();
        int a=c.countrylines();
        int b=c.continentlines();
        int d=c.totallines();
        int continentline = a - b;
        int countryline = (d-a)-2;
        return continentline;
    }
    /**
     * This method is to calculate country lines in text file
     * @return number of country lines
     * @throws Exception
     */
    public int line2() throws Exception{
        RGPcalcTotalLine c = new RGPcalcTotalLine();
        int a=c.countrylines();
        int b=c.continentlines();
        int d=c.totallines();
        int continentline = a - b;
        int countryline = (d-a)-3;
        return countryline;
    }
}