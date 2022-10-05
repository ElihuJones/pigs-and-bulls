
import java.util.Arrays;
import java.util.stream.Collectors;

class UserInputValidator {

  void validateIfCharactersAreAllDifferent(String userInput) {
    if (Arrays.stream(userInput.split(""))
        .map(Integer::parseInt)
        .collect(Collectors.toSet()).size() != PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("The characters have to be all different!");
    }
  }

  void validateIfLengthIsLessThanFive(String userInput) {
    if (userInput.length() < PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You must provide at least 5 characters!");
    }
  }

  void validateIfLengthIsMoreThanFive(String userInput) {
    if (userInput.length() > PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You can provide only 5 characters!");
    }
  }

  void validateIfOnlyCharacters(String userInput) {
    if (!userInput.matches("^[A-Z]{5}$") && userInput.length() == PigsBulls.NUMBER_OF_CHARACTERS) {
      throw new IllegalArgumentException("You can provide only characters!");
    }
  }
}