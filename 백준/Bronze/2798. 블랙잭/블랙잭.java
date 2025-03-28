import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int m, n, max;


    public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		List<Integer> cards = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			cards.add(sc.nextInt());
		}

		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					sum = cards.get(i) + cards.get(j) + cards.get(k);
					if(sum <= m) {
						max = Math.max(sum, max);
					}
					
				}
			}
		}

		System.out.println(max);
    }
}