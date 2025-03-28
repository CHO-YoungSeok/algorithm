import java.util.*;
 
public class Main {	
	public static void main(String[] args) {
    
		// Scanner sc = new Scanner(System.in);

		// long mn = sc.nextLong(), mx = sc.nextLong();
		// int count = 0;
		// for(long i = mn; i <= mx; i++) {
		// 	int iSqrt = (int)Math.sqrt((double)i);
		// 	for(int j = 2; j <= iSqrt; j++) {
		// 		if(i % (j*j) == 0) {
		// 			count++;
		// 			break;
		// 		}
		// 	}
		// }


		// System.out.println(mx - mn - count + 1);



		Scanner sc = new Scanner(System.in);
		long mn = sc.nextLong(), mx = sc.nextLong();
		boolean[] bIsSquare = new boolean[(int)(mx - mn + 1)];
		Arrays.fill(bIsSquare, false);

		for(long i = 2; i * i <= mx; i++) {
			long square = i * i;
			long start = ((mn + square - 1) / square) *  square;
			for(long j = start; j <= mx; j += square) {
				bIsSquare[(int)(j - mn)] = true;
			}
		}

		int count = 0;
		for(boolean e : bIsSquare) {
			if(e == false) count++;
		}
		System.out.println(count);


	}
}
