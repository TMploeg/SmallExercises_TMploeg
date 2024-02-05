import java.lang.reflect.Array;

public class TwoDimensionalArrayData<T> {
  private SnailPoint min;
  private SnailPoint max;
  private SnailPoint current;
  private SnailPoint modifier;

  private T[][] twoDimensionalArray;

  private Class<T> clazz;

  public TwoDimensionalArrayData(Class<T> clazz, T[][] twoDimensionalArray) {
    if (!isValid2DArray(twoDimensionalArray)) {
      throw new IllegalArgumentException("input must be a n*n 2 dimensional array with n >= 1");
    }

    this.twoDimensionalArray = twoDimensionalArray;

    min = new SnailPoint(0, 0);
    max = new SnailPoint(this.twoDimensionalArray.length - 1, this.twoDimensionalArray.length - 1);
    current = min;
    modifier = new SnailPoint(1, 0);

    this.clazz = clazz;
  }

  public T[] transform() {
    T[] result = createGenericArray(twoDimensionalArray.length * twoDimensionalArray.length);
    int index = 0;

    while (true) {
      result[index] = getValue(current);
      index++;

      if (index == result.length) {
        break;
      }

      SnailPoint newPoint = current.add(modifier);

      if (!isInBounds(newPoint)) {
        turn();
        newPoint = current.add(modifier);
      }

      current = newPoint;
    }

    return result;
  }

  @SuppressWarnings("unchecked")
  private T[] createGenericArray(int capacity) {
    return (T[]) Array.newInstance(clazz, capacity);
  }

  private void turn() {
    modifier = modifier.rotate();
    shrinkBounds();
  }

  private boolean isInBounds(SnailPoint point) {
    return (point.x() >= min.x()
        && point.x() <= max.x()
        && point.y() >= min.y()
        && point.y() <= max.y());
  }

  private void shrinkBounds() {
    if (modifier.x() > 0 || modifier.y() > 0) {
      min = min.add(modifier);
    } else {
      max = max.add(modifier);
    }
  }

  private T getValue(SnailPoint point) {
    return twoDimensionalArray[point.y()][point.x()];
  }

  private boolean isValid2DArray(T[][] twoDimensionalArray) {
    if (twoDimensionalArray == null || twoDimensionalArray.length == 0) {
      return false;
    }

    int length = twoDimensionalArray.length;

    for (T[] arr : twoDimensionalArray) {
      if (arr.length != length) {
        return false;
      }
    }

    return true;
  }
}
