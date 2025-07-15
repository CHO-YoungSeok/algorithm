class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE;
        int stIdx = 0, endIdx = 0;
        int sum = 0;
    
        while (endIdx < sequence.length) {
            sum += sequence[endIdx];
            
            while (sum > k && stIdx <= endIdx) sum -= sequence[stIdx++];
            
            if (sum == k && endIdx - stIdx < minLen) {
                minLen = endIdx - stIdx;
                answer[1] = endIdx;
                answer[0] = stIdx;
            }
            
            endIdx++;
        }
        
        
        return answer;
    }
}