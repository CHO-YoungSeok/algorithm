import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> keyName = new HashMap<>();
        HashMap<Integer, String> keyRank = new HashMap<>();
        
        for (int i = 1; i < players.length + 1; i++) {
            keyRank.put(i, players[i - 1]);
            keyName.put(players[i - 1], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int rank = keyName.get(callings[i]);
            String name = keyRank.get(rank);
            int tempRank = rank - 1;
            String tempName = keyRank.get(rank - 1);
            keyName.put(name, tempRank);
            keyRank.put(tempRank, name);
            keyName.put(tempName, rank);
            keyRank.put(rank, tempName);         
        }        
        
        String[] answer = new String[players.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = keyRank.get(i+1);
            // System.out.println(i + 1 + " " + answer[i]);
        }
        
        return answer;
    }
}