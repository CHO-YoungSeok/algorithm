import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] sides = new int[3];
            Arrays.fill(sides, 0);
            for (int i = 0; i < 3; i++) {
                sides[i] = sc.nextInt();
            }

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

            Arrays.sort(sides);

            System.out.println((sides[2] * sides[2] == sides[1] * sides[1] + sides[0] * sides[0]) ? "right" : "wrong");
        }
    }
}