package Ch01_Arrays_And_Strings.Q1_Is_Unique;



public class VariantB {
    // without using extra space / extra data structure

    public static boolean isUnique(String str){
        int bitChecker = 0;
        for(int i = 0; i < str.length(); ++i){
            int val = str.charAt(i) - 'a';
            if((bitChecker & (1 << val)) > 0){
                return false;
            }
            bitChecker |= (1 << val);
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
