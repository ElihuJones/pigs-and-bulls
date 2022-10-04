import java.util.Random;

public enum WordList {
  WHILE,
  MONEY,
  TRICK,
  FJORD,
  RACKS,
  CARDS,
  RANKS,
  SUITE,
  HANDS,
  BLANK;


  public static SecretWords generateRandomWord() {
    SecretWords[] values = SecretWords.values();
    int length = values.length;
    int randomWord = new Random().nextInt(length);
    return values[randomWord];
  }

  private final String secret;

  WordList(String secret) {
    this.secret = secret;
  }

  public String secret() {
    return secret;
  }
}
