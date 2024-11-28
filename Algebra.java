// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(-1,1));   // 2 + 3
	  // System.out.println(minus(1,2));  // 7 - 2
   		//System.out.println(minus(0,4));  // 2 - 7
 		//System.out.println(times(0,-1));  // 3 * 4
   	//	System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   	//	System.out.println(pow(4,-2));      // 5^3
   	//	System.out.println(pow(3,5));      // 3^5
   	//	System.out.println(div(-24,-7));   // 12 / 3    
   	//	System.out.println(div(5,5));    // 5 / 5  
   	//	System.out.println(div(25,7));   // 25 / 7
   	//	System.out.println(mod(-25,7));   // 25 % 7
   		//System.out.println(mod(122,6));  // 120 % 6    
   	//	System.out.println(sqrt(36));
	//	System.out.println(sqrt(263169));
   	// System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
	if(x1 >= 0){
		if(x2 >= 0){
		for (int i = 0; i < Math.abs(x2); i++) {
			x1++;
	} 
			}else {
			for (int i = 0; i < Math.abs(x2); i++) {
				x1--;
			}
		} 
		return x1;
	} else {
		if(x2 > 0){
			for (int i = 0; i < Math.abs(x1); i++) {
				x2--;
		} 
				}else {
				for (int i = 0; i < Math.abs(x1); i++) {
					x2--;
				}
			} 
			return x2;
	}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x1 >= 0){
			if(x2 >= 0){
			for (int i = 0; i < Math.abs(x2); i++) {
				x1--;
		} 
				}else {
				for (int i = 0; i < Math.abs(x2); i++) {
					x1++;
				}
			} 
			return x1;
		} else {
			if(x2 > 0){
				for (int i = 0; i < Math.abs(x2); i++) {
					x1--;
			} 
					}else {
					for (int i = 0; i < Math.abs(x2); i++) {
						x1++;
					}
				} 
				return x1;
		}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int temp = 0;
		for (int i = 0; i < Math.abs(x2); i++) {
			temp= plus(temp,Math.abs(x1));
		}
			if((x1>0 && x2>0) || (x1<0 && x2<0)){
			return temp;
			}else {
				return minus(0, temp);
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int newNum = 1;
		if(n==0){
			return 1;
		} else if (n > 0){
			for (int i = 0; i < n; i++) {
				newNum = times(newNum, x);
			} 
			return newNum;	
		} else {
			return 0;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if((x2 > 0 && x1 > 0) || (x2 < 0 && x1 < 0) ){
		if(Math.abs(x1)>=Math.abs(x2)){
			for (int i = 1; i < Math.abs(x1); i++) {
				if(times(Math.abs(x2),i) >= Math.abs(x1) || times(Math.abs(x2),i+1) > Math.abs(x1)){
					return i;
				} 	
			}
		} else {
			return 0;
			} 
	} else {
		if(Math.abs(x1)>=Math.abs(x2)){
			for (int i = 1; i < Math.abs(x1); i++) {
				if(times(Math.abs(x2),i) >= Math.abs(x1) || times(Math.abs(x2),i+1) > Math.abs(x1)){
					return minus(0,i);
				} 	
	}
	} 
	} 
	return 0;
} 
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1>0) {
		return (x1-(times(x2, div(x1, x2))));
		}
		else {
			return minus(0,(x1-(times(x2, div(x1, x2)))));
		}
	} 

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		boolean stopper = true;
		int save = 0;
		if(x==1){
			return 1;
		}
		for (int i = 0; i < x && stopper ; i++) {
			if((pow(i,2)) >= x ) {
				stopper= false;
				save = i ;
			}

		}
		if((pow(save,2)) > x){
		return save-1;
	} else {
		return save;
	}

	}	  	  
}