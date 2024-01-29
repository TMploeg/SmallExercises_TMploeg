import java.lang.Math;

public class Max1020{
	private static final int RANGE_MIN = 10;
	private static final int RANGE_MAX = 20;
	
	public static void main(String[] args){
		int[][] values = new int[][]{
			{1,1},
			{2,2},
			{10,20},
			{10,30},
			{9,20},
			{9,21}
		};
		
		for(int[] arr : values){
			System.out.println("max1020(" + arr[0] + ", " + arr[1] + ") -> " + max1020(arr[0],arr[1]));	
		}
	}
	
	private static int max1020(int i1, int i2){
		int highest = Math.max(i1, i2);
		int lowest = Math.min(i1, i2);
		
		if(highest < RANGE_MIN || lowest > RANGE_MAX){
			return 0;
		}
		
		if(highest <= RANGE_MAX){
			return highest;
		}
		
		return lowest >= RANGE_MIN ? lowest : 0;
	}
}