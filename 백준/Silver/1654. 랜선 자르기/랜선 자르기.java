import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] lines = new int[k];
        long min = 1; // 최소 길이는 1부터 시작
        long max = 0;
        for(int i = 0; i < k; i++) {
            lines[i] = sc.nextInt();
            if (lines[i] > max) {
                max = lines[i]; // 최대 길이를 업데이트 (long 타입으로 자동 변환)
            }
        }

        long result = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for(int i = 0; i < k; i++) {
                count += lines[i] / mid;
            }

            if(count >= n) {
                result = mid; // 조건을 만족하는 경우, 더 긴 길이도 가능한지 탐색
                min = mid + 1;
            } else {
                max = mid - 1; // 필요한 개수보다 적으면, 더 짧은 길이로 탐색
            }
        }

        System.out.println(result);
    }
}