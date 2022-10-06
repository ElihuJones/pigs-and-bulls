import java.util.Scanner;

public class OutputMessages {

  void displayLogo() {
    System.out.println("PIGS AND BULLS \n");
  }

  void displayInstructions(){
    System.out.println("Welcome to the pigs and bulls game \n" +
        "Your characters need to be all different: [FRUIT] \n" +
        "The program will give you the number of matches. \n" +
        "If a character matches and is in the right position, they are \"bulls\" \n" +
        "If a character matches but in a different position, they are \"cows\" \n" +
        "Example: Secret: WHILE      Player Guess: WATER \n" +
        "Result: 1 bull(s) 1 pig(s). The W is a bull, the E is a pig \n " +
        " You will have 5 guesses to find the secret word. Good Luck! \n");
  }

  String inputUsername() {
    System.out.println("Enter a username:");
    Scanner keyboardInput = new Scanner(System.in);
    return keyboardInput.nextLine();
  }

  void inputTheEnd(String username) {
    System.out.println("Congratulations " + username + " !" + " You guessed the code!");
  }

  void inputPlayAgain(String username){
    System.out.println("Hey " + username + "!" + " Would you like to play again?");
  }

  void inputMessageProvideFiveCharacters(){
    System.out.println("Please enter a 5 letter word");
  }

  void displayBullsAndPigs(int bulls, int pigs){
    System.out.println(" Bull(s): " + bulls + " Pig(s): " + pigs);
  }

  void inputNoMoreAttemptsLeft(String username) {
    System.out.println("Sorry, " + username + " there are no more attempts left: game ended!");
  }

  void displayAttempts(int attempts) {
    System.out.print("Turn: " + attempts + "/5: ");
  }

  void displaySecret(String Secret) {
    System.out.println("The secret word was: " + Secret);
  }
}