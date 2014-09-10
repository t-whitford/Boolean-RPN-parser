public enum BoolOperator {
	
	NOT (false),
	AND (true),
	XOR (true),
	OR (true);
	
	private final boolean leftAssociative;
	
	private BoolOperator(boolean leftAssociative) {
		this.leftAssociative = leftAssociative;
	}
	
	public boolean leftAssociative()
	{
		return leftAssociative;
	}
	
	public boolean logicGate()
	{
		return false;
	}
	
	public static BoolOperator type(char c) throws Exception
	{
		switch (c) {
		case '!':
			return NOT;
		case '.':
			return AND;
		case '#':
			return XOR;
		case '+':
			return OR;
		default:
			throw new Exception("Unknown character " + c);
		}
	}
}