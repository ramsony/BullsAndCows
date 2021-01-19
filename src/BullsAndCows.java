import java.util.Scanner;

public class BullsAndCows {
    public static String generateRandomNum(int num) {
        StringBuilder rand = new StringBuilder();
        while (rand.length() != num) {
            long pseudoRandomNumber = System.nanoTime();
            String num1 = String.valueOf(Long.parseLong(new StringBuilder(String.valueOf(pseudoRandomNumber)).reverse().toString()));
            for (int i = 0; i < num1.length(); i++) {
                if (!rand.toString().contains(String.valueOf(num1.charAt(i)))) {
                    rand.append(num1.charAt(i));
                }
                if (rand.length() == num) {
                    break;
                }
            }
        }
        return rand.toString();
    }
    private static String bullsCowCheck(String guess, String val) {
        int cow = 0;
        int bull = 0;
        char[] digit = guess.toCharArray();
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
        String bulls = bull > 1 ? " bulls." : " bull.";
        String cows = cow > 1 ? " cows." : " cow.";
        if (bull > 0 && cow == 0) {
            return  "Grade: " + bull + bulls ;
        } else if (cow > 0 && bull == 0) {
            return "Grade: " + cow + cows ;
        } else if (bull > 0 && cow > 0) {
            return "Grade: " + bull + bulls + "and " + cow + cows ;
        } else {
            return "Grade: " + "None";
        }
    }

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int turn = 1;
        int num = sc.nextInt();
        while (num > 10) {
            System.out.println("Error: can't generate a secret number with a length of " +
                    "" + num + " because there aren't enough unique digits.");
            System.out.println("Please, enter the secret code's length:");
            num = sc.nextInt();
        }
        String val = generateRandomNum(num);
        System.out.println("Okay, let's start a game!");
        System.out.println("Turn "+ turn+":");

        while(true) {
            String guess = sc.nextLine();
            while (guess.isEmpty()) {
                guess = sc.nextLine();
            }
            if (val.equals(guess)) {
                String bulls = val.length() > 1 ? " bulls" : " bull";
                System.out.println("Grade: "+val.length() + bulls+"\nCongratulations! You guessed the secret code.");
                return;
            }
            String result = bullsCowCheck(guess, val);
            System.out.println(result);
            turn++;
            System.out.println("Turn "+ turn+":");
        }
    }
}
