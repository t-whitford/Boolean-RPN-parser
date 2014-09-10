import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("Enter the boolean expression (please use # as the symbol for XOR) :");
		Scanner scanner = new Scanner(System.in);
		//String inp = scanner.nextLine();
	
		ReversePolishNotation rpn = null;
		
		try {
			rpn = ReversePolishNotation.parseInput("(A#B).C + A.B");
			//rpn = ReversePolishNotation.parseInput(inp);
			rpn.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		} 


	}

}
