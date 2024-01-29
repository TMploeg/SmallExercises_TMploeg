public class NotString{
	private static final String NOT = "not";
	
	public static void main(String[] args){
		
	}
	
	public static String notString(String str){
		String result = str;
		
		if(!(str.length() >= 3 && str.substring(0,3).equals(NOT))){
			result = NOT + " " + result; 
		}
		
		return result;
	}
}