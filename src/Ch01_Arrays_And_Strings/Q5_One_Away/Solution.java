package Ch01_Arrays_And_Strings.Q5_One_Away;

import java.util.HashMap;

public class Solution {
    static boolean OneAway(String str, String str1){

        if(str.length() < str1.length()){
            String temo = str;
            str = str1;
            str1 = temo;
        }

        boolean oneDiff = false;
        if(str.length() == str1.length()){
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != str1.charAt(i)){
                    if(oneDiff) return false;
                    oneDiff = true;
                }
            }
        }
        else{
            for (int i = 0; i < str.length(); i++) {
                if(i == str1.length()) break;
                if(oneDiff){
                    if(str.charAt(i) != str1.charAt(i - 1)) return false;
                }
                else if (str.charAt(i) != str1.charAt(i)) oneDiff = true;
            }
        }
        return true;
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = OneAway(a, b);

        if (resultA == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }
}
