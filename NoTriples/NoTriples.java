import java.util.HashMap;

public class NoTriples{
	public static void main(String[] args){
		System.out.println("noTriples(1, 2, 3, 4, 5) -> " + noTriples(1, 2, 3, 4, 5));
		System.out.println("noTriples(1, 1, 1, 2, 3) -> " + noTriples(1, 1, 1, 2, 3));
		System.out.println("noTriples(1, 1, 2, 2, 3) -> " + noTriples(1, 1, 2, 2, 3));
		System.out.println("noTriples(1, 2, 2, 3, 3) -> " + noTriples(1, 2, 2, 3, 3));
		System.out.println("noTriples(1, 2, 2, 2, 3) -> " + noTriples(1, 2, 2, 2, 3));
		System.out.println("noTriples(1, 2, 2, 3, 2) -> " + noTriples(1, 2, 2, 3, 2));
	}
	
	public static boolean noTriples(int... numbers){
		int i = 0;
		
		while(i < numbers.length - 2){
			if(numbers[i] != numbers[i + 1]){
				i += 1;
				continue;
			}
			
			if(numbers[i] == numbers[i + 2]){
				return false;
			}
			
			i += 2;
		}
		
		return true;
	}
}