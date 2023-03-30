package com.example.session;

public class Session {
//	public String substring(int startIndex)  // type - 1  


	public static void main(String[] args) {
		// declare and init words array with words
		String[] words = {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
		
		// declare and init for loop to count through all words in words array
		for (int i = 0; i < words.length; i++) {
			// check to see if words are at least 3 characters in length
			if (words[i].length() > 3) {
				// check to see if the last 3 characters of the word = "ing"
				if(words[i].substring(words[i].length()-3).equals("ing")){
					// print the whole word
					System.out.println(words[i]);					
				}
			}
		}
	}
}
