import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int m = sc.nextInt();
        int n = sc.nextInt();
        int max = Math.max(m, n);
        int min = Math.min(m, n);

        while(min != 0) {
            int r = max  % min;
            max = min;
            min = r;
        }
        System.out.println(max);
        System.out.println(m / max * n);
    }
}

