package chap14;


interface StringFunc {
	String func(String str);
}


public class LambdaArgumentDemo { 
	
	// This method has functional interface as the type of its
	// first parameter . Thus , it can be passed a reference to any 
	// instance of that interface,including an instance created by
	// lambda expression. The second parameter specifies the string 
	// to operate on. 
	static String changeStr(StringFunc sf, String s) {
		return sf.func(s);
	} 
	
	public static void main(String args[]) {
		String inStr = "Lamda Expressions Expand Java" ;
		String outStr; 
		
		System.out.println("Here is input string: "+ inStr);
		
		//Define a lambda expression that reverses the contents
		// of a string and assign it to a StringFunc reference variable 
		
		StringFunc reverse = (str) -> {
			String result = "";
			for(int i = str.length()-1;i>=0;i--) {
				result += str.charAt(i);
			} 
			return result;
		} ; 
		
		// Pass reverse to the first argument to changeStr() 
		// Pass the input string as the second argument. 
		
		outStr = changeStr(reverse,inStr); 
		System.out.println("The string reversef: " + outStr); 
		
		
		//This lambda expression replaces spaces with hyphens.
		// It is embedded directly in the call to changeStr() 
		 
		outStr = changeStr((str) -> str.replace(' ', '-'),inStr);
		System.out.println("The string with spaces replaced: " + outStr);    
		
		
		// This block lambda inverts the case of the characters in the 
		// string. It is also embedded directly in the call to changeStr(). 
		outStr = changeStr((str) -> {
								String result = "" ; 
								char ch; 
								for(int i=0; i< str.length();i++) {
									ch = str.charAt(i);
									if(Character.isUpperCase(ch)) 
										result += Character.toLowerCase(ch);
									else 
										result += Character.toUpperCase(ch);
									
								} 
								return result; },inStr);
		System.out.println("The string in reversed case: " + outStr);						
		
	}
	

}
