package chap3;

public class Help {

	void helpOn(int what) {
		switch (what) {
		case '1':
			System.out.println("The if:\n");
			System.out.println(" If(condition) statement;");
			System.out.println("else statement;");
			break;

		case '2':
			System.out.println("The switch :\n");
			System.out.println("switch(expression){");
			System.out.println(" case constant:");
			System.out.println(" statement sequence");
			System.out.println(" break;");
			System.out.println(" // . . .");
			System.out.println("}");
			break;

		case '3':
			System.out.println("The for :\n");
			System.out.println("for(init;condition;iteration)");
			System.out.println(" statement;");

		case '4':
			System.out.println("The while :\n");
			System.out.println("while(condition) statement;");
			break;

		case '5':
			System.out.println("The do-while :\n");
			System.out.println("do {");
			System.out.println(" statement;");
			System.out.println("} while (condition);");
			break;
		default:
			System.out.print("Selection not found.");

		}
	}

	void showMenu() {
		System.out.println("Help on:");
		System.out.println(" 1. if");
		System.out.println(" 2. switch");
		System.out.println(" 3. for");
		System.out.println(" 4. while");
		System.out.println(" 5. do-while\n");
		System.out.println(" 6. break\n");
		System.out.println(" 7. continue\n");
		System.out.println("Choose one (q to quit): ");
	}

	boolean isValid(int ch) {
		if (ch < '1' | ch > '7' & ch != 'q')
			return false;
		else
			return true;
	}

}
