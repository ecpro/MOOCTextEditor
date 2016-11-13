/**
 * 
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			a = emptyList.remove(0);
			fail("check for empty list condition handing");

		} catch (IndexOutOfBoundsException e) {
		
		}
		
		shortList.remove(0);
		shortList.remove(0);
		
		assertEquals("check size is 0", 0, shortList.size());
		
		int x = longerList.get(4);
		int s = longerList.size();
		assertEquals("check for equality",(Integer) x, longerList.remove(4));
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		try {
			shortList.add(null);
			fail("check for Null value insertion in the list");
		}catch (NullPointerException e) {

		}
		
		try {
			int size = longerList.size();
			longerList.add(34);
			//emptyList.add(4);
			//assertEquals("check for size increment", 1 , emptyList.size());
			assertEquals("check for size increment in long array", size + 1, longerList.size());
			
		}catch(NullPointerException e) {

		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		int size = emptyList.size();
		assertEquals("check for O in the empty list", 0, size);
		assertEquals("check for size",LONG_LIST_LENGTH, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		try {
			emptyList.add(3, 4);
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	
		try {
			shortList.add(1, null);
			fail("check null value arguments");
		}
		catch(NullPointerException e) {
			
		}
		
		try {
			shortList.add(1,"Z");
			assertEquals("check for prev value", "A", shortList.get(0));
			assertEquals("check for neighbouring values", "B", shortList.get(2));
			assertEquals("check for list size", 3, shortList.size());
			shortList.add(6, "C");
			fail("check for IndexOutOfBounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    try {
	    	emptyList.set(0, 4);
	    	fail("check for the IndexOutOfBoundException");
	    }catch(IndexOutOfBoundsException e) {
	    	
	    }
	    
	    try {
	    	shortList.set(1, null);
	    	fail("check for null element values");
	    }catch(NullPointerException e) {
	    	
	    }
	    
	    try {
	 
	    	shortList.set(23, "245");
	    	fail("check for indexOutOfBoundException");
	    }catch(IndexOutOfBoundsException e) {
	    	
	    }
	    
	    int s = longerList.get(0);
	    assertEquals("check for equality", (Integer)s, longerList.set(0, 234));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
