import java.io.*;

public class Save implements Serializable{

	private static final long serialVersionUID = 1L;
	private transient League league;
	
	public Save(){}
	
	public void saveFile(League league) {
		
		String path = "C:/Users/chris/Documents/league.ser";
		try {
			FileOutputStream f = new FileOutputStream(path);
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			this.league = league;
			
			o.writeObject(this.league);
			
			o.close();
			f.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} 
	}

}
