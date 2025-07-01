import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int[] degree = new int[n];
        int[][] table = new int[n][n];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] pair = gifts[i].split(" ");
            int giver = map.get(pair[0]);
            int taker = map.get(pair[1]);
            table[giver][taker]++;
            degree[giver]++;
            degree[taker]--;
        }

        int[] thisMonth = new int[n];        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (table[i][j] > table[j][i]) {
                    thisMonth[i]++;
                } else if (table[i][j] < table[j][i]) {
                    thisMonth[j]++;
                } else {
                    if (degree[i] > degree[j]) {
                        thisMonth[i]++;
                    } else if (degree[i] < degree[j]) {
                        thisMonth[j]++;
                    } else {
                        continue;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, thisMonth[i]);
        }
        answer = max;
        return answer;
    }
}