public class ReverseAnInteger{
	public static void main(String[] args){
		int[] values = {531,221,3421,40,1258,48951424};
		
		for(int value : values){
			System.out.println("reserseInt(" + value + ") -> " + reverseInt(value));
		}
	}
	
	private static String reverseInt(int number){
		String intString = Integer.toString(number);
		
		String reverseString = "";
		
		for(int i = intString.length() - 1; i >= 0; i--){
			reverseString += intString.charAt(i);
		}
		
		return reverseString;
	}
}