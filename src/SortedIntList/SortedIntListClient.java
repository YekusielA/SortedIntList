package SortedIntList;


/**
 * @author Yekusiel Allen
 * 
 */
public class SortedIntListClient {
	public static void main(String[] args) {
		SortedIntList list1 = new SortedIntList(false, 0);
		SortedIntList list2 = new SortedIntList(true, 0);
		
		System.out.println("list1, unique = false");
		System.out.println("list2, unique = true\n");
		
		System.out.println("add() Test: ");
		list1.add(2);
		list1.add(5);
		list1.add(7);
		list1.add(56);
		list1.add(5);
		list1.add(56);
		list1.add(5);
		list2.add(2);
		list2.add(5);
		list2.add(7);
		list2.add(56);
		list2.add(5);
		list2.add(56);
		list2.add(5);
		System.out.println("\tlist1: " + list1.toString());
		System.out.println("\tlist2: " + list2.toString());
		
		System.out.println("\nremove() Test: ");
		list1.remove(1);
		list1.remove(1);
		list1.remove(1);
		list1.remove(1);
		System.out.println("\tlist1, 5's and 7: " + list1.toString());
		
		System.out.println("\nsetUnique() Test: ");
		list1.setUnique(true);
		System.out.println("\tlist1, false -> true: " + list1.toString());
		
		System.out.println("\nadd(duplicate), unique = true: ");
		list1.add(56);
		System.out.println("\tlist1, duplicate = 56: " + list1.toString());
	}
}