package chap1;

public class GalToLit {

	public static void main(String args[]) {
		double gallons ,liters ;
		int count;
		
		count =0;
		for(gallons=1;gallons<=100;gallons++) {
			liters = gallons * 3.7;
			System.out.println(gallons + "gallons is " + liters + "liters. ");
			
			count ++;
			if ( count ==10) {
				System.out.println();
				count = 0;
				
			}
					
		}
		

	}
}
