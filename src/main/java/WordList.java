import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//overhaul. file for 5 letter words online. class that contains list of strings that are in the file. the class could read those word in its constructor.
//read in from a file
//shuffle the list of words and then iterate
//field that is a list of string and is populated from a list of words read from a file
public class WordList {

  private final List<String> words;
  private final Random rng;

  public WordList() throws URISyntaxException, IOException {
    @SuppressWarnings("ConstantConditions")
    URI uri = getClass()
        .getClassLoader()
        .getResource("sgb-words.txt")
        .toURI();
    Path path = Path.of(uri);
    words = Files
        .lines(path)
        .map(String::trim)
        .filter((word) -> !word.isEmpty())
        .collect(Collectors.toList());
    rng = new Random();
  }

  public String generateRandomWord() {
    return words.get(rng.nextInt(words.size()));
  }
}
