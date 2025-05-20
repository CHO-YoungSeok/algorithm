import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ins[i]);
        }

        HashMap<Integer, Integer> fruits = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < n; right++) {
            fruits.put(arr[right], fruits.getOrDefault(arr[right], 0) + 1);            
            
            while (2 < fruits.size()) {
                fruits.put(arr[left], fruits.get(arr[left]) - 1);

                if (fruits.get(arr[left]) == 0) {
                    fruits.remove(arr[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);            
        }

        System.out.println(maxLength);

    }
}