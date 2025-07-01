import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] table = new int[n][n];
        for (int i = 0; i < gifts.length; i++) {
            String[] pair = gifts[i].split(" ");
            int taker = -1, giver = -1;
            for (int j = 0; j < n; j++) {
                if (pair[0].equals(friends[j])) {
                    giver = j;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (pair[1].equals(friends[j])) {
                    taker = j;
                    break;
                }
            }
            if (giver == -1 || taker == -1) {
                System.out.println("err");
            }
            table[giver][taker]++;       
        }
        
        int[] degree = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                degree[i] += table[i][j] - table[j][i];
                degree[j] += table[j][i] - table[i][j];
            }
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