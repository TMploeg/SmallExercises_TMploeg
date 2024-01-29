public class EvenSumOfDigits{
	private static final int START = 100;
	private static final int END = 150;
	
	public static void main(String[] args){
		for(int i : evenSumOfDigits(START, END)){
			System.out.println(i);
		}
	}
	
	public static int[] evenSumOfDigits(int start, int end){
		int[] result = new int[0];
		
		for(int i = start; i <= end; i++){
			int total = 0;
			
			for(char c : Integer.toString(i).toCharArray()){
				total += (c - '0');
			}
			
			if(total % 2 == 0){
				result = addToArray(result, i);
			}
		}
		
		return result;
	}
	
	private static int[] addToArray(int[] arr, int newInt){
		int[] newArr = new int[arr.length + 1];
		
		for(int i = 0; i < arr.length; i++){
			newArr[i] = arr[i];
		}
		
		newArr[newArr.length - 1] = newInt;
		
		return newArr;
	}
}