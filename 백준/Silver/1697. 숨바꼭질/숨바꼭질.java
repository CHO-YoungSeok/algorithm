import java.util.*;
import java.io.*;
class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[]field = new boolean[100001];
        int[]distance = new int[100001];
        distance[n] = 0;
        field[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        
        while (!field[m]) {
            int currNode = q.remove();
            if (0 <= currNode -1 && !field[currNode -1]) {
                field[currNode -1] = true;
                q.add(currNode -1);
                distance[currNode -1] = distance[currNode] + 1;
            }
            if (currNode + 1 < 100001 && !field[currNode + 1] ) {
                field[currNode +1] = true;
                q.add(currNode + 1);
                distance[currNode +1] = distance[currNode] + 1;
            }
            if (currNode * 2 < 100001 && !field[currNode*2]) {
                field[currNode * 2] = true;
                q.add(currNode * 2);
                distance[currNode * 2] = distance[currNode] + 1;
            }
        }
        System.out.println(distance[m]);
    }
}