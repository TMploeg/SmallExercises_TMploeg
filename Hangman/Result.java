public record Result<TValue>(boolean succes, TValue value, String errorMessage) {
  public static <T> Result<T> succesResult(T value) {
    return new Result<T>(true, value, null);
  }

  public static <T> Result<T> errorResult(String errorMessage) {
    return new Result<T>(false, null, errorMessage);
  }
}
