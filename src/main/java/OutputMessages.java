import java.util.Scanner;

public class OutputMessages {

  void displayLogo() {
    System.out.println("PIGS AND BULLS \n");
  }

  void displayInstructions(){
    System.out.println("Welcome to the pigs and bulls game \n" +
        "Your characters need to be all different: [FRUIT] \n" +
        "The program will give you the number of matches. \n" +
        "If a character matches and is in the right position, they are \"bulls\"\n" +
        "If a character matches but in a different position, they are \"pigs\"\n\n" +
        "Example: Secret: WHILE      Player Guess: WATER \n" +
        "Result: 1 bull(s) 1 pig(s). The W is a bull, the E is a pig \n " +
        " You will have 5 guesses to find the secret word. Good Luck! \n");
  }

  String inputUserName() {
    System.out.println("Enter a username:");
    Scanner keyboardInput = new Scanner(System.in);
    return keyboardInput.nextLine();
  }

  void displayTheEnd(String userName) {
    System.out.println("Congratulations " + userName + "!" + " You guessed the code!");
  }

  void displayPlayAgain(String userName){
    System.out.println("Hey " + userName + "!" + " Would you like to play again?");
  }

  void displayMessageProvideFiveCharacters(){
    System.out.println("Please enter a 5 letter word");
  }

  void displayTurns(int turnCounter) {
    System.out.print("Turn: " + turnCounter + "/10: ");
  }

  void displayBullsAndPigs(int bulls, int pigs){
    System.out.println(" Bull(s): " + bulls + " Pig(s): " + pigs);
  }

  void displayNoMoreTurnsLeft(String userName) {
    System.out.println("Sorry, " + userName  + ", there are no more attempts left: game ended!");
  }

  void displaySecret(String secret) {
    System.out.println("The secret word was: " + secret);
  }


}