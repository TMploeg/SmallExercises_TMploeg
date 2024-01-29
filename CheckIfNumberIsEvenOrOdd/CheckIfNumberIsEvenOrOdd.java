public class CheckIfNumberIsEvenOrOdd{
	public static void main(String[] args){
		int[] numbers = { 1, 2, 20, 31, 102155342 };
		for(int n : numbers){
			System.out.println("checkIfEventOrOdd(" + n + ") -> " + checkIfEvenOrOdd(n));
		}
	}
	
	public static int checkIfEvenOrOdd(int n){
		return n % 2 == 0 ? 1 : 0;
	}
}