import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
 
public class Main {
     public static void main(String[] args) throws IOException {
    
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
        
          int n = Integer.parseInt(br.readLine());
          int[] arr = new int[10000];
        
          for(int i = 0; i < n; i++) {
               int currN = Integer.parseInt(br.readLine());
               arr[currN-1]++;
          }

          for(int i = 0; i < 10000; i++){
               for(int j = 0; j < arr[i]; j++) {
                    sb.append(i+1 + "\n");
               }
          }
          System.out.println(sb);
     }
}