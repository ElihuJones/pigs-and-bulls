import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;

public class PigsBulls {

  private static final Reader reader = new InputStreamReader(System.in);
  private static final BufferedReader buffer = new BufferedReader(reader);
  private static final UserInputValidator validateUserInput = new UserInputValidator();
  private static OutputMessages messages = new OutputMessages();
  private static PigsBulls pigsBulls = new PigsBulls(messages);
  private static String secret;
  private static String userString;
  private static int turnCounter = 1;
  private int bulls;
  private int pigs;
  public static final int NUMBER_OF_CHARACTERS = 5;


  public static void main(String[] args) throws URISyntaxException, IOException {
      boolean checkValid;
      messages.displayLogo();
      messages.displayInstructions();
      messages.displayMessageProvideFiveCharacters();
      pigsBulls.setSecret();

      do {
        checkValid = pigsBulls.checkCharacters();
      } while (!checkValid);
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
    for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
      if (userString.charAt(i) == secret.charAt(i)) {
        bulls++;
      } else if (secret.contains(userString.charAt(i) + "")) {
        pigs++;
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

  void setSecret() throws URISyntaxException, IOException {
    WordList wordList = new WordList();
    secret = wordList.generateRandomWord();
  }
}