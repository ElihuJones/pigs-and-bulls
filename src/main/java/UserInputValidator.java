class UserInputValidator {


  void checkUndersizedWord(String userInput) {
    if (userInput.length() < PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You must provide at least 5 characters!");
    }
  }

  void checkOversizedWord(String userInput) {
    if (userInput.length() > PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You can provide only 5 characters!");
    }
  }

  void checkForCharacterInput(String userInput) {
    if (!userInput.matches("^[A-Z]{5}$") && userInput.length() == PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You can provide only characters!");
    }
  }
    void checkForUsernameInput(String username) {
      if (!username.matches("^[A-Z]$") && username.length() <= 23) {
        throw new IllegalArgumentException("You can provide only characters!");
      }
  }
}