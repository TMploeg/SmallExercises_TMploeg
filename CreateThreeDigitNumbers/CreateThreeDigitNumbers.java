import java.lang.Math;
import java.util.LinkedList;

public class CreateThreeDigitNumbers{
	public static void main(String[] args){
		LinkedList<Integer> numbers = getAllUniqueNDigitNumberRecursive(new int[]{1, 2, 3, 4}, 3);
		
		for(int n : numbers){
			System.out.println(n);
		}
		
		System.out.println("amount of numbers: " + numbers.size());
	}
	
	private static LinkedList<Integer> getAllUniqueNDigitNumberRecursive(int[] availableDigits, int digitsPerNumber){
		int availableDigitCount = availableDigits.length;
		
		if(digitsPerNumber == 0){
			return new LinkedList<Integer>();
		}
		
		LinkedList<Integer> numbers = new LinkedList<>();
		
		if(digitsPerNumber == 1){
			for(int digit : availableDigits){
				numbers.add(digit);
			}
			
			return numbers;
		}
		
		for(int i = 0; i < availableDigitCount; i++){
			int[] newDigits = removeElementFromArray(availableDigits, i);
			
			for(int number : getAllUniqueNDigitNumberRecursive(removeElementFromArray(availableDigits, i), digitsPerNumber - 1)){
				numbers.add(availableDigits[i] * (int)Math.pow(10, digitsPerNumber - 1) + number);
			}
		}
		
		return numbers;
	}
	
	private static int[] removeElementFromArray(int[] arr, int targetId){
		int[] newArr = new int[arr.length - 1];
		int newArrIndex = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(i != targetId){
				newArr[newArrIndex] = arr[i];
				newArrIndex++;
			}
		}
		
		return newArr;
	}
}