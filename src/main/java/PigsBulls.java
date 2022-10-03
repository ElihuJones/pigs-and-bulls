import java.util.Scanner;

public class PigsBulls {

  public static int turnCounter;
  public static final String secret = "WHILE";

  public static void main(String[] args) {
    System.out.println("Welcome, let's start a game!");
    countBullsAndPigs();
  }

  public static void countBullsAndPigs() {
    Scanner scanner = new Scanner(System.in);
    int bulls = 0;
    int pigs = 0;

/*    while (!scanner.hasNext("^[A-Za-z]+$")){
      System.out.println("Not Valid! Only enter Capital Letters: ");
      scanner.nextLine();
    }*/

    while (turnCounter < 5) {
      System.out.println("Please enter a 5 letter word");
      String userGuess = scanner.nextLine();
      for (int i = 0 ; i < userGuess.length(); i++) {
        if (userGuess.charAt(i) == secret.charAt(i)) {
          bulls++;
        }
        for (int j = 0; j < secret.length(); j++) {
          if (userGuess.charAt(j) == secret.charAt(i) && i != j) {
            pigs++;
          }
        }
      }
      turnCounter++;
      if (bulls > 0 && pigs > 0) {
        System.out.println("! Turn: " + turnCounter +  "  Bull(s): " + bulls + " Pig(s): " + pigs);
      } else if (bulls > 0 && pigs == 0 && bulls != secret.length()) {
        System.out.println("@ Turn: " + turnCounter +  "  Bull(s): " + bulls);
      } else if (bulls == 0 && pigs > 0) {
        System.out.println("# Turn: " + turnCounter + "  Pig(s): " + pigs);
      } else if (bulls == secret.length()) {
        System.out.println("$ Turn: " + turnCounter + "  Bull(s): " + bulls);
        System.out.println("Congratulations! You guessed the secret code.");
        return;
      } else {
        System.out.println("% Result: no, fail, bye.");
      }
      bulls = 0;
      pigs = 0;
    }
  }
}