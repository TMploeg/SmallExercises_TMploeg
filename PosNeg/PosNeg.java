public class PosNeg{
	public static void main(String[] args){
		System.out.println("posNeg(1, -1, false) -> " + posNeg(1, -1, false));
		System.out.println("posNeg(1, -1, true) -> " + posNeg(1, -1, true));
		System.out.println("posNeg(1, 1, true) -> " + posNeg(1, 1, true));
		System.out.println("posNeg(1, 1, false) -> " + posNeg(1, 1, false));
		System.out.println("posNeg(-1, -1, true) -> " + posNeg(-1, -1, true));
		System.out.println("posNeg(-1, -1, false) -> " + posNeg(-1, -1, false));
	}
	
	public static boolean posNeg(int i1, int i2, boolean negative){
		boolean i1Negative = i1 < 0;
		boolean i2Negative = i2 < 0;
		boolean bothNegative = i1Negative && i2Negative;
		
		if(negative){
			return bothNegative;
		}
		
		return (i1Negative || i2Negative) && !bothNegative;
	}
}