// Pattern Matching Problem using Exhaustive Search
// This example finds all occurrences of a pattern in a given text.
public class PatternMatching {
    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        exhaustivePatternMatch(text, pattern);
    }

    public static void exhaustivePatternMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = false;
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pattern not found");
        }
    }
}
