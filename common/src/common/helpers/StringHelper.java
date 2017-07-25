package common.helpers;

/**
 * Created by Logan.Moen on 6/1/2017.
 */
public class StringHelper extends CommonHelper{
    // Note:  Checks a string returns true if string is null or empty
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    // Note:  Counts words in a string
    public static int wordCount(String s) {
        int wordcount = 1;
        for(char c : s.toCharArray())
        if (c == ' '){
            wordcount++;
        }
        return wordcount;
    }

    // Note: inserts hyphens between all characters in a String
    public static String hyphenAllChars(String s) {
        StringBuilder hyphenedString = new StringBuilder();
        for(char c : s.toCharArray()) {
            hyphenedString.append(Character.toString(c));
            hyphenedString.append(Character.toString('-'));
        }
        hyphenedString.deleteCharAt(hyphenedString.toString().lastIndexOf('-'));
        return hyphenedString.toString();
    }

    public static String underscoreSpaces(String s) {
        StringBuilder underscoreSpaces = new StringBuilder(s);
        for(char c : s.toCharArray()) {
            if (c == ' ')
            underscoreSpaces.setCharAt(underscoreSpaces.toString().indexOf(c), '_');

        }
        return underscoreSpaces.toString();
    }

    // Note:
}
