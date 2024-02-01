import java.util.Scanner;

public class IsPrime {
  public static void main(String[] args) {
    int number = askIntInput();
    boolean isPrime = isPrime(number);
    System.out.println("isPrime(" + number + ") -> " + isPrime);
  }

  private static boolean isPrime(int n) {
    int factor = 2;

    while (true) {
      int mod = n % factor;

      if (mod == 0) {
        return false;
      }

      if (((n - mod) / factor) <= factor) {
        return true;
      }

      factor++;
    }
  }

  private static int askIntInput() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Please enter a integer greater than 0: ");

      String intInput = scanner.nextLine();

      if (isInteger(intInput)) {
        return Integer.parseInt(intInput);
      }

      System.out.println(
          "error: '"
              + intInput
              + "' is not an integer, must be a number in range: ("
              + Integer.MIN_VALUE
              + " - "
              + Integer.MAX_VALUE
              + ")");
    }
  }

  private static boolean isInteger(String intInput) {
    if (intInput == null) {
      throw new NullPointerException("input must not be null");
    }

    String maxValue = Integer.toString(Integer.MAX_VALUE);
    String inputValue = intInput;
    char negativeSign = '-';

    if (inputValue.length() == 0 || inputValue.length() > maxValue.length()) {
      return false;
    }

    maxValue = maxValue.substring(maxValue.length() - inputValue.length());

    if (inputValue.charAt(0) == negativeSign) {
      if (inputValue.length() == 1) {
        return false;
      }

      inputValue = inputValue.substring(1);
      maxValue = Integer.toString(Integer.MIN_VALUE).substring(1);
    }

    for (int i = 0; i < inputValue.length(); i++) {
      char currentInputChar = inputValue.charAt(i);
      char currentMaxValueChar = maxValue.charAt(i);

      if (!Character.isDigit(currentInputChar)) {
        return false;
      }

      if (currentInputChar != currentMaxValueChar) {
        return currentInputChar < currentMaxValueChar;
      }
    }

    return true;
  }
}
