package com.teamproject.pigsandbulls.view;

public class OutputMessages {

  public void displayTitle() {
    System.out.println("PIGS AND BULLS \n");
  }

  public void displayInstructions() {
    System.out.println("Welcome to the pigs and bulls game \n" +
        "Your characters need to be all different: [FRUIT] \n" +
        "The program will give you the number of matches. \n" +
        "If a character matches and is in the right position, they are \"bulls\"\n" +
        "If a character matches but in a different position, they are \"pigs\"\n\n" +
        "Example: Secret: WHILE      Player Guess: WATER \n" +
        "Turn: 1/10: WATER \n" +
        " Bull(s): 1 Pig(s): 0. The W is a bull, the E is a pig. \n\n" +
        " You will have 10 guesses to find the secret word. Good Luck! \n");
  }

  public void askUserForGuess() {
    System.out.println("Please enter a 5 letter word");
  }

  public void displayTurns(int turnCounter) {
    System.out.print("Turn: " + turnCounter + "/10: ");
  }

  public void displayBullsAndPigs(int bulls, int pigs) {
    System.out.println(" Bull(s): " + bulls + " Pig(s): " + pigs);
  }

  public void displayNoMoreTurnsLeft(String userName) {
    System.out.println("Sorry " + userName + "! There are no more attempts left: game ended!");
  }

  public void displaySecret(String secret) {
    System.out.println("The secret word was: " + secret);
  }

  public void displayWinner(String userName) {
    System.out.println("Congratulations " + userName + "!" + " You guessed the code!");
  }
}
