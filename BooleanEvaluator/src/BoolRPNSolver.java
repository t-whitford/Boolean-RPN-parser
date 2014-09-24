import java.util.HashMap;
import java.util.Stack;


public class BoolRPNSolver {
	
	HashMap<Character, Boolean> inputs;
	
	public BoolRPNSolver(HashMap<Character, Boolean> inputs) {
		this.inputs = inputs;	
	}
	
	public boolean solve(ReversePolishNotation rpn)
	{
		
		char[] rpnNotation = rpn.getNotation();
		Stack<Character> stack = new Stack<Character>();
		
		for(char c: rpnNotation)
		{
			if(!BoolOperator.isOperator(c))
			{
				stack.add(new Character(c));
			}
			else
			{
				char s1 = stack.pop().charValue();
				boolean b1;
				
				char s2;
				boolean b2 = false;
				
				if(Character.isLetter(s1))
					b1 = inputs.get(s1);
				else{
					if(s1 == '0')
						b1 = false;
					else
						b1 = true;
				}
				
				if(c != '!')
				{
					s2 = stack.pop().charValue();
					
					if(Character.isLetter(s2))
						b2 = inputs.get(s2);
					else{
						if(s2 == '0')
							b2 = false;
						else
							b2 = true;
					}
				}
				
				boolean result = false;
				switch (c) {
				case '!':
					result = !b1;
					break;
				case '+':
					result = b1 | b2;
					break;
				case '.':
					result = b1 & b2;
					break;
				case '#':
					result = b1 ^ b2;
				default:
					break;
				}
				
				if(result)
					stack.push(new Character('1'));
				else
					stack.push(new Character('0'));
				
			}
		}
		
		if(stack.pop() == '1')
			return true;
		else
			return false;
		
	}

}
