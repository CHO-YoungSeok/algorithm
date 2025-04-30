import java.util.*;
import java.io.*;


class Number {
    int value;
    int original;
    int rank = 0;
    static int size = 0;
    Number(int value) {
        this.value = value;
        this.original = size++;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Number> list = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            list.add(new Number(Integer.parseInt(inputs[i])));
        }

        list.sort((e1, e2) -> e1.value - e2.value);
        list.get(0).rank = 0;
        for(int i = 1; i < n; i++) {
            if(list.get(i-1).value == list.get(i).value) {
                list.get(i).rank = list.get(i-1).rank;
            } else {
                list.get(i).rank = list.get(i-1).rank + 1;
            }
        }
        list.sort((e1, e2) -> e1.original - e2.original);

        for(Number e : list) {
            sb.append(e.rank + " ");
        }
        System.out.println(sb);      


    }
}