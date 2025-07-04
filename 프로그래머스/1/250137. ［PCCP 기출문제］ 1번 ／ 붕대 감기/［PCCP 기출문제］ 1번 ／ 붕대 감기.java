import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int  i = 0; i < attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
        }
        
        
        int hp = health;
        int healDuration = 0;
        for (int t = 0; t <= attacks[attacks.length - 1][0]; t++) {
            
            if (map.containsKey(t)) {
                hp -= map.get(t);
                healDuration = 0;

            } else {
                hp += bandage[1];
                healDuration++;
                if (healDuration >= bandage[0]) {
                    hp += bandage[2];
                    healDuration = 0;
                }
        }
            if (hp > health) {
                hp = health;
            }
            if (hp <= 0) {
                return -1;
            }


            System.out.println(t + ": " + hp);
        }
        
        answer = hp;
        return answer;
    }
}