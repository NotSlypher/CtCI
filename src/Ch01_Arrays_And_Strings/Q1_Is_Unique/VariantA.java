package Ch01_Arrays_And_Strings.Q1_Is_Unique;

import java.util.HashMap;

public class VariantA {
    public static boolean isUnique(String str){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0; i < str.length(); ++i){
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(mp.get(str.charAt(i)) > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
}
