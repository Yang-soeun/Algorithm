import java.util.*;

/**
 * Group Anagrams
 */
public class Anagrams {
    public static int groupAnagrams(String[] strs){
        HashSet<String> set = new HashSet<>();
        int size = 0;
        String oldStr;
        String newStr;
        char[] chars;
        int k = 0;

        for(int i = 0; i<strs.length; i++){
            oldStr = strs[i];
            chars = oldStr.toCharArray();
            Arrays.sort(chars);
            newStr = new String(chars);

            if(!set.contains(newStr)){
                set.add(newStr);
            }
        }

        size = set.size();


        return size;
    }
    public static void main(String[] args) {
        String[] strs = {"inch", "cat", "chin", "kit", "act"};
        System.out.println(groupAnagrams(strs));
    }
}
