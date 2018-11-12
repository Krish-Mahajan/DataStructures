package chap10;

import java.io.*;

public class Help {
	String helpfile;// name of help file

	Help(String fname) {
		helpfile = fname;
	}

	// Display help on a topic
	boolean helpOn(String what) {

		int ch;
		String topic, info;

		// open the help file
		try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))) {
			do {

				// read characters until a # is found
				ch = helpRdr.read();

				// now , see if topics match
				if (ch == '#') {
					topic = helpRdr.readLine();
					if (what.compareTo(topic) == 0) { // found topic
						do {
							info = helpRdr.readLine();
							if (info != null)
								System.out.println(info);
						} while ((info != null) && (info.compareTo("") != 0));
						return true;
					}

				}
			} while (ch != -1);

		} catch (IOException exc) {
			System.out.println("Error accessing help file."); 
			return false;
		}
		return false; // topic not found

	} 
	
	// Get a help topic 
	protected String getSelection() { 
		
		String topic = "";
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		System.out.print("Enter topic: "); 
		
		try {
			topic = br.readLine();
		}
		catch(IOException exc) {
			System.out.println("Error reading Console.");
		}
		
		return topic;
		
	}

}
