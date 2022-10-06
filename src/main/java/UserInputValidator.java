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

  void checkForPlayAgain(String userInput){
    if (!userInput.matches("^[Y]$") || userInput.matches("^[N]$")){
      throw new IllegalArgumentException("Please type Y or N");
    }
  }
}