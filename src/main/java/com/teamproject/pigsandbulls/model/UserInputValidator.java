package com.teamproject.pigsandbulls.model;

import com.teamproject.pigsandbulls.controller.PigsBulls;

// This class only lets the user continue the game if their guess gets through the following checks
public class UserInputValidator {

  public void checkForCharacterInput(String userGuess) {
    if (!userGuess.matches("^[A-Z]{5}$") && (userGuess.length() == PigsBulls.NUMBER_OF_CHARACTERS)) {
      throw new IllegalArgumentException("You can provide only characters!");
    }
  }

  public void checkOversizedWord(String userGuess) {
    if (userGuess.length() > PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You can provide only 5 characters!");
    }
  }

  public void checkUndersizedWord(String userGuess) {
    if (userGuess.length() < PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You must provide at least 5 characters!");
    }
  }
}