import java.util.Scanner;

public class EveryNth {
  public static void main(String[] args) {
    String string = askStringInput();
    int number = askIntInputGreaterThanZero();
    String result = everyNth(string, number);

    String displayString = string;
    int displayMax = 30;

    if (displayString.length() > displayMax) {
      displayString = displayString.substring(0, displayMax + 1) + "...";
    }

    System.out.println("everyNth(" + displayString + ", " + number + ") -> " + result);
  }

  private static String everyNth(String input, int n) {
    String output = "";

    for (int i = 0; i < input.length(); i += n) {
      output += input.charAt(i);
    }

    return output;
  }

  private static String askStringInput() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Please enter a string: ");
      String input = scanner.nextLine();
      if (input != null && input.length() > 0) {
        return input;
      }
    }
  }

  private static int askIntInputGreaterThanZero() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Please enter a integer greater than 0: ");

      String intInput = scanner.nextLine();

      if (isNumberGreaterThanZero(intInput) && isInIntegerRange(intInput)) {
        return Integer.parseInt(intInput);
      }
    }
  }

  private static boolean isNumberGreaterThanZero(String intInput) {
    if (intInput == null) {
      throw new NullPointerException("input must not be null");
    }

    if (intInput.length() == 0) {
      return false;
    }

    boolean hasNonZeroDigit = false;

    for (char c : intInput.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }

      if (c > '0') {
        hasNonZeroDigit = true;
      }
    }

    return hasNonZeroDigit;
  }

  private static boolean isInIntegerRange(String intInput) {
    String maxValue = Integer.toString(Integer.MAX_VALUE);

    int maxValueLength = maxValue.length();
    int inputLength = intInput.length();

    if (maxValueLength != inputLength) {
      return maxValueLength > inputLength;
    }

    for (int charPos = 0; charPos < inputLength; charPos++) {
      char maxValueCurrentChar = maxValue.charAt(charPos);
      char inputCurrentChar = intInput.charAt(charPos);

      if (maxValueCurrentChar != inputCurrentChar) {
        return maxValueCurrentChar > inputCurrentChar;
      }
    }

    return true;
  }
}
