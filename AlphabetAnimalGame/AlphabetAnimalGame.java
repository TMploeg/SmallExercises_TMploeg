import java.util.Scanner;

public class AlphabetAnimalGame {
  private static AnimalNameCollection animalNameCollection;

  private static final String SURRENDER_INPUT = "?";

  public static void main(String[] args) {
    animalNameCollection = new AnimalNameCollection();

    play();
  }

  private static void play() {
    Character requiredCharacter = null;

    while (true) {
      System.out.print("Please enter an animal");

      if (requiredCharacter != null) {
        System.out.print(" starting with '" + requiredCharacter + "'");
      }
      System.out.print(" (enter '?' to surrender): ");

      String playerChoice = getAnimalInput(requiredCharacter);
      if (playerChoice == null) {
        System.out.println("You surrendered, better luck next time!");
        break;
      }

      requiredCharacter = playerChoice.charAt(playerChoice.length() - 1);

      String computerResponse =
          animalNameCollection.getNameWithStartingCharacter(requiredCharacter);

      for (int i = 0; i < 3; i++) {
        System.out.print(".");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
      System.out.println();

      if (computerResponse == null) {
        System.out.println(
            "I cannot find any animal starting with the letter '"
                + requiredCharacter
                + "', you win!");
        break;
      }

      requiredCharacter = computerResponse.charAt(computerResponse.length() - 1);

      System.out.println("I choose " + computerResponse);
    }
  }

  private static String getAnimalInput(Character requiredStartingCharacter) {
    Scanner inputScanner = new Scanner(System.in);

    while (true) {
      String animalInput = inputScanner.nextLine();

      if (animalInput == null || animalInput.length() == 0) {
        System.out.println("Input is invalid, at least one character is required");
        continue;
      }

      if (animalInput.equals(SURRENDER_INPUT)) {
        return null;
      }

      if (requiredStartingCharacter != null
          && Character.toLowerCase(animalInput.charAt(0))
              != Character.toLowerCase(requiredStartingCharacter)) {
        System.out.println("Input must start with '" + requiredStartingCharacter + "'");
        continue;
      }

      if (!animalNameCollection.contains(animalInput)) {
        System.out.println("'" + animalInput + "' is not a valid animal name");
        continue;
      }

      return animalInput;
    }
  }
}
