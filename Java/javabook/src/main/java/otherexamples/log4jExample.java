package otherexamples;

import org.apache.log4j.Level;
import org.apache.log4j.Logger; 
import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class log4jExample {

	/*Get actual class name to be printed on */
	static Logger log = Logger.getLogger(log4jExample.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		log.setLevel(Level.WARN);
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");

	}

}

