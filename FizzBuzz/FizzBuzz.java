public class FizzBuzz {
  public static void main(String[] args) {
    fizzBuzz();
  }

  public static void fizzBuzz() {
    String output = "";

    for (int i = 1; i <= 100; i++) {
      if (i != 1) {
        output += " ";
      }

      String newOutput = "";

      if (i % 3 == 0) {
        newOutput += "Fizz";
      }

      if (i % 5 == 0) {
        newOutput += "Buzz";
      }

      if (newOutput.length() == 0) {
        newOutput += i;
      }

      output += newOutput;
    }

    System.out.println(output);
  }
}
