package Ch01_Arrays_And_Strings.Q3_URLify;

public class Solution {
    static char[] Urlify(char[] str, int trueLength){
        int spCnt = 0;
        for (int i = 0; i < trueLength; i++) {
            if(str[i] == ' '){
                spCnt++;
            }
        }
        int x = trueLength - 1, j;
        for(int i = trueLength - 1; i >= 0; --i){
            if (spCnt == 0) break;
            if(str[i] == ' '){
                for(j = x; j > i; --j){
                    str[j + 2 * spCnt] = str[j];
                }
                j += 2 * spCnt;
                str[j] = '0';
                str[j - 1] = '2';
                str[j - 2] = '%';
                spCnt--;
                x = i - 1;
            }
        }
        return str;
    }

    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String str = "M r John Smith      ";
        char[] arr = str.toCharArray();
//        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, 14);
        System.out.println("\"" + new String(arr) + "\"");
    }
}
