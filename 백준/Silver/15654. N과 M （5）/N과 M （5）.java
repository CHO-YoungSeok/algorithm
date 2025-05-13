import java.util.*;
import java.io.*;

class Main {
    
    static StringBuilder result = new StringBuilder();
    static List<Integer> list = new ArrayList<>(); 
    static boolean[] visited;

    static void choose(int[] arr, int maxDigit, int digit) {
        
        if (digit > maxDigit) {
            for (int e : list) {
                result.append(e + " ");
            }
            result.append("\n");
            return;
        }

        for (int  i = 0; i < arr.length; i++) {
            if (list.size() == 0 || !visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                choose(arr, maxDigit, digit + 1);
                list.remove(digit - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] ins = br.readLine().split(" ");
        int n = Integer.parseInt(ins[0]);
        int m = Integer.parseInt(ins[1]);
        String[] ins2 = br.readLine().split(" ");
        int[] arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ins2[i]);
        }
        Arrays.sort(arr);
        choose(arr, m, 1);

        System.out.println(result);

        
    }
}