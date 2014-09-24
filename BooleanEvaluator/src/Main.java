import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ReversePolishNotation rpn = null;
		
		try {
			rpn = ReversePolishNotation.parseInput("(A#B).C + A.B");
			rpn.print();
			
			TreeMap<Character, Boolean> map = new TreeMap<>();
			map.put('A', true);
			map.put('B', false);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		} 


	}

}
