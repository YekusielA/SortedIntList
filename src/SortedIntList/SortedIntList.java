package SortedIntList;

import java.util.*;

/**
 * @author Yekusiel Allen
 * CSC143
 * J. Toutonghi
 * 
 * Add description here
 */
public class SortedIntList {
	private int[] elementData;
	private int size;
	private boolean unique;
	private static final boolean DEFAULT_UNIQUE = false;
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
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
	 * @param unique Determines whether or not the object is allowed to hold duplicate values (true: cannot, false: can).
	 */
	public SortedIntList(boolean unique) {
		this.unique = unique;
		elementData = new int[DEFAULT_CAPACITY];
	}

	/**
	 * @param @param capacity Determines the inital length of elementData.
	 */
	public SortedIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Please enter a capacity greater than 0.");
		}
		this.unique = DEFAULT_UNIQUE;
		elementData = new int[capacity];
	}

	// Finished.
	public SortedIntList() {
		this.unique = DEFAULT_UNIQUE;
		elementData = new int[DEFAULT_CAPACITY];
	}
	
	/**
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
	 * @param index Index of the value that is to be removed.
	 */
	public void remove(int index) {
		checkIndex(index);
		for(int i = index; i < size; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}
	
	/**
	 * @param index Index of the number that is returned.
	 * @return Returns the value stored at elementData[i].
	 */
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	
	/**
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
	 * @param value The value which the method will return an index for.
	 * @return Returns the index of value (returns negative position if value is not present).
	 */
	public int indexOf(int value) {
		return Arrays.binarySearch(elementData, 0, size, value);
	}
	
	/**
	 * @return Returns the largest number held in elementData[].
	 */
	public int max() {
		if(isEmpty()) {
			throw new NoSuchElementException("elementData is empty.");
		} else {
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
	 */
	public int min() {
		if(isEmpty()) {
			throw new NoSuchElementException("elementData is empty.");
		} else {
			int min = elementData[0];
			for(int i = 0; i < size - 1; i++) {
				if (elementData[i] < min) {
					min = elementData[i];
				}
			}
			return min;
		}
	}
	
	// Returns the number of times the given value occurs in the list.
	// Utilizes indexOf(value) to avoid sequential search, then 
	// moves forward and back from there to get total 
	// (note: binary search returns an index of value, but not necessarily 1st).
	// DON'T USE SEQUENTIAL SEARCHING!
	public int count(int value) {
		int count = 0;
		if(indexOf(value) < 0) {
			for(int i = 0; i < size; i++) {
				if(elementData[i] == value) {
					count++;
				}
			}
			return count;
		} else if(indexOf(value) == 0) {
			return count;
		} else {
			return count;
		}
	}
	
	/**
	 * @return Returns the value of unique.
	 */
	public boolean getUnique() {
		
		return unique;
	}
	
	/**
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
