package is.ru.StringCalculator;

public class Calculator {
	
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		else if(text.startsWith("//")) {
			String textParts[] = text.split("[// \n]");
			String delimiter = textParts[2];
			String numbers[] = textParts[3].split(delimiter);
			checkForNegatives(numbers);
			return sum(numbers);
		}
		else if(text.contains(",") || text.contains("\n")) {
			String numbers[] = text.split("[, \n]");
			checkForNegatives(numbers);
			return sum(numbers);
		}
		return 1;
	}
	
	private static int toInt(String number) {
		return Integer.parseInt(number);
	}
	
	private static int sum(String[] numbers) {
		int total = 0;
			for(String number : numbers) {
				if(toInt(number) < 1000)
					total += toInt(number);
			}
			return total;
	}
	
	private static void checkForNegatives(String[] numbers) {
		String negatives = "";
			for(String number : numbers) {
				if(number.contains("-")) {
					if(negatives == "")
						negatives = negatives + number;
					else
						negatives = negatives + "," + number;
				}
				
				if(negatives != "") 
				throw new IllegalArgumentException("Negatives not allowed: " + negatives);
			}
	}
}