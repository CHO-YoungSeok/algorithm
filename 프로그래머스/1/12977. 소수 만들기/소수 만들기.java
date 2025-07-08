class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean bPrime = true;
                    for (int n = 2; n < sum / 2 + 1; n++) {
                        if (sum % n == 0) {
                            bPrime = false;
                        }
                    }
                    if (bPrime) {
                        System.out.println(count + ": " + i + " " + j + " " + k + " = " + sum);
                        count++;
                    }
                }
            }
        }
        answer = count;
    
        return answer;
    }
}