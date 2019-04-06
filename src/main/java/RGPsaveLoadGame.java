import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

public class RGPsaveLoadGame implements Serializable{

	
	
	public  void saveGame(RGPGameElements gameElements){
		
	        try
	        {  
	        	System.out.println("hello");
	        	/**JFileChooser fileChooser = new JFileChooser();
	        	Component modalToComponent = null;
	        	File file = null;
				if (fileChooser.showOpenDialog(modalToComponent ) == JFileChooser.APPROVE_OPTION) {
	        	   file = fileChooser.getSelectedFile();
	        	}
	        	**/
	            FileOutputStream saveFile=new FileOutputStream("savegame.ser");
	            ObjectOutputStream save = new ObjectOutputStream(saveFile);
	            save.writeObject(gameElements);
	           
	            System.out.println("hello");
	            save.close(); 
	            loadGame();
	        }
	        catch(Exception exc)
	        {
	            exc.printStackTrace();            
	        }       
	    }
	
	public static  void loadGame(){
		RGPGameElements gameElements = new RGPGameElements();
		try
        {
            // Open file to read from, named SavedObj.sav.
            FileInputStream saveFile = new FileInputStream("savegame.ser");

            // Create an ObjectInputStream to get objects from save file.
            ObjectInputStream save = new ObjectInputStream(saveFile);           

            gameElements = (RGPGameElements ) save.readObject();
            System.out.println(gameElements.army_per_country);
            // Close the file.
            save.close(); // This also closes saveFile.

        }
        catch(Exception exc)
        {
            exc.printStackTrace(); // If there was an error, print the info.
        }
        
	}
/**	public static void main(String[] args) {
		// TODO Auto-generated method stub
        saveGame();
	}
*/
}
