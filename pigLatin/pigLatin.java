package pigLatin;

import java.util.Scanner;

public class pigLatin {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		int vowelPosition;
		String cont = "y", userInput = "", userPigWord = "";
		String wordStartsVowel = "", wordBeforeVowel = "";
		
//		int wordCount;
		
		System.out.println("Welcome to the Pit Latin Translator!");
		
//		System.out.println("Please enter your name:");
//		String userName = scnr.next();
		
		do {
			System.out.println("\nEnter a word to be translated:");
			userInput = scnr.next();
			
			//change string into lower case
			userInput = userInput.toLowerCase();
			// System.out.println(userInput); - tested conversion 
			
			
			//determine number of words by searching for breaks
			int characters = userInput.length();
			//System.out.println(characters); - tested characters working
			Boolean specialChar = findSpecialChar(characters, userInput);
			// System.out.println(specialChar);
			if (specialChar) {
				System.out.println(userInput + " can not be converted to Pig Latin.");
			}
			else {
			// find first vowel by calling method
				vowelPosition = findVowel(characters, userInput);
				// System.out.println(vowelPosition); - used for debugging
						
				//translate to Pig Latin, start by seeing if word starts with a vowel
					if (vowelPosition == 0) {
						System.out.println(userInput + "way");
					} //must start with a consonant
					else if (vowelPosition == 9) {
						System.out.println("Not a valid English word");
					}
					else {
						wordStartsVowel = userInput.substring(vowelPosition);
						wordBeforeVowel = userInput.substring(0, vowelPosition);
						System.out.println(wordStartsVowel + wordBeforeVowel + "ay");
					}
				}	
			System.out.print("\nTranslate another word? (y/n): ");
			cont = scnr.next();
		}
		while (cont.equals("y"));
		
		System.out.println("yebay!");	
	}

public static int findVowel(int characters, String userInput) {
	
	int vowelPosition = 0;	
	for (int i = 0; i <= (characters - 1); i++) {
	// System.out.println("for loop started"); - used for debugging
		if (userInput.substring(i, i + 1).equals("a")) {
			vowelPosition = (i);
			break;
		}
		else if (userInput.substring(i, i + 1).equals("e")) {
			vowelPosition = (i);
			break;
		}
		else if (userInput.substring(i, i+ 1).equals("i")) {
			vowelPosition = (i);
			break;
		}
		else if (userInput.substring(i, i + 1).equals("o")) {
			vowelPosition = (i);
			break;
		}
		else if (userInput.substring(i, i + 1).equals("u")) {
			vowelPosition = (i);
			break;
		}
		else {
			vowelPosition = 9;
		}
	}
	return vowelPosition;
}

public static Boolean findSpecialChar(int characters, String userInput) {

	Boolean specialExists = false;
	
	for (int i = 0; i <= (characters - 1); i++) {
	// System.out.println("for loop started"); - used for debugging
		if (userInput.substring(i, i + 1).equals("@")) {
			specialExists = true;
			break;
		}
		else {
			for (int x = 0; x <= 9; x++) {
				if (userInput.substring(i, i + 1).equals(Integer.toString(x))) {
					specialExists = true;
					break;
				}
			}
		}
	}
	return specialExists;	
}
}
