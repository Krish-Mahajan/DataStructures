package chap10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hyphen {

	public static void main(String args[]) throws IOException{ 
		int i;
		
		// First make sure that both files have been specified 
		if(args.length !=2) {
			System.out.println("Usage : CopyFile from To");
			return;
		} 
		
		//Copy File and  substitute hyphens
		try(FileReader fin = new FileReader(args[0]);
			FileWriter fout = new FileWriter(args[1])) 
		{
			do {
				i = fin.read();
				
				// convert space to a hyphen 
				if((char)i == ' ') i = '-';
				
				if(i != -1) fout.write(i);
				
			} while (i != -1);
		} catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
	}
}
