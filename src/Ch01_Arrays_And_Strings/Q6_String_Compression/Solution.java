package Ch01_Arrays_And_Strings.Q6_String_Compression;

public class Solution {
    static String StringCompression(String str){
        StringBuilder comp = new StringBuilder();
        if(str.length() == 0) return str;
        comp.append(str.charAt(0));
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)){
                cnt++;
            }
            else{
                if(cnt > 1){
                    comp.append(cnt);
                }
                comp.append(str.charAt(i));
                cnt = 1;
            }
        }
        if(comp.length() == str.length()) return str;
        return comp.toString();
    }

    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddc";
        System.out.println(str);
        System.out.println(StringCompression(str));
    }
}
