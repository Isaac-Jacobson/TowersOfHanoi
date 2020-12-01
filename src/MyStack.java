import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * The MyStack class represents a last-in-first-out (LIFO) stack of objects.
 * MyStack uses a generic ArrayList. Your stack should work exactly like
 * java.util.Stack, except that you only have to implement a subset of the
 * methods, as shown below.
 * 
 * @param <E> the type of elements in this list
 */
public class MyStack<E> {
	private ArrayList<E> arr;

	public MyStack() {
		arr = new ArrayList<E>();
	}

	/**
	 * Pushes item onto the top of this stack
	 * 
	 * @param item the item to be pushed onto this stack
	 * @return the item argument
	 */
	public E push(E item) {
		arr.add(arr.size(), item);
		return item;
	}

	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 * 
	 * @return The object at the top of this stack (the last item)
	 * @throws EmptyStackException if stack is empty when called
	 */
	public E pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			E obj = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			return obj;
		}
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack (the last item)
	 * @throws EmptyStackException if stack is empty when called
	 */
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return arr.get(arr.size() - 1);
	}

	/**
	 * Test if Stack is empty
	 * 
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	public boolean isEmpty() {
		if (arr.size() == 0) {
			return true;
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) != null) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Returns the number of items in the stack
	 * 
	 * @return size of the stack
	 */
	public int size() {
		return arr.size();
	}

	/**
	 * Removes all the elements from the Stack. The Stack will be empty after this
	 * call (unless an exception occurs)
	 */
	public void clear() {
		arr.clear();
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * o occurs as an item in this stack, this method returns the distance from the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 *     s.push(4);
	 *     s.push(5);
	 *     s.push(6);
	 *     s.search(6); // 1
	 *     s.search(5); // 2
	 *     s.search(4); // 3
	 *     s.search(27) // -1
	 * </pre>
	 * 
	 * @param o the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	public int search(Object o) {
		for (int i = arr.size() - 1; i >= 0; i--) {
			if (arr.get(i).equals(o)) {
				return arr.size() - i;
			}
		}

		return -1;
	}

	/**
	 * Returns true if this stack contains the specified element. More formally,
	 * returns true if and only if this stack contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param o element whose presence in this ArrayList is to be tested
	 * @return true if this ArrayList contains the specified element
	 */
	public boolean contains(Object o) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(o)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * stack, or -1 if this ArrayList does not contain the element. This is the
	 * index in the underlying ArrayList, NOT the position in the stack as defined
	 * in the search function. More formally, returns the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * 
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in this
	 *         ArrayList, or -1 if this ArrayList does not contain the element
	 */
	public int indexOf(Object o) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(o)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * stack, or -1 if this ArrayList does not contain the element. This is the
	 * index in the underlying ArrayList, NOT the position in the stack as defined
	 * in the search function. More formally, returns the highest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * 
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element in this
	 *         stack
	 */
	public int lastIndexOf(Object o) {
		int f = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(o)) {
				f = i;
			}
		}

		return f;
	}

	/**
	 * String representation of a stack. <br>
	 * Format is the same as {@link ArrayList#toString()} and the order is from
	 * bottom of the stack to the stop.
	 * 
	 * @return string representation of a stack
	 */
	public String toString() {
		if (this.isEmpty() || arr.size() == 0) {
			return "[]";
		}
		String f = "[" + arr.get(0).toString();
		for (int i = 1; i < arr.size(); i++) {
			f += ", " + arr.get(i).toString();
		}
		return f + "]";
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index index of the element to return. This is the index in the
	 *              underlying ArrayList, NOT the position in the stack as defined
	 *              in the search function.
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= arr.size()) {
			throw new IndexOutOfBoundsException();
		}
		return arr.get(index);
	}

}
