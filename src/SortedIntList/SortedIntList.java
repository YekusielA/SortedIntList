package SortedIntList;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Yekusiel Allen
 * CSC143
 * J. Toutonghi
 * 
 * A class for a sorted integer list.
 * The user has the option of allowing or banning duplicate inputs, and
 * also allows for this setting to be changed as needed. The list is automatically
 * sorted as numbers are added. Various methods are included.
 */
public class SortedIntList {
	private int[] elementData;
	private int size;
	private boolean unique;
	private static final boolean DEFAULT_UNIQUE = false;
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Constructor that accepts two parameters, unique and capacity.
	 * 
	 * @param unique Determines whether or not the object is allowed to hold duplicate values (true: cannot, false: can).
	 * @param capacity Determines the inital length of elementData.
	 */
	public SortedIntList(boolean unique, int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Please enter a capacity greater than 0.");
		}
		this.unique = unique;
		elementData = new int[capacity];
	}
	
	/**
	 * Constructor that accepts one parameter, unique,
	 * and uses a default value for capacity.
	 * 
	 * @param unique Determines whether or not the object is allowed to hold duplicate values (true: cannot, false: can).
	 */
	public SortedIntList(boolean unique) {
		this.unique = unique;
		elementData = new int[DEFAULT_CAPACITY];
	}

	/**
	 * Constructor that accepts one parameter, capacity,
	 * and uses a default value for unique.
	 * 
	 * 
	 * @param @param capacity Determines the inital length of elementData.
	 */
	public SortedIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Please enter a capacity greater than 0.");
		}
		this.unique = DEFAULT_UNIQUE;
		elementData = new int[capacity];
	}

	/**
	 * Constructor that uses default values for 
	 * both unique and capacity.
	 */
	public SortedIntList() {
		this.unique = DEFAULT_UNIQUE;
		elementData = new int[DEFAULT_CAPACITY];
	}
	
	/**
	 * Adds a number to the start of elementData.
	 * If unique == true, binary searching is utilized
	 * to ensure the given value has not yet been added.
	 * 
	 * @param value Value that will be added to elementData[].
	 */
	public void add(int value) {
		if(unique == true) {
			if (indexOf(value) < 0) {
				size++;
				add(0, value);
			}
		} else if (unique == false) {
			size++;
			add(0, value);
		}
	}
	
	/**
	 * Removes the value at the given index of elementData.
	 * 
	 * @param index Index of the value that is to be removed.
	 */
	public void remove(int index) {
		checkIndex(index);
		for(int i = index; i < size; i++) { // Left shifts the indices after index.
			elementData[i] = elementData[i + 1];
		}
		size--; // Decrements size to account for the removed number.
	}
	
	/**
	 * Returns the value held at the given index.
	 * 
	 * @param index Index of the number that is returned.
	 * @return Returns the value stored at elementData[index].
	 */
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	
	/**
	 * Returns the functional size of the SortedIntList.
	 * 
	 * returns Returns the size of the object.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @returns Returns whether or not elementData is empty.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the index of the given value. If the value is not 
	 * in elementData, the negative position is given.
	 * 
	 * @param value The value which the method will return an index for.
	 * @return Returns the index of value (returns negative position if value is not present).
	 */
	public int indexOf(int value) {
		return Arrays.binarySearch(elementData, 0, size, value);
	}
	
	/**
	 * @return Returns the largest number held in elementData[].
	 * @throws Throws NoSuchElementException if elementData is empty.
	 */
	public int max() {
		if(isEmpty()) { // Throws exception if elementData is empty.
			throw new NoSuchElementException("elementData is empty.");
		} else { // Loops through the list until the largest number is found.
			int max = elementData[0];
			for(int i = 0; i < size - 1; i++) {
				if (elementData[i] > max) {
					max = elementData[i];
				}
			}
			return max;
		}
	}
	
	/**
	 * @return Returns the smallest number held in elementData[].
	 * @throws Throws NoSuchElementException if elementData is empty.
	 */
	public int min() {
		if(isEmpty()) {
			throw new NoSuchElementException("elementData is empty.");
		} else { // Loops through elementData until the smallest number is found.
			int min = elementData[0];
			for(int i = 0; i < size - 1; i++) {
				if (elementData[i] < min) {
					min = elementData[i];
				}
			}
			return min;
		}
	}

	/**
	 * Uses binary searching to locate occurences of a given value, counting
	 * how many times the value is found.
	 * 
	 * @param value Integer that is to be counted within elementData.
	 * @returns count Number of occurences of value within elementData.
	 */
	public int count(int value) {
		SortedIntList temp = new SortedIntList(0); // Create and fill temporay copy of this 
		for(int i = 0; i < size; i++) {
			temp.add(elementData[i]);
		}
		
		boolean lastNum = true; 
		int count = 0;
		while(lastNum == true) {
			if (Arrays.binarySearch(temp.elementData, 0, size, value) < 0) { // Returns count when binarySearch() results in a negative position value.
				return count;
			}
			if (elementData[Arrays.binarySearch(temp.elementData, 0, size, value)] == value) { // Increments count when an occurrence of value is found
				temp.remove(Arrays.binarySearch(temp.elementData, 0, size, value)]);
				count++;
			}
		}
		return count; // Doesn't like this being removed :/
	}
	
	/**
	 * @return Returns the value of unique.
	 */
	public boolean getUnique() {
		return unique;
	}
	
	/**
	 * Sets unique to the given value.
	 * 
	 * @param unique The value for unique which the method will set unique to.
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
		
		for(int i = 0; i < size - 1; i++) { // Remove Duplicates.
			if (elementData[i] == elementData[i + 1]) {
				remove(i);
				i--;
			}
		}
	}
	
	/**
	 * @return Returns a string representation of elementData[] (from elementData[0] to elementData[size]). <---- CHECK THIS TO ENSURE ACCURATE!
	 */
	public String toString(){
		if(isEmpty()) {
			return "[]";
		} else {
			String temp = "[";
			for(int i = 0; i < size - 1; i++){
				temp = temp +  elementData[i] + ", ";
			}
			return temp + this.get(size - 1) + "]";
		}
		
	}
	
	/**
	 * Checks the given index to ensure it exists. If not, an error is thrown.
	 * 
	 * @param index Index checked to ensure it exists.
	 * @throws Throws IndexOutOfBoundsException if elementData[index] either doesn't exist, or is >= elementData[size].
	 */
	private void checkIndex(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds. \n\t Size: " + 
																size + "\n\t Length: " + elementData.length);
		}
	}
	
	/**
	 * Ensures that size is large enough.
	 * 
	 * @param neededCapacity Amount of indices needed.
	 */
	private void ensureCapacity(int neededCapacity) {
		if (elementData.length < neededCapacity){
			int newCapacity = 2 * elementData.length + 1;
			if (newCapacity < neededCapacity){
				newCapacity = neededCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
 		
	/**
	 * Adds a number and sorts elementData.
	 * 
	 * @param index Index where value will be added to the list.
	 * @param value Value that is added at elementData[index].
	 */
	private void add(int index, int value) {
		checkIndex(index);
		ensureCapacity(size + 1);
		for(int i = size - 1; i >= index; i--){
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = value;
		
		for(int i = 0; i < size; i++) { // Sort elementData.
			int smallest = i;
			for(int j = i; j < size; j++) {
				if(elementData[j] < elementData[smallest]) {
					smallest = j;
				}
			}
			int hold = elementData[i];
			elementData[i] = elementData[smallest];
			elementData[smallest] = hold;
		}
		
	}
}