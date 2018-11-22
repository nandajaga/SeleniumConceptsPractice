package seleniumSession;

import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {

		Random generator = new Random();
		int startPHNo = 4614;
		int randNo = generator.nextInt(1111) + 10000;
		String TNBeginRange = Integer.toString(startPHNo) + Integer.toString(randNo);
		System.out.println("TNBeginRange : " + TNBeginRange);
		
	}

}
