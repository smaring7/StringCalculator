package is.ru.StringCalculator;

public class Calculator {
	
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		else if(text.contains(",") || text.contains("\n")) {
			String numbers[] = text.split("[, \n]");
			return sum(numbers);
		}
		return 1;
	}
	
	private static int toInt(String number) {
		return Integer.parseInt(number);
	}
	
	private static int sum(String[] numbers) {
		int total = 0;
		String negatives = "";
			for(String number : numbers) {
				if(number.contains("-")) {
					if(negatives == "")
						negatives = negatives + number;
					else
						negatives = negatives + "," + number;
				}
				
				total += toInt(number);
			}
			if(negatives != "") 
				throw new IllegalArgumentException("Negatives not allowed: " + negatives);
				
			
			return total;
	}
}