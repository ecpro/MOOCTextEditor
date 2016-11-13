package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<>() ;
		tail = new LLNode<>();
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		if(element == null) throw new NullPointerException();
		
		LLNode<E> node = new  LLNode<>(element);
		
		if(size == 0) {
			node.prev = head;
			node.next = tail;
			head.next = node;
			tail.prev = node;
		}
		else {
			node.next = tail;
			node.prev = tail.prev;
			node.prev.next = node;
			tail.prev = node;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		LLNode<E> temp = head;
		for(int i = 0 ; i <= index; i++) {
			temp = temp.next;
		}
		
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException,NullPointerException
	{
		if(index > size || index < 0) throw new IndexOutOfBoundsException();
		if(element == null) throw new NullPointerException();
		
		if(size == 0 || index == size) {
			add(element);
			return;
		}
		
		LLNode<E> node = new LLNode<>(element);
		
		LLNode<E> tempNode = head;
		
		for(int i = 0; i <= index; i++) {
			tempNode = tempNode.next;
		}
		
		node.next = tempNode;
		node.prev = tempNode.prev;
		node.prev.next = node;
		tempNode.prev = node;
		
		size++;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		LLNode<E> tempNode = head;
		
		for(int i = 0; i <= index; i++) {
			tempNode = tempNode.next;
		}
		
		E data = tempNode.data;
		
		if(size == 1) {
			tempNode.next = null;
			tempNode.prev = null;
			head.next = null;
			tail.prev = null;
			size--;
			return data;
		}
		
		LLNode<E> previous = tempNode.prev;
		LLNode<E> next = tempNode.next;
		
		previous.next = next;
		next.prev = previous;
		tempNode.next = null;
		tempNode.prev = null;
		size--;
		return data;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
	{
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		if(element == null) throw new NullPointerException();
		
		LLNode<E> tempNode = head;
		
		for(int i = 0; i <= index; i++) {
			tempNode = tempNode.next;
		}
		
		E ele = tempNode.data;
		tempNode.data = element;
		
		return ele;
			
	}  
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode() {
		prev = null;
		next = null;
		data = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
