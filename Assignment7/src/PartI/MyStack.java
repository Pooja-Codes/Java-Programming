package PartI;
import java.util.ArrayList;

public class MyStack<E> {

	private ArrayList<E> ar;
	private int top=-1;
	
	MyStack(){
		this.ar=new ArrayList<E>();
	}
	
	public boolean empty() {
		return top==-1;
	}
	
	public E peek() {
		if(top==-1)
			return null;//System.out.println("MyStack is empty!");
		else
			return ar.get(top);
	}
	
	public E pop() {
		if(top==-1) {
			return null;//System.out.println("MyStack is empty!");
		}
		else {
			E temp=ar.get(top);
			top--;
			return temp;
		}
	}
	
	public E push(E item) {
		top++;
		ar.add(item);
		return item;
	}
	
	public int search(Object o) {
		int output=-1;
		int temp=top;
		while(temp!=-1 && ar.get(temp)!=o) {
			temp--;
		}
		output=temp;
		if(output==-1) {//element not present
			return -1; //to return -1
		}
		return output+1;//1 based index output
	}
	
	public String toString(){
	        String output = "";
	        for (int i = 0; i < top; i++) {
	        	output += String.valueOf(ar.get(i)) + "->";
	        }
	        output += String.valueOf(ar.get(top));
	        return output;
	 }
		
	 public static void main(String[] args){
		MyStack<Integer> ints = new MyStack<>();
		
		if(ints.empty()) 
			System.out.println("MyStack is empty initially!"); 
		else 
			System.out.println("Integer MyStack:"+ints.toString());
		
		System.out.println("-----------------------");
		ints.push(34);
		ints.push(8);
		ints.push(26);
		ints.push(4);
		ints.push(50); 
		if(ints.empty()) 
			System.out.println("MyStack is empty!");
		else 
			System.out.println("Integer MyStack:"+ints.toString());
		
		System.out.println("-----------------------");
		System.out.println("Integer MyStack top/peek:= "+ints.peek());
		System.out.println("Integer MyStack (peek is not removing):"+ints.toString()); 
		
		System.out.println("-----------------------");
		System.out.println("Integer MyStack pop(null if stack empty):= "+ints.pop()); 
		System.out.println("Integer MyStack after pop:="+ints.toString());
		
		System.out.println("-----------------------");
		System.out.println("Integer MyStack index (1 based) Search for 8 (-1 if not found):= "+ints.search(8));
		System.out.println("Integer MyStack index (1 based) Search for 64 (-1 if not found):= "+ints.search(64)); 
		
		System.out.println("-----------------------");
		MyStack<String> strs = new MyStack<>();
		strs.push("Pooja");
		strs.push("Patel");
		strs.push("NYU");
		System.out.println("String MyStack:"+strs.toString());
		System.out.println("String MyStack index (1 based) Search for NYU (-1 if not found):= "+strs.search("NYU"));
		
	}
}
