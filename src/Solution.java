import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isUnique(String astr) {
        // 方法一：计算唯一字符数
        return astr.chars().distinct().count() == astr.length();

        // 方法二：bool 数组
        /*
        int[] chars = new int[26];
        for(int i=0;i<astr.length();i++) {
            int c = astr.charAt(i)-'a';
            if(chars[c]==1){
                return false;
            }
            else{
                chars[c]=1;
            }
        }
        return true;
        */

        // 方法三： indexOf 和 lastIndexOf 时间复杂度 O(n)
        /*
        for(int i=0;i<astr.length();i++){
            char c = astr.charAt(i);
            if(astr.indexOf(c) != astr.lastIndexOf(c)){
                return false;
            }
        }
        return true;
        */


        // 方法四： 双指针，时间复杂度 O(n^2)
        /*
        String temp = "";
        for(char c:str.toCharArray()){
            if(temp.indexOf(c)>-1) {
                return false;
            }
            else{
                temp += c;
            }
        }
       */

    }

    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");

        if (chars.length != words.length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) return false;
            } else {
                if (map.containsValue(words[i])) return false;
                map.put(c, words[i]);
            }
        }

        return true;

    }

        public String getHint(String secret, String guess) {
        // 方法一：一个循环即可
        int bulls = 0;
        int cows = 0;
        int[] temp = new int[10];

        char[] guesses = guess.toCharArray();

        for (int i = 0; i < guesses.length; i++) {
            int guessNumber = guesses[i]-'0';
            int secretNumber = secret.charAt(i)-'0';
            if (guessNumber == secretNumber) {
                bulls++;
            }
            else{
                if(temp[guessNumber]<0) cows++;
                if(temp[secretNumber]>0) cows++;
                temp[guessNumber]++;
                temp[secretNumber]--;
            }
        }

        return bulls + "A" + cows + "B";

        // 方法二：创建两个数组分别统计
        /*
        int bulls = 0, cows = 0;
        char[] chars = guess.toCharArray();
        int[] secrets = new int[10];
        int[] guesses = new int[10];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == secret.charAt(i)) {
                bulls++;
            } else {
                guesses[chars[i] - '0']++;
                secrets[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (secrets[i] > 0 && guesses[i] > 0) {
                cows = secrets[i] > guesses[i] ? guesses[i] : secrets[i];
            }
        }
        return bulls + "A" + cows + "B";
        */
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // isUnique
        /*
        String str = "abacdef";
        boolean isUnique = solution.isUnique(str);
        System.out.println(isUnique);
        */

        // wordPattern
        /*
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean flag = solution.wordPattern(pattern, str);
        System.out.println(flag);
        */

        // getHint
        /*
        String secret = "1807";
        String guess ="7810";
        */
        String secret = "1123";
        String guess = "0111";
        String hint = solution.getHint(secret, guess);
        System.out.println(hint);
    }
}
