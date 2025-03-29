import java.util.*;


public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();

    	while(0 <T--) {
	    	String c = sc.next();
	    	int p = sc.nextInt();
	    	String str = sc.next();
	    	str = str.substring(1, str.length() -1);

	    	String[] tokens = str.split(",");
	    	ArrayList<Integer> list = new ArrayList<>(p);

	    	for(int i = 0; i < p; i++) {
	    		list.add(Integer.parseInt(tokens[i]));
	    	}

	    	
	    	boolean bIsErr = false;
	    	boolean bIsReverse = false;

	    	for(int i = 0; i < c.length(); i++) {

	    		if(c.charAt(i) == 'R') {
	    			// System.out.println("R");
	    			bIsReverse = !bIsReverse;
	    		}
	    		else if(c.charAt(i) == 'D') {
	    			// System.out.println("D");
	    			if(list.size() == 0) {
	    	    		System.out.println("error");
	    	    		bIsErr = true;
	    	    		break;				
	    			}
	    			if(bIsReverse) {
	    				list.remove(list.size() - 1);
	    			} else {
	    				list.remove(0);
	    			}
	    		}

	    	}

	    	if(bIsErr) {
	    		continue;
	    	}
			StringBuffer result = new StringBuffer("[");

	    	if(bIsReverse) {
	    		for(int i = list.size() -1; 0 <= i; i--) {
	    			if(i != 0)
	    				result.append(list.get(i) + ",");
	    			else 
	    				result.append(list.get(i));
	    		}
	    	} else {
	    		for(int i = 0; i < list.size(); i++) {
	    			if(i != list.size() -1)
	    				result.append(list.get(i) + ",");
	    			else 
	    				result.append(list.get(i));
	    		}
	    	}
	    	result.append("]");

	    	System.out.println(result);
	    	
	    	// System.out.print("[");
	    	// if(bIsReverse) {
	    	// 	for(int i = list.size() -1; 0 <= i; i--) {
	    	// 		if(i != 0)
	    	// 			System.out.print(list.get(i) + ",");
	    	// 		else 
	    	// 			System.out.print(list.get(i));
	    	// 	}
	    	// } else {
	    	// 	for(int i = 0; i < list.size(); i++) {
	    	// 		if(i != list.size() - 1)
	    	// 			System.out.print(list.get(i) + ",");
	    	// 		else 
	    	// 			System.out.print(list.get(i));
	    	// 	}
	    	// }
	    	// System.out.println("]");


    	}
    }
}

