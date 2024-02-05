public class FrontArray9 {
  private static final int FRONT_COUNT = 4;
  private static final int TARGET = 9;

  public static void main(String[] args) {
    System.out.println(
        "frontArray9(new int[]{1, 2, 9, 3, 4}) (TRUE) -> "
            + frontArray9(new int[] {1, 2, 9, 3, 4}));
    System.out.println(
        "frontArray9(new int[]{1, 2, 3, 4, 9}) (FALSE) -> "
            + frontArray9(new int[] {1, 2, 3, 4, 9}));
    System.out.println(
        "frontArray9(new int[]{1, 2, 3, 4, 5}) (FALSE) -> "
            + frontArray9(new int[] {1, 2, 3, 4, 5}));
  }

  private static boolean frontArray9(int[] arr) {
    for (int i = 0; i < FRONT_COUNT && i < arr.length; i++) {
      if (arr[i] == TARGET) {
        return true;
      }
    }

    return false;
  }
}
