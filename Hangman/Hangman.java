import java.util.LinkedList;
import java.util.Scanner;

public class Hangman {
  private static final int NR_OF_ATTEMPS = 10;

  public static void main(String[] args) {
    String word = getWordInput("Player 1, please enter a word:").toLowerCase();

    LinkedList<Character> guessedLetters = new LinkedList<>();

    while (true) {
      String hiddenWord = "";

      for (int i = 0; i < word.length(); i++) {
        if (i != 0) {
          hiddenWord += " ";
        }

        char displayCharacter = guessedLetters.contains(word.charAt(i)) ? word.charAt(i) : '_';
        hiddenWord += displayCharacter;
      }

      System.out.println(hiddenWord);

      char chosenCharacter = getLetterInput("Player 2, please enter a letter:", guessedLetters);

      guessedLetters.add(chosenCharacter);

      boolean correctGuess = word.contains(Character.toString(chosenCharacter));

      if (correctGuess) {
        if (hasWon(guessedLetters, word)) {
          System.out.println("The word is '" + word + "' you win!");
          return;
        }

        System.out.println("Correct!");
      } else {
        int remainingAttempts = getRemainingAttempts(guessedLetters, word);

        if (remainingAttempts == 0) {
          System.out.println("No attempts left, you lose.");
          return;
        }

        System.out.println("Incorrect, remaining attemps: " + remainingAttempts);
      }
    }
  }

  private static boolean hasWon(LinkedList<Character> guessedLetters, String word) {
    for (char c : word.toCharArray()) {
      if (!guessedLetters.contains(c)) {
        return false;
      }
    }

    return true;
  }

  private static int getRemainingAttempts(LinkedList<Character> guessedLetters, String word) {
    int wrongLetterCount = 0;

    for (char c : guessedLetters) {
      if (!word.contains(Character.toString(c))) {
        wrongLetterCount++;
      }
    }

    return Math.max(0, NR_OF_ATTEMPS - wrongLetterCount);
  }

  public static String getWordInput(String message) {
    InputProcessor<String> iP = input -> validateWordInput(input);
    return getInput(message, iP);
  }

  public static char getLetterInput(String message, LinkedList<Character> excludeList) {
    InputProcessor<Character> iP = input -> validateLetterInput(input, excludeList);
    return getInput(message, iP);
  }

  @SuppressWarnings("unchecked")
  public static <TResult> TResult getInput(String message, InputProcessor<TResult> processor) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print(message + " ");
      Result inputResult = processor.execute(scanner.nextLine());

      if (inputResult.succes()) {
        return (TResult) inputResult.value();
      }

      System.out.println(inputResult.errorMessage());
    }
  }

  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static Result<String> validateWordInput(String input) {
    return input != null && input.length() != 0
        ? Result.succesResult(input)
        : Result.errorResult("input must have at least one character");
  }

  private static Result<Character> validateLetterInput(
      String input, LinkedList<Character> excludeList) {
    String errorMessage = null;

    char min = 'a';
    char max = 'z';

    if (input == null || input.length() != 1) {
      errorMessage = "input must have exactly one character";
    } else if (input.charAt(0) < min || input.charAt(0) > max) {
      errorMessage = "input must be a character between '" + min + "' and '" + max + "'";
    } else if (excludeList.contains(input.charAt(0))) {
      errorMessage = "'" + input.charAt(0) + "' has already been chosen";
    }

    return errorMessage == null
        ? Result.succesResult(input.charAt(0))
        : Result.errorResult(errorMessage);
  }
}
