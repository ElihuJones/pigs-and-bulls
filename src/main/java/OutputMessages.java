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

  void displayTheEnd() {
    System.out.println("Congratulations! You guessed the code!");
  }

  void displayPlayAgain(){
    System.out.println("Would you like to play again?");
  }

  void displayMessageProvideFiveCharacters(){
    System.out.println("Please enter a 5 letter word");
  }

  void displayBullsAndPigs(int bulls, int pigs){
    System.out.println(" Bull(s): " + bulls + " Pig(s): " + pigs);
  }

  void displayNoMoreAttemptsLeft() {
    System.out.println("Sorry, there are no more attempts left: game ended!");
  }

  void displayAttempts(int attempts) {
    System.out.print("Turn: " + attempts + 1 + "/5: ");
  }

  void displaySecret(String Secret) {
    System.out.println("The secret word was: " + Secret);
  }
}