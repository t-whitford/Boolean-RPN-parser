import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


public class ReversePolishNotation {
	
	char[] notation;
	int pos;
	
	public ReversePolishNotation(int len)
	{
		notation = new char[len];
		pos = 0;
	}
	
	public char[] getNotation()
	{
		return notation;
	}
	
	public void addToOutput(char c) throws Exception
	{
		if(pos >= notation.length)
			throw new Exception("Parsing error : more arguments than expected");
		else{
			notation[pos] = c;
			pos++;
		}
		
	}

	public void print()
	{
		String s = new String(notation);
		System.out.println(s);
	}
	public static ReversePolishNotation parseInput(String inp) throws Exception
	{
		System.out.println(inp);
		
		inp = inp.replaceAll("\\s", "");
		
		System.out.println(inp);
		
		char[] chars = inp.toCharArray();
		
		//count brackets
		int count = chars.length;
		
		for(char c: chars){
			if(c == '(' || c == ')')
				count--;
		}
		
	
		ReversePolishNotation result = new ReversePolishNotation(count);
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c: chars)
		{
			if(Character.isAlphabetic(c)){
				result.addToOutput(c);
			} 
			else if(c == '('){
				stack.push(new Character(c));
			}
			else if(c == ')'){
				char pop;
				while((pop = stack.pop().charValue()) != '(')
				{
					result.addToOutput(pop);
				}
			}
			else {
				try {
					BoolOperator.type(c);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				if(stack.isEmpty())
					stack.push(new Character(c));
				
				else if(stack.peek().charValue() == '(')
					stack.push(new Character(c));
				
				else{
					
					try{
						while(stack.peek().charValue() != '('){
							BoolOperator o1 = BoolOperator.type(c);
							BoolOperator o2 = BoolOperator.type(stack.peek().charValue());
							if(o1.compareTo(o2) > 0 || (o1.compareTo(o2) == 0 && o2.leftAssociative()))
							{
								result.addToOutput(stack.pop().charValue());

							} else
								break;
						}
					} catch(EmptyStackException e)
					{
						
					}
					stack.push(new Character(c));
				}
				
			}
		}
		
		while(!stack.isEmpty())
		{
			result.addToOutput(stack.pop().charValue());
		}
		
		
		return result;
		
	}

}
