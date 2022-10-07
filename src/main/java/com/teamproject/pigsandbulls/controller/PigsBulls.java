package com.teamproject.pigsandbulls.controller;

import com.teamproject.pigsandbulls.model.UserInputValidator;
import com.teamproject.pigsandbulls.model.WordList;
import com.teamproject.pigsandbulls.view.OutputMessages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.Scanner;

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

  // main method that handles the flow of the game
  public static void main(String[] args) throws URISyntaxException, IOException {
    boolean checkCharacterValid;
    messages.displayTitle();
    pigsBulls.userName = inputUserName();
    pigsBulls.setSecret();
    messages.displayInstructions();
    messages.askUserForGuess();

    // Stay in loop until user provides a valid guess or completes the game.
    do {
      checkCharacterValid = pigsBulls.checkCharacters();
    } while (!checkCharacterValid);
  }

  PigsBulls(OutputMessages messages) {
    this.messages = messages;
  }

  // Take the user's name and store it, to be used in Output messages
  public static String inputUserName() {
    System.out.println("Enter a username:");
    Scanner keyboardInput = new Scanner(System.in);
    return keyboardInput.nextLine();
  }

  // If check matches is false, ask user for a user guess in main method
  boolean checkCharacters() {
    if (verifyInputIsValid()) {
      return checkMatches();
    }
    return false;
  }

  /* Check user guess against the guess, sends count of matches to gameController
  * If game controller sees a victory or game loss, return true, else return false*/
  private boolean checkMatches() {
    countPigsAndBulls();
    return gameController();
  }

  // Calculates the count of bulls and pigs
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

  // Controls the game victory, loss, and continue conditions
  private boolean gameController() {
    // If user runs out of turns, end game
    if (turnCounter > 10) {
      messages.displayBullsAndPigs(bulls, pigs);
      messages.displayNoMoreTurnsLeft(userName);
      messages.displaySecret(secret);
      return true;
      // If user's guess matches secret, end game with a victory message
    } else if (bulls == NUMBER_OF_CHARACTERS) {
      messages.displayWinner(userName);
      return true;
    } else {
      // If the user still has turns and hasn't guessed the secret, return to check user guess
      messages.displayBullsAndPigs(bulls, pigs);
      bulls = 0;
      pigs = 0;
      return false;
    }
  }

  // call checkUserInput function to verify user's guess
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

  // Call validation methods to check user's guess
  private void checkUserInput(String userGuess) {
    validateUserInput.checkForCharacterInput(userGuess);
    validateUserInput.checkOversizedWord(userGuess);
    validateUserInput.checkUndersizedWord(userGuess);
  }

  // Set the secret by invoking the generateRandomWord method from WordList
  void setSecret() throws URISyntaxException, IOException {
    WordList wordList = new WordList();
    secret = wordList.generateRandomWord();
  }
}