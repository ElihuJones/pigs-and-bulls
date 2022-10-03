import java.util.Scanner;

public class PigsBulls {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Username");
    String userGuess = scanner.nextLine();
    System.out.println("Username is: " + userGuess);
    String secret = "WHILE";
    int bull = 0;
    int pigs = 0;
    int turnCounter = 1;

    while (turnCounter < 6) {
      for (int i = 0; i < userGuess.length(); i++) {
        if (userGuess.charAt(i) == secret.charAt(i)) {
          bull++;
        }
        for (int j = 0; j < secret.length(); j++) {
          if (secret.charAt(j) != userGuess.charAt(i) && i != j) {
            pigs++;
          }
        }
      }
      turnCounter++;
      System.out.printf("Turn: %d:\n", turnCounter, bull, pigs);
      return;
    }
  }
}
