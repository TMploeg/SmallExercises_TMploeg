import java.util.ArrayList;

public class Snail{
	public static void main(String[] args){
		ArrayList<Integer[][]> snailList = new ArrayList<>();
		snailList.add(new Integer[][]{
			new Integer[]{1, 2, 3},
			new Integer[]{4, 5, 6},
			new Integer[]{7, 8, 9}
		});
		snailList.add(new Integer[][]{
			new Integer[]{1, 2, 3, 2, 2},
			new Integer[]{4, 5, 6, 3, 3},
			new Integer[]{7, 8, 9, 4, 4},
			new Integer[]{7, 8, 9, 5, 5},
			new Integer[]{7, 8, 9, 6, 6}
		});
		
		for(Integer[][] snail : snailList){
			Integer[] result = snail(Integer.class, snail);
			
			System.out.println("SNAIL: " + snailToString(snail) + " -> " + arrayToString(result));
		}
	}
	
	private static <T> String arrayToString(T[] arr){
		String output = "";
		
		output += "  { ";
		
		for(int i = 0; i < arr.length; i++){
			if(i != 0){
				output += ", ";
			}
			
			output += arr[i];
		}
		
		output += " }";
		
		return output;
	}
	
	private static <T> String snailToString(T[][] snail){
		String output = "";
		
		output += "{\n";
		
		for(T[] arr : snail){
			output += "  " + arrayToString(arr) + ",\n";
		}
			
		output += "}";
		
		return output;
	}
	
	private static <T> T[] snail(Class<T> clazz, T[][] arr2D){
		TwoDimensionalArrayData<T> data = new TwoDimensionalArrayData<>(clazz, arr2D);
		return data.transform();
	}
}