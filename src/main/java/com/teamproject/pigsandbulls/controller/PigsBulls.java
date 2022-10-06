package com.teamproject.pigsandbulls.controller;

import com.teamproject.pigsandbulls.model.UserInputValidator;
import com.teamproject.pigsandbulls.model.WordList;
import com.teamproject.pigsandbulls.view.OutputMessages;
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
  private static String userGuess;
  private static int turnCounter = 1;
  private int bulls;
  private int pigs;
  public String userName;
  public static final int NUMBER_OF_CHARACTERS = 5;

  public static void main(String[] args) throws URISyntaxException, IOException {
    boolean checkCharacterValid;
    messages.displayTitle();
    pigsBulls.userName = messages.inputUserName();
    pigsBulls.setSecret();
    messages.displayInstructions();
    messages.askUserForGuess();

    do {
      checkCharacterValid = pigsBulls.checkCharacters();
    } while (!checkCharacterValid);
  }

  PigsBulls(OutputMessages messages) {
    this.messages = messages;
  }

  boolean checkCharacters() {
    if (verifyInputIsValid()) {
      return checkMatches();
    }
    return false;
  }

  private boolean checkMatches() {
    countPigsAndBulls();
    return gameController();
  }

  void countPigsAndBulls() {
    for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
      if (userGuess.charAt(i) == secret.charAt(i)) {
        bulls++;
      } else if (secret.contains(userGuess.charAt(i) + "")) {
        pigs++;
      }
    }
    turnCounter++;
  }

  private boolean gameController() {
    if (turnCounter >= 10) {
      messages.displayBullsAndPigs(bulls, pigs);
      messages.displayNoMoreTurnsLeft(userName);
      messages.displaySecret(secret);
      return true;
    } else if (bulls == NUMBER_OF_CHARACTERS) {
      messages.displayWinner(userName);
      return true;
    } else {
      messages.displayBullsAndPigs(bulls, pigs);
      bulls = 0;
      pigs = 0;
      return false;
    }
  }

  private boolean verifyInputIsValid() {
    try {
      messages.displayTurns(turnCounter);
      userGuess = buffer.readLine().toUpperCase().trim();
      checkUserInput(userGuess);
      return true;
    } catch (IllegalArgumentException | IOException e) {
      System.err.println(e.getMessage());
    }
    return false;
  }

  private void checkUserInput(String userGuess) {
    validateUserInput.checkForCharacterInput(userGuess);
    validateUserInput.checkOversizedWord(userGuess);
    validateUserInput.checkUndersizedWord(userGuess);
  }

  void setSecret() throws URISyntaxException, IOException {
    WordList wordList = new WordList();
    secret = wordList.generateRandomWord();
  }
}