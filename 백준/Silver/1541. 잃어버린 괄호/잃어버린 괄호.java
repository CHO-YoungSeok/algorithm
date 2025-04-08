import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String str = sc.next();
          int status = 0; // 0: sum, 1: minus
          ArrayList<Integer> sumNums = new ArrayList<>();
          ArrayList<Integer> minusNums = new ArrayList<>();

          for(int i = 0; i < str.length(); i++) {
               List<Integer> currNums = new ArrayList<>();
               while(i < str.length() && str.charAt(i) != '+' && str.charAt(i) != '-') {
                    currNums.add(Integer.parseInt("" + str.charAt(i++)));
               }
               if(i == str.length()) {
                    int cNum = 0;
                    for(int d = currNums.size() -1; 0 <= d; d--) {
                         cNum += currNums.get(d) * Math.pow(10, currNums.size() -1 - d);
                    }
                    switch(status) {
                    case 0:
                         sumNums.add(cNum);
                         break;
                    case 1:
                         minusNums.add(cNum);
                         break;
                    default:
                    }
                    break;
               }
               char nextStatus = ' ';
               if(str.charAt(i) == '-') {
                    nextStatus = '-';
               }
               int cNum = 0;
               for(int d = currNums.size() -1; 0 <= d; d--) {
                    cNum += currNums.get(d) * Math.pow(10, currNums.size() -1 - d);
               }
               switch(status) {
               case 0:
                    sumNums.add(cNum);
                    break;
               case 1:
                    minusNums.add(cNum);
                    break;
               default:

               }
               switch(nextStatus) {
               case '-' : status = 1;
                    break;
               default :
               }
          }
          int result = 0;
          // System.out.println("plus Nums");
          for(int i = 0; i < sumNums.size(); i++){
               // System.out.print(sumNums.get(i) + " ");
               result += sumNums.get(i);
          }
          // System.out.println();
          // System.out.println("minus Nums");
          for(int i  = 0; i < minusNums.size(); i++) {
               // System.out.print(minusNums.get(i) + " ");
               result -= minusNums.get(i);
          }
          System.out.println(result);

     }
}

