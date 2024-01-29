public class Front22{
	public static void main(String[] args){
		String[] values = {
			"text",
			"Meow",
			"HiHi",
			"",
			"e"
		};
		
		for(String value : values){
			System.out.println("front22(\"" + value + "\") -> \"" + front22(value) + '\"');
		}
	}
	
	public static String front22(String text){
		String part;
		
		if(text.length() > 1){
			part = text.substring(0,2);
		}
		else if(text.length() == 1){
			part = Character.toString(text.charAt(0));
		}
		else{
			part = "";
		}
		
		return part + text + part;
	}
}