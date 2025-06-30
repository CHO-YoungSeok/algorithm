class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        answer = n;
        for (int i = 0; i < n; i++) {
            int scheduleH = schedules[i] / 100;
            int scheduleM = schedules[i] % 100;
            scheduleM += 10;
            if (scheduleM >= 60) {
                scheduleH++;
                scheduleM %= 60;
            }
            int savingTime = scheduleH * 100 + scheduleM;
            
            for (int day = 0; day < 7; day ++) {
                if ((day + startday) % 7 == 6 || (day + startday) % 7 == 0) {
                    continue;
                }
                
                if (savingTime < timelogs[i][day]) {
                    answer--;
                    System.out.println(savingTime + " : " + timelogs[i][day]  + " " + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}