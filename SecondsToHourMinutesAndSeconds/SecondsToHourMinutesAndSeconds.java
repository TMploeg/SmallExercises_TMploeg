public class SecondsToHourMinutesAndSeconds{
	private record Time(int hours, int minutes, int seconds) {}
	
	public static void main(String[] args){
		Time[] timeValues = {
			new Time(15, 40, 40),
			new Time(1, 10, 20),
			new Time(2, 9, 1),
			new Time(20, 31, 0)
		};
		
		for(Time t : timeValues){
			int seconds = t.hours() * (60 * 60) + t.minutes * 60 + t.seconds();
			System.out.println("convert({" + t.hours() + ", " + t.minutes() + ", " + t.seconds() + "}) -> " + convert(seconds));
		}
	}
	
	private static String convert(int seconds){
		int hours = seconds / (60 * 60);
		int remainder = seconds - hours * (60 * 60);
		
		int minutes = remainder / 60;
		remainder -= minutes * 60;
		
		return (
			convertNumberToAtLeast2DigitString(hours) + ':' +
			convertNumberToAtLeast2DigitString(minutes) + ':' +
			convertNumberToAtLeast2DigitString(remainder)
		);
	}
	
	private static String convertNumberToAtLeast2DigitString(int number){
		String nrString = "";
		nrString += number;
		
		if(nrString.length() == 1){
			nrString = '0' + nrString;
		}
		
		return nrString;
	}
}