import java.util.*;

class Solution {
    
    static List<Character> list = new ArrayList<>();
    static int count = 0, ans = 0;
    static boolean bKeep = true;
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    
    void choose(int digit, String word) {
        if (digit > 5 || !bKeep) {
            
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            count++;
            
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            String strList = new String(sb);
            System.out.println(count + " : " + sb);
            if (strList.equals(word)) {
                ans = count;
                bKeep = false;
            }
            
            choose(digit + 1, word);
            list.remove(digit - 1);
        }
        
        
        
    }
    public int solution(String word) {
        int answer = 0;
        
        choose(1, word);
        answer = ans;
        return answer;
    }
}