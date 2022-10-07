package com.teamproject.pigsandbulls.model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordList {

  private final List<String> words;
  private final Random rng;

  public WordList() throws URISyntaxException, IOException {
    @SuppressWarnings("ConstantConditions")
    URI uri = getClass()
        .getClassLoader()
        .getResource("words-list.txt")
        .toURI();
    Path path = Path.of(uri);
    words = Files
        .lines(path)
        .map(String::trim)
        .filter((word) -> !word.isEmpty())
        .map(String::toUpperCase)
        .collect(Collectors.toList());
    rng = new Random();
  }

  // Generate a random word from the text file and return it for setSecret in main to utilize
  public String generateRandomWord() {
    return words.get(rng.nextInt(words.size()));
  }
}
