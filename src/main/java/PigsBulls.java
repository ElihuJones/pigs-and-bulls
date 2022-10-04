import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class PigsBulls {

  public static int turnCounter;
  public static final String secret = "WHILE";


  public static void main(String[] args) {
    System.out.println("Welcome, let's start a game!");
    try {
      countBullsAndPigs();
    } catch (IOException e) {
      System.out.println("Can't read Input, Game Over!");
    }
  }

  public static void countBullsAndPigs() throws IOException {
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    int bulls = 0;
    int pigs = 0;

    while (turnCounter < 5) {
      String guess = null;
      do {
        System.out.println("Please enter a 5 letter word");
        try {
          guess = buffer.readLine().toUpperCase().trim();
          if (guess.matches("^[A-Z]{5}$")) {
            break;
          } else {
            throw new IllegalArgumentException();
          }
        } catch (IllegalArgumentException e) {
          System.out.println("Invalid Input!");
        }
      } while (true);
      for (int i = 0; i < guess.length(); i++) {
        if (guess.charAt(i) == secret.charAt(i)) {
          bulls++;
        }
        for (int j = 0; j < secret.length(); j++) {
          if (guess.charAt(j) == secret.charAt(i) && i != j) {
            pigs++;
          }
        }
      }
      turnCounter++;
      if (bulls > 0 && pigs > 0) {
        System.out.println("! Turn: " + turnCounter + "  Bull(s): " + bulls + " Pig(s): " + pigs);
      } else if (bulls > 0 && pigs == 0 && bulls != secret.length()) {
        System.out.println("@ Turn: " + turnCounter + "  Bull(s): " + bulls);
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