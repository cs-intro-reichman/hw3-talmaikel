/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		if (str1.length() != str2.length())   return false;
        
		String temp1 = preProcess(str1);
		String temp2 = preProcess(str2);
		

		char[] cTemp1 = new char[temp1.length()];
		char[] cTemp2 = new char[temp2.length()];

			for (int i = 0; i < temp1.length(); i++) {
				boolean checking1 = false;
				for (int j = 0; j < temp1.length(); j++) {
					if(cTemp1[i] == cTemp2[j] || cTemp1[i] != ' ' || cTemp2[j] != ' '){
						checking1 = true;
						cTemp1[i] = ' ';
						cTemp2[j] = ' ';
					
					} 
					if ( checking1 == false ) return false;
				}
			
			}

        return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String clean = "";
		char temp;
		for (int i = 0; i < str.length(); i++) {
		if(((int) str.charAt(i)) > 96 && ((int) str.charAt(i)) < 123 || str.charAt(i)==' '){
			clean += str.charAt(i);
		} else if(((int) str.charAt(i)) > 64 && ((int) str.charAt(i)) < 91){
			temp = (char) ((int)str.charAt(i) + 32); 
			clean += ((char) temp);
		} 
	}
	return clean;
}
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String mixed = "";
		char[] toMixed = new char[str.length()];
		for (int i = 0; i < str.length(); i++) toMixed[i] = ' ';

	
		for (int i = 0; i < str.length(); i++) {
			int j = (int) (Math.random() * str.length());
			if(toMixed[j] == ' '){
				toMixed[j] = str.charAt(i);
			}
		}
		for (int i = 0; i < str.length(); i++) mixed += toMixed[i];
		
		
		return mixed;
	}
}
