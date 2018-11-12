package chap10;

public class FileHelp {

	public static void main(String args[]) {
		Help hlpobj = new Help("src/main/resources/helpfile.txt");
		String topic;
		
		System.out.println("Try the help system. " + 
							"Enter 'stop' to end.");
		
		do {
			topic = hlpobj.getSelection();
			if(!hlpobj.helpOn(topic))
				System.out.println("Topic not found. \n");
		} while(topic.compareTo("stop")!=0);
	}
}
