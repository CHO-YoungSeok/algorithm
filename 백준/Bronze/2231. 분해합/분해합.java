import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	int divisonSum = sc.nextInt();
    	for(int c = 1; c < divisonSum; c++) {
    		int num = c;
    		ArrayList<Integer> list = new ArrayList<>();
    		while(0 < num) {
    			int currentNum = num % 10;
    			list.add(currentNum);
    			num /= 10;
    		}
    		int sum = c;
    		for(int i = 0; i < list.size(); i++) {
    			sum += list.get(i);
    		}
    		if(divisonSum == sum) {
    			System.out.println(c);
    			System.exit(0);
    		}
    	}
    	System.out.println(0);


    }
}