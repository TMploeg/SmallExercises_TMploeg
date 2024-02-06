public interface InputProcessor<TResult> {
  public Result<TResult> execute(String input);
}
