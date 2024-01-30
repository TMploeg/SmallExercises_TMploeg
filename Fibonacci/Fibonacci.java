import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci{
	private static String output = "";
	
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("no args detected");
			return;
		}
		
		try{
			int number = Integer.parseInt(args[0]);
			fib(number);
			System.out.println(output);
		}
		catch(NumberFormatException e){
			System.out.println("'" + args[0] + "' is not an integer");
		}
	}
	
	public static void fib(int n){
		if(n == 0){
			addNumberToOutput(BigInteger.valueOf(0));
			return;
		}
		
		BigInteger current = BigInteger.valueOf(1);
		BigInteger previous = BigInteger.valueOf(1);
		
		int startIndex = 2;
		
		addNumberToOutput(previous);
		addNumberToOutput(current);
		
		for(int i = startIndex; i <= n; i++){
			BigInteger temp = current;
			current = current.add(previous);
			previous = temp;
			
			addNumberToOutput(current);
		}
	}
	
	
	private static void addNumberToOutput(BigInteger n){
		if(output.length() > 0){
			output += " ";
		}
		
		output += n;
	}
}