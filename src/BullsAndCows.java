import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        // String val = ""+((int)(Math.random()*9000)+1000);
        String val = "9305";
        int cow = 0;
        int bull = 0;

        char[] digit = sc.nextLine().toCharArray();
        char[] cha1 = val.toCharArray();
            for(int i = 0; i < digit.length; i++) {
                if (val.contains(Character.toString(digit[i]))) {
                    cow++;
                }
                if (digit[i] == cha1[i]) {
                    bull++;
                    cow--;
                }
            }
            if (bull > 0 && cow == 0) {
                System.out.println("Grade: " + bull + " bull(s)." + "The secret code is " + val);
            } else if (cow > 0 && bull == 0) {
                System.out.println("Grade: " + cow + " cow(s)." + "The secret code is " + val);
            } else if (bull > 0 && cow > 0) {
                System.out.println("Grade: " + bull + " bull(s). " + "and " + cow + " cow(s)" + " The secret code is " + val);
            } else {
                System.out.println("Grade: " + "None. The secret code is " + val);
            }
    }
}

