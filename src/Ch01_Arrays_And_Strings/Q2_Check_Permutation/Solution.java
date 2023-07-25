package Ch01_Arrays_And_Strings.Q2_Check_Permutation;

import java.util.HashMap;

public class Solution {

    public static boolean CheckPermutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> mp1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            mp.put(str1.charAt(i), mp.getOrDefault(str1.charAt(i), 0) + 1);
            mp1.put(str2.charAt(i), mp1.getOrDefault(str2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str1.length(); i++) {
            if(mp.getOrDefault(str1.charAt(i), 0) != mp1.getOrDefault(str1.charAt(i), 0)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = CheckPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

}
