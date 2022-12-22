package PartII;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
		MathSet<E> output=new MathSet<E>();
		for (E element : s2) {
			if(this.contains(element))
				output.add(element);
		}
		return output;
	}
	
	public Set<E> union(Set<E> s2) {
		MathSet<E> output=new MathSet<E>();
		for(E element : this)
			output.add(element);
		for(E element:s2)
			output.add(element);
		return output;
	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E,T>> output=new MathSet<Pair<E,T>>();
		for(E element1:this) {
			for(T element2:s2) {
				output.add(new Pair<E,T>(element1,element2));
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> set1 = new MathSet<Integer>();
		MathSet<Integer> set2 = new MathSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println("Set1 and Set2 Interaction: "+set1.intersection(set2));
		System.out.println("Set1 and Set2 Union: "+set1.union(set2));
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<String> set3 = new MathSet<String>();
		
		set3.add("H");
		set3.add("T");
		
		System.out.println("set1 and set3 Cartesian Product: "+set1.cartesianProduct(set3));
	}
}
