package Ch01_Arrays_And_Strings.Q4_Palindrome_permutation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static boolean isPermutationOfPalindrome(String str){
        str = str.toLowerCase();
            int len = 0;
            HashMap<Character, Integer> mp = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) != ' ') {
                    len++;
                    mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0) + 1);
                }
            }
            int oddAllowed = 0, o = 0;
            if(len % 2 == 1) oddAllowed = 1;
            for(Map.Entry<Character, Integer> entry : mp.entrySet()){
                if(entry.getValue() % 2 == 1) o++;
            }
            return o <= oddAllowed;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda",
                "Tact Coa"};
        for (String s : strings) {
            System.out.println(s + ": " + isPermutationOfPalindrome(s));
        }

    }
}
