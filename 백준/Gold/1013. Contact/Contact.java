import java.util.*;
class Main {
    static int T;
    static String str;
    static int len;

    static boolean isFirst(int i) {
        if(i+3 < len && str.charAt(i) == '1' && str.charAt(i+1) == '0' && str.charAt(i+2) == '0') {
            i += 3;
            while(i < len && str.charAt(i) == '0') {
                i++;
            }
            if(i < len && str.charAt(i) == '1') {
                while(i < len && str.charAt(i) == '1') {
                    i++;
                }
                if(i == len) {
                    return true;
                } else {
                    if(i + 2 < len && str.charAt(i) == '0' && str.charAt(i+1) == '0' && str.charAt(i-2) == '1' && str.charAt(i-1) == '1') {
                        return isFirst(i-1);
                    } else if(i + 1 < len && str.charAt(i) == '0' && str.charAt(i+1) == '1') {
                        return isSecond(i);
                    }
                }
            }
        }

        return false;
    }

    static boolean isSecond(int i) {
        if(i + 1 < len && str.charAt(i) == '0' && str.charAt(i+1) == '1') {
            i += 2;
            if(i == len) {
                return true;
            } else if(i + 1 < len && str.charAt(i) == '0') {
                return isSecond(i);
            } else if(i + 3 < len && str.charAt(i) == '1') {
                return isFirst(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            str = sc.next();
            len = str.length();
            boolean bIsYes = false;
            bIsYes = str.charAt(0) == '1' ? isFirst(0) : isSecond(0);
            System.out.println(bIsYes ? "YES" : "NO");
        }

    }
}