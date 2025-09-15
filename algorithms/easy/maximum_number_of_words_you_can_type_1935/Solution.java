package algorithms.easy.maximum_number_of_words_you_can_type_1935;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] isBroke = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) {
            isBroke[ch - 'a'] = true;
        }

        int count = 0;
        int i = 0;
        int n = text.length();

        while (i < n) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                count++;
            } else if (isBroke[ch - 'a']) {
                // דלג על כל המילה כי יש בה אות שבורה
                while (i < n && text.charAt(i) != ' ') {
                    i++;
                }
            } else if (i == n - 1) {
                // אם זה התו האחרון והוא לא שבור – נספור את המילה
                count++;
            }
            i++;
        }

        return count;
    }
}
