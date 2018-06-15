package by.htp.string.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAction {

	public static final String END_WORD_REGEX = "(?:\\W|$)";
	public static final String NON_EN_LETTERS_OR_SPACE_REGEX = "[^a-zA-Z ]";
	public static final String ANY_EN_WORD_REGEX = "[a-zA-z]+";
	public static final String START_STR_OR_NON_EN_LETTER_REGEX = "(?:^|[^a-zA-Z])";
	public static final String NON_EN_LETTERS_REGEX = "[^a-zA-z]";

	public static String addSubstringAfterEachNumChar(String str, int num, String stringToAdd) { // variant A, task 4
		int i = 0;
		while (i + num <= str.length()) {
			str = (String) str.subSequence(0, i + num) + stringToAdd + (String) str.subSequence(i + num, str.length());
			i = i + num + 1;
		}

		return str;
	}

	public static String addSubstringAfterEachNumCharWithBuilder(String str, int num, String stringToAdd) {
		StringBuilder sbT = new StringBuilder(str);
		for (int i = 0; i + num < sbT.length(); i = i + num + 1) {
			sbT.insert(i + num, stringToAdd);
		}
		return sbT.toString();
	}

	public static String addStringAfterEachWordEndingWithSubstring(String str, String substring, String stringToAdd) {
		StringBuilder sbT = new StringBuilder(str);
		Pattern p = Pattern.compile(substring + END_WORD_REGEX);
		Matcher m = p.matcher(sbT);
		int start = 0;
		while (m.find(start)) {
			sbT.insert(m.end() - 1, stringToAdd);
			start = m.start() + stringToAdd.length();
		}
		return sbT.toString();
	}

	public static String deleteNonLettersAndAddSpacesAfterEverySymbol(String str) {
		StringBuilder sbT = new StringBuilder(str);
		deleteNonLetters(sbT);
		addSpacesAfterEverySymbol(sbT);
		return sbT.toString();
	}

	private static void deleteNonLetters(StringBuilder sbT) {
		Pattern p = Pattern.compile(NON_EN_LETTERS_OR_SPACE_REGEX);
		Matcher m = p.matcher(sbT);
		int start = 0;

		while (m.find(start)) {
			sbT.replace(m.start(), m.end(), "");
			start = m.start();
		}
	}

	private static void addSpacesAfterEverySymbol(StringBuilder sbT) {
		for (int i = 1; i < sbT.length(); i += 2) {
			sbT.insert(i, " ");
		}
	}

	public static void showPairsUniqueWordsAndCounts(String str) {
		StringBuilder sbT = new StringBuilder(str);
		String[] allWords = extractAllWords(sbT);
		String[] uniqueWords = extractUniqueWords(allWords);
		int[] numberRepeatedWords = countNumberOfRepeatesUniqueWords(allWords, uniqueWords);

		for (int i = 0; i < uniqueWords.length; i++) {
			System.out.println(
					"Word \"" + uniqueWords[i].toLowerCase() + "\" - number of repeats = " + numberRepeatedWords[i]);
		}
	}

	private static String[] extractUniqueWords(String[] originalAllWords) {
		String[] allWords = originalAllWords.clone();
		int k = 1;
		for (int i = 0; i < allWords.length; i++, k++) {
			for (int j = k; j < allWords.length; j++) {
				if (allWords[i] != null && allWords[j] != null && allWords[i].equalsIgnoreCase(allWords[j])) {
					allWords[j] = null;
				}
			}
		}

		int counter = 0;
		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i] != null) {
				counter++;
			}
		}

		String[] uniqueWords = new String[counter];
		int j = 0;

		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i] != null) {
				uniqueWords[j] = allWords[i];
				j++;
			}
		}

		return uniqueWords;
	}

	private static String[] extractAllWords(StringBuilder sbT) {
		Pattern p = Pattern.compile(ANY_EN_WORD_REGEX);
		Matcher m = p.matcher(sbT);
		List<String> allWords = new ArrayList<>();
		while (m.find()) {
			allWords.add(m.group());
		}
		String[] words = allWords.toArray(new String[0]);

		return words;
	}

	private static int[] countNumberOfRepeatesUniqueWords(String[] allWords, String[] uniqueWords) {
		int[] repeates = new int[uniqueWords.length];
		for (int i = 0; i < uniqueWords.length; i++) {
			repeates[i] = countRepeates(allWords, uniqueWords[i]);
		}
		return repeates;
	}

	private static int countRepeates(String[] allWords, String word) {
		int count = 0;
		for (int i = 0; i < allWords.length; i++) {
			if (word.equalsIgnoreCase(allWords[i])) {
				count++;
			}
		}
		return count;
	}

}
