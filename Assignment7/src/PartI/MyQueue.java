package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue<E> implements Queue<E> {
	
	private ArrayList<E> ar;
	private int elementsinQueue=0;
	private Object NoSuchElementException;
	
	MyQueue(){
		this.elementsinQueue=0;
		this.ar=new ArrayList<E>();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.elementsinQueue;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.elementsinQueue==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		this.elementsinQueue++;
		ar.add(e);
		return true;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			this.elementsinQueue--;
			return ar.remove(0);//head remove
		}
		else {
			try {
				throw (Throwable) NoSuchElementException; 
			}
			catch(Throwable throwable) {
				throwable.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			this.elementsinQueue--;
			return ar.remove(0);//head remove
		}
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			return ar.get(0);//head get
		}
		else {
			try {
				throw (Throwable) NoSuchElementException; 
			}
			catch(Throwable throwable) {
				throwable.printStackTrace();
			}
		}
		return null;
	}
	public String toString(){
        String output = "";
        for (int i = 0; i < this.elementsinQueue; i++) {
        	output += String.valueOf(ar.get(i)) + "<-";
        }
        //output += String.valueOf(ar.get(0));
        return output;
 }

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			return ar.get(0);//head get
		}
		return null;
	}
	public static void main(String[] args){
		MyQueue<Integer> ints = new MyQueue<>();
		
		if(ints.isEmpty()) 
			System.out.println("MyQueue is empty initially!"); 
		else 
			System.out.println("Integer MyQueue:"+ints.toString());
		
		System.out.println("-----------------------");
		ints.offer(34);
		ints.offer(8);
		ints.offer(26);
		ints.offer(4);
		ints.offer(50); 
		if(ints.isEmpty()) 
			System.out.println("MyQueue is empty!");
		else 
			System.out.println("Integer MyQueue:"+ints.toString()+" with no of elements "+ints.size());
		
		System.out.println("-----------------------");
		System.out.println("Integer MyQueue head/peek:= "+ints.peek());
		System.out.println("Integer MyQueue (peek is not removing):"+ints.toString()); 
		
		System.out.println("-----------------------");
		System.out.println("Integer MyQueue poll(null if stack empty):= "+ints.poll()); 
		System.out.println("Integer MyQueue after pull:="+ints.toString());
		
		System.out.println("-----------------------");
		System.out.println("Integer MyQueue poll(null if stack empty):= "+ints.poll()); 
		System.out.println("Integer MyQueue poll(null if stack empty):= "+ints.poll()); 
		System.out.println("Integer MyQueue head/element(exception if stack empty):= "+ints.element());
		System.out.println("Integer MyQueue poll(null if stack empty):= "+ints.poll()); 
		System.out.println("Integer MyQueue remove(exception if stack empty):= "+ints.remove()); 
		System.out.println("Integer MyQueue remove(exception if stack empty):= "+ints.remove());
		System.out.println("Integer MyQueue head/element(exception if stack empty):= "+ints.element());
		System.out.println("-----------------------");
		MyQueue<String> strs = new MyQueue<>();
		strs.offer("Pooja");
		strs.offer("Patel");
		strs.offer("NYU");
		System.out.println("String MyQueue:"+strs.toString());
		System.out.println("Integer MyQueue head/element(exception if stack empty):= "+strs.element());
	}
	

}
