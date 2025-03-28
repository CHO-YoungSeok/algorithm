import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	int s, m, l, xl, xl2, xl3, xl4, n;

    	n = sc.nextInt();

    	s = sc.nextInt();
    	m = sc.nextInt();
    	l = sc.nextInt();
    	xl = sc.nextInt();
    	xl2 = sc.nextInt();
    	xl3 = sc.nextInt();

    	int t, p;
    	t = sc.nextInt();
    	p = sc.nextInt();

    	int minT = 0, bundP = 0, singleP = 0;


    	minT += (s%t == 0) ? s/t : s/t+1;
    	minT += (m%t == 0) ? m/t : m/t+1;
    	minT += (l%t == 0) ? l/t : l/t+1;
    	minT += (xl%t == 0) ? xl/t : xl/t+1;
    	minT += (xl2%t == 0) ? xl2/t : xl2/t+1;
    	minT += (xl3%t == 0) ? xl3/t : xl3/t+1;

    	bundP = n / p;
    	singleP = n % p;

    	System.out.println(minT);
    	System.out.println(bundP + " " + singleP);





    }
}