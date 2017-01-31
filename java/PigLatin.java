import java.util.regex.Pattern;

public class PigLatin {

	public String translate(String str) {
		// 3) The result must be lowercase, regardless of the case of the input.
		// If the input string has any non-alpha characters, the function must
		// return None, null, Nothing (depending on the language).

		// 4) The function must also handle simple random strings and not just
		// English words.
		str = str.toLowerCase();
		if (Pattern.matches(".*[^a-z]+.*", str)) {
			return null;
		}

		if (Pattern.matches("^[aeiou].*", str)) {
			// 1) The word starts with a vowel(a,e,i,o,u) -> return the original
			// string plus "way".
			return str + "way";
		} else if (!Pattern.matches("^[aeiou].*", str)) {
			// 5) The input string has no vowels -> return the original string plus
			// "ay".
			if (!Pattern.matches(".*[aeiou]+.*", str)) {
				return str + "ay";
			}
			
			// 2) The word starts with a consonant -> move consonants from the
			// beginning of the word to the end of the word until the first
			// vowel,
			// then return it plus "ay".
			while (!Pattern.matches("^[aeiou].*", str)) {
				str = str.substring(1) + str.charAt(0);
			}
			return str + "ay";
		}
		
		return null;
	}

}