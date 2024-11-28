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
		String string1 = preProcess(str1);
        String string2 = preProcess(str2);
        Boolean checker = false;
        String newString1 = "";
        String newString2 = "";
        for(int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != ' ') {
                newString1 += string1.charAt(i);
            }
        } for(int i = 0; i < string2.length(); i++) {
            if (string2.charAt(i) != ' ') {
                newString2 += string2.charAt(i);
            }
        }
        if (newString1.length() != newString2.length()) {
            return false;
        }
        for (int i = 0; i < newString1.length(); i++) {
            checker = false;
            for (int j = 0; j < newString2.length(); j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    checker = true;
                    string2 = string2.substring(0, j) + string2.substring(j + 1);
                    break;
                }
            }
            if (checker == false) {
                return false;
            }
        }
        return true;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String clean = "";
		char ch;
    for (int i = 0; i < str.length(); i++) {
        ch = str.charAt(i);
        int intChar = (int) ch;
        if ((intChar >= 65 && intChar <= 90)) { 
            clean += (char) (intChar + 32); 
        } else if (intChar >= 97 && intChar <= 122) { 
            clean += ch; 
        } else if (intChar == ' ') {
			clean += ch; 
		}
      
    }
    return clean;
}
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

        String cleaString = "";
		String tempString = preProcess(str);

        while (tempString .length() > 0) {
            int tmp_index = (int) (tempString .length() * Math.random());

            cleaString += tempString .charAt(tmp_index);
            tempString  = tempString .substring(0, tmp_index) + tempString .substring(tmp_index + 1, tempString .length());

        }

        return cleaString;
	}
    }

