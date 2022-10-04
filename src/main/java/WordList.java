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

  public static WordList generateRandomWord() {
    Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
