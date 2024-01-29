public class LastDigit{
	public static void main(String[] args){
		System.out.println(lastDigit(11,31));
		System.out.println(lastDigit(20,30));
		System.out.println(lastDigit(21,22));
		System.out.println(lastDigit(10,9));
		System.out.println(lastDigit(9,99));
	}
	
	private static boolean lastDigit(int n1, int n2){
		return (n1 % 10) == (n2 % 10);
	}
}