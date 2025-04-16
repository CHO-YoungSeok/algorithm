import java.util.*;

class Number {
     int value = 0;
     int quantity = 0;
     Number(int value, int quantity) {
          this.value = value;
          this.quantity = quantity;
     }
}

public class Main{

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          StringBuilder sb = new StringBuilder();

          int n = sc.nextInt();
          List<Integer> list = new ArrayList<>();
          for(int i = 0; i < n; i++) {
               list.add(sc.nextInt());
          }
          list.sort((e1, e2) -> e1 - e2);
          
          int sum = 0;
          for(int i = 0; i < n; i++) {
               sum += list.get(i);
          }
          
          if(String.format("%.0f", (double)sum / n).equals("-0")) {
               sb.append("0\n");
          } else {
               sb.append(String.format("%.0f\n", (double)sum / n));
          }

          sb.append(list.get(n/2) + "\n");

          List<Number> vqList = new ArrayList<>();
          for(int i = 0; i < n; i++) {
               int num = list.get(i);
               int q = 1;
               while(i < list.size() - 1 && num == list.get(i + 1)) {
                    q++;
                    i++;
               }
               vqList.add(new Number(num, q));
          }

          vqList.sort((e1, e2) -> {
               if(e1.quantity == e2.quantity) {
                    return e1.value - e2.value;
               }
               return e2.quantity - e1.quantity;
          });
          if((vqList.size() >= 2) && vqList.get(0).quantity == vqList.get(1).quantity) {
               sb.append(vqList.get(1).value + "\n");
          } else {
               sb.append(vqList.get(0).value + "\n");
          }

          sb.append("" + (list.get(list.size() - 1) - list.get(0)));
          System.out.println(sb);
     }
}