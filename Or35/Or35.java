public class Or35{
	public static void main(String[] args){
		System.out.println("TRUE or35(3) -> " + or35(3));
		System.out.println("TRUE or35(10) -> " + or35(10));
		System.out.println("FALSE or35(8) -> " + or35(8));
	}
	
	private static boolean or35(int n){
		return (n % 3 == 0) || (n % 5 == 0);
	}
}