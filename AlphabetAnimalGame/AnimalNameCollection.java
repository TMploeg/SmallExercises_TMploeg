import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class AnimalNameCollection {
  private static final char ONE_LENGTH_NAMES_INDEX = '$';
  private static final String FILE_NAME = "animal_names.txt";

  private final HashMap<Character, HashMap<Character, LinkedList<String>>> indexedAnimalNames;
  private final LinkedList<String> oneLengthAnimalNames;

  public AnimalNameCollection() {
    indexedAnimalNames = new HashMap<>();
    oneLengthAnimalNames = new LinkedList<String>();

    initNames();
  }

  public boolean contains(String name) {
    if (name == null || name.length() == 0) {
      return false;
    }

    if (name.length() == 1) {
      return oneLengthAnimalNames.contains(name);
    }

    char firstChar = toLowerCaseLetter(name.charAt(0));
    char secondChar = name.charAt(1);

    if (!indexedAnimalNames.containsKey(firstChar)
        || !indexedAnimalNames.get(firstChar).containsKey(secondChar)) {
      return false;
    }

    for (String animalName : indexedAnimalNames.get(firstChar).get(secondChar)) {
      if (name.toLowerCase().equals(animalName.toLowerCase())) {
        return true;
      }
    }

    return false;
  }

  public String getNameWithStartingCharacter(char startingCharacter) {
    char lowerStartingCharacter = toLowerCaseLetter(startingCharacter);

    if (!indexedAnimalNames.containsKey(lowerStartingCharacter)) {
      return null;
    }

    Random r = new Random();

    ArrayList<Character> availableSecondCharacters =
        new ArrayList<>(indexedAnimalNames.get(lowerStartingCharacter).keySet());

    if (availableSecondCharacters.size() == 0) {
      throw new RuntimeException("'" + lowerStartingCharacter + "' is indexed but has no data");
    }

    char selectedSecondCharacter =
        availableSecondCharacters.get(r.nextInt(availableSecondCharacters.size()));
    LinkedList<String> availableNames =
        indexedAnimalNames.get(lowerStartingCharacter).get(selectedSecondCharacter);

    if (availableNames.size() == 0) {
      throw new RuntimeException(
          "'"
              + lowerStartingCharacter
              + "."
              + selectedSecondCharacter
              + "' is indexed but has no data");
    }

    return availableNames.get(r.nextInt(availableNames.size()));
  }

  private void initNames() {
    try {
	  //names scraped from "https://a-z-animals.com/animals/"
      File file = new File(FILE_NAME);
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNextLine()) {
        String name = fileScanner.nextLine();

        if (name != null && name.length() > 0) {
          addAnimalName(name);
        }
      }

      fileScanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("file '" + FILE_NAME + "' was not found");
    }
  }

  private void addAnimalName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("name must have at least one character");
    }

    if (name.length() == 1) {
      oneLengthAnimalNames.add(name);
    }

    char firstChar = toLowerCaseLetter(name.charAt(0));
    if (!indexedAnimalNames.containsKey(firstChar)) {
      indexedAnimalNames.put(firstChar, new HashMap<>());
    }

    char secondChar = name.charAt(1);
    if (!indexedAnimalNames.get(firstChar).containsKey(secondChar)) {
      indexedAnimalNames.get(firstChar).put(secondChar, new LinkedList<>());
    }

    indexedAnimalNames.get(firstChar).get(secondChar).add(name);
  }

  private char toLowerCaseLetter(char c) {
    if (c >= 'A' && c <= 'Z') {
      return (char) (c - ('A' - 'a'));
    }

    return c;
  }
}
