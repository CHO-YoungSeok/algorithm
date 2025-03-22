import java.util.*;

// The main method must be in a class named "Main".
class Main {

    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int dis = y -x;
            int maxSqrt = (int)Math.sqrt(dis);
            int remain = dis - maxSqrt * maxSqrt;
            int add = 0;
            while(remain > 0) {
                remain -= maxSqrt;
                add++;
            }

            System.out.println(maxSqrt + maxSqrt - 1 + add);
        }
    }
}