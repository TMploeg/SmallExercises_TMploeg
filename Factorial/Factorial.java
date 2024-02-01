import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    int number = askIntInputGreaterThanZero();
    BigInteger factorialResult = factorial(number);
    System.out.println("The factorial of " + number + " is " + factorialResult + "");
  }

  private static BigInteger factorial(int n) {
    BigInteger result = BigInteger.valueOf(1);

    for (int i = 2; i <= n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }

    return result;
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
