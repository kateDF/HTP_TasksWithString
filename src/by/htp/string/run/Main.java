package by.htp.string.run;

import by.htp.string.logic.StringAction;

public class Main {

	public static void main(String[] args) {

		// p.194 - variant A, task 4 (I.Blinov - Java methods of programming)
		int num = 5;
		String str1 = "Add substring after each " + num + " characters.";
		String stringToAdd1 = "**";

		String str1Result = StringAction.addSubstringAfterEachNumChar(str1, num, stringToAdd1);

		System.out.println(str1Result);

		String str1ByBuider = StringAction.addSubstringAfterEachNumCharWithBuilder(str1, num, stringToAdd1);

		System.out.println(str1ByBuider);

		// variant A, task 5
		String substring = "rds";
		String str2 = "After each words in the text, ending with specified substring (example: " + substring
				+ "), insert some words.";

		String stringToAdd2 = " (add smth)";

		String str2Result = StringAction.addStringAfterEachWordEndingWithSubstring(str2, substring, stringToAdd2);

		System.out.println(str2Result);

		// variant A task 7

		String str3 = "Delete all characters (except spaces) that are not letters. For example: numbers 5,7,8,9 and "
				+ "punctuation marks - &* > ,. And should be at least one space between the letters.";

		String str3Result = StringAction.deleteNonLettersAndAddSpacesAfterEverySymbol(str3);
		System.out.println(str3Result);

		System.out.println();

		// variant A task 9
		String str4 = "Detirminate how many times each word is repeated in the text. "
				+ "Example. Word 'word' is repeated several times in the text. "
				+ "And aa aa aa aa aa aa some others words are repeated several times in the text too.";
		System.out.println(str4);
		StringAction.showPairsUniqueWordsAndCounts(str4);

	}

}
