import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	HashSet<Integer> set = new HashSet<>();

    	int m = sc.nextInt();
    	String command;
    	StringBuffer sb = new StringBuffer("");

    	while(0 < m--) {
    		command = sc.next();
    		if(command.equals("add")) {
    			set.add(sc.nextInt());

    		} else if(command.equals("remove")) {
    			set.remove(sc.nextInt());

    		} else if(command.equals("check")) {
    			
    			if(set.contains(sc.nextInt())) {
    				sb.append("1\n");
    			} else {
    				sb.append("0\n");
    			}
    			
    		} else if(command.equals("toggle")) {
    			int num = sc.nextInt();
    			if(set.contains(num)) {
    				set.remove(num);
    			} else {
    				set.add(num);
    			}
    			
    		} else if(command.equals("all")) {
    			set.clear();
    			for(int i = 1; i <= 20; i++){
    				set.add(i);
    			}    			
    		} else if(command.equals("empty")) {
    			set.clear();
    			
    		} else {

    		}

    	}


    	System.out.println(sb.toString());


    }
}

