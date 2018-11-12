package chap2;

public class Prime { 
	
	static boolean isPrime( int n) {
		
		//corner cases 
		if ( n<= 1) return false;
		if (n<=3) return true; 
		
		for (int i= 2; i*i <= n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}

}
