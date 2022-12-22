package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<Character> charstack = new MyStack<>();
		for(int i=0;i<inString.length();i++) {
			char c=inString.charAt(i);
			if(c=='(') {
				charstack.push(c);
				continue;
			}
			if(c==')') 
				charstack.pop();
		}
		return charstack.empty();
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println("isBalanced(\"(()()()())\") result:= "+result);//true
		
		result = isBalanced("(((())))");
		System.out.println("isBalanced(\"(((())))\") result:= "+result);//true
		
		result = isBalanced("((((((())");
		System.out.println("isBalanced(\"((((((())\") result:= "+result);//false
	}
}
