import java.util.*;

class Member {
     int age;
     String name;
     Member(int age, String name) {
          this.age = age;
          this.name = name;
     }
     @Override
     public String toString() {
          return "" + age + " " + name;
     }
}

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          List<Member> members = new ArrayList<>();

          while(0 < T--) {
               int age = sc.nextInt();
               String name = sc.next();
               members.add(new Member(age, name));
          }

          members.sort((e1, e2) -> e1.age - e2.age);

          for(int i = 0; i < members.size(); i++) {
               System.out.println(members.get(i));
          }

     }
}

