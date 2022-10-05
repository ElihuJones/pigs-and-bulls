import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class PigsBulls {

  static final int NUMBER_OF_CHARACTERS = 5;
  private final Reader reader = new InputStreamReader(System.in);
  private final BufferedReader buffer = new BufferedReader(reader);
  private final UserInputValidator validateUserInput = new UserInputValidator();
  private final OutputMessages messages;
  public static int turnCounter;
  private String userString;
  private String secret;
  private int bulls;
  private int pigs;

  public static void main(String[] args) {

    boolean flag;
    OutputMessages messages = new OutputMessages();
    PigsBulls pigsBulls = new PigsBulls(messages);

    messages.displayLogo();
    messages.displayInstructions();
    messages.displayMessageProvideFiveCharacters();

    //FIXME
    pigsBulls.setSecret();

    do {
      flag = pigsBulls.checkCharacters();
    } while (!flag);
  }

  PigsBulls(OutputMessages messages) {
    this.messages = messages;
    //getSecret();
  }

  boolean checkCharacters() {
    if (verifyOnlyCharInput()) {
      return checkMatches();
    }
    return false;
  }

  private boolean checkMatches() {
    countBullsAndPigs();
    return getResult();
  }

  void countBullsAndPigs() {
/*    for (int i = 0; i < userString.length(); i++) {
      if (userString.charAt(i) == secret.charAt(i)) {
        bulls++;
        for (int j = 0; j < secret.length(); j++) {
          if (userString.charAt(j) == secret.charAt(i) && i != j) {
            pigs++;
          }
        }
      }
    }*/
    for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
      if (userString.charAt(i) == secret.charAt(i)) {
        bulls++;
      }
      else if (secret.contains(userString.charAt(i) + "")) {
        pigs++;
      }
    }
    turnCounter++;
  }

  private boolean getResult() {
    if (turnCounter == 5) {
      messages.displayBullsAndPigs(bulls, pigs);
      messages.displayNoMoreAttemptsLeft();
      messages.displaySecret(secret);
      return true;
    } else if (bulls == NUMBER_OF_CHARACTERS) {
      messages.displayTheEnd();
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
      messages.displayAttempts(turnCounter);
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

  void setSecret() {
    secret = "WHILE";
    //create an instance of the WordList class, and then invoking a method on it.
    //WordList wordList = new WordList();
    //secret = wordList.generateRandomWord().toString();
  }

  void setUserString(String userString){
    this.userString = userString;
  }

  int getBulls() {
    return bulls;
  }

  int getPigs() {
    return pigs;
  }

  String getSecret() {
    return secret;
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