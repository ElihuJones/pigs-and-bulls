import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;

public class PigsBulls {

  private static final Reader reader = new InputStreamReader(System.in);
  private static final BufferedReader buffer = new BufferedReader(reader);
  private static final UserInputValidator validateUserInput = new UserInputValidator();
  private final OutputMessages messages;
  private static int turnCounter = 1;
  private static String secret;
  private static String userString;
  public static final int NUMBER_OF_CHARACTERS = 5;
  private int bulls;
  private int pigs;

  public static void main(String[] args) throws URISyntaxException, IOException {

    boolean flag;
    OutputMessages messages = new OutputMessages();
    PigsBulls pigsBulls = new PigsBulls(messages);

    messages.displayLogo();
    messages.displayInstructions();
    messages.displayMessageProvideFiveCharacters();
    pigsBulls.setSecret();

    do {
      flag = pigsBulls.checkCharacters();
    } while (!flag);
  }

  PigsBulls(OutputMessages messages) {
    this.messages = messages;
  }

  boolean checkCharacters() {
    if (verifyOnlyCharInput()) {
      return checkMatches();
    }
    return false;
  }

  private boolean checkMatches() {
    countPigsAndBulls();
    return getResult();
  }

  void countPigsAndBulls() {
    for (int i = 0; i < userString.length(); i++) {
      if (userString.charAt(i) == secret.charAt(i)) {
        bulls++;
        for (int j = 0; j < secret.length(); j++) {
          if (userString.charAt(j) == secret.charAt(i) && i != j) {
            pigs++;
          }
        }
      }
    }
    turnCounter++;
  }

  private boolean getResult() {
    if (turnCounter == 11) {
      messages.displayBullsAndPigs(bulls, pigs);
      messages.displayNoMoreTurnsLeft();
      messages.displaySecret(secret);
      return true;
    } else if (bulls == NUMBER_OF_CHARACTERS) {
      messages.displayTheEnd();
      messages.displayPlayAgain();
      return true;
    } else {
      messages.displayBullsAndPigs(bulls, pigs);
      bulls = 0;
      pigs = 0;
      return false;
    }
  }

  private boolean verifyOnlyCharInput() {
    try {
      messages.displayTurns(turnCounter);
      userString = buffer.readLine().toUpperCase().trim();
      checkUserInput(userString);
      return true;
    } catch (IllegalArgumentException | IOException e) {
      System.err.println(e.getMessage());
    }
    return false;
  }

  private void checkUserInput(String userInput) {
    validateUserInput.checkForCharacterInput(userInput);
    validateUserInput.checkOversizedWord(userInput);
    validateUserInput.checkUndersizedWord(userInput);
  }

  private void checkForPlayAgain(String userInput) {
    validateUserInput.checkForPlayAgain(userInput);
  }

  void setSecret() throws URISyntaxException, IOException {
    WordList wordList = new WordList();
    secret = wordList.generateRandomWord();
  }

  /*  public static void playAgain() {
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    String userInput = null;
    do {
      System.out.println("Would you like to play again?");
      try {
        userInput = buffer.readLine().toUpperCase().trim();
        if (userInput.matches("^['Y']{1}$")) {
          turnCounter = 0;
          main();
        } else {
          turnCounter = 0;
        }
      } catch (IOException nothing) {
        //do nothing
      }
    } while (userInput == "Y");
  }*/

}