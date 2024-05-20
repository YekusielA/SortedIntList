package SortedIntList;

public class SortedIntListClient {
		public static void main(String[] args) {
			SortedIntList list1 = new SortedIntList(false, 0);
			SortedIntList list2 = new SortedIntList(true, 0);
			SortedIntList empty = new SortedIntList();
			// Constructors with negative values entered for capacity properly throw error messaging.
			
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

			System.out.println("Test add():");
			System.out.println("\tList1 (false, 0):\t" + list1.toString());
			System.out.println("\tList2 (true, 10):\t" + list2.toString());
			System.out.println("\tempty ():\t\t" + empty.toString());
			
			System.out.println("\nTest min(), max(): ");
			System.out.println("\tlist1: " + list1.min() + ", " + list1.max() + "\t\t" + list1.toString());
			System.out.println("\tlist2: " + list2.min() + ", " + list2.max() + "\t\t" + list2.toString());
			// empty.min();
			// empty.max();
			// System.out.println("\tEmpty: " + empty.min() + ", " + empty.max() + "\t" + empty.toString());
			// Error is correctly thrown for both min() and max() when SortedIntList is empty.
			
			System.out.println("\nTest count():");
			System.out.println("\tlist2, 2, 5, 7, 56: \t1 = " + list1.count(2) + ", 3 = " + list1.count(5) + ", 1 = " + list1.count(7) + ", 2 = " + list1.count(56));
			System.out.println("\tlist2, 2, 5, 7, 56: \t1 = " + list2.count(2) + ", 1 = " + list2.count(5) + ", 1 = " + list2.count(7) + ", 1 = " + list2.count(56));
			System.out.println("\tlist1, 2, 5, 7, 56: \t0 = " + empty.count(2) + ", 0 = " + empty.count(5) + ", 0 = " + empty.count(7) + ", 0 = " + empty.count(56));
			
			System.out.println("\nTest get(): ");
			System.out.println("\tlist1, get(0), get(3): " + list1.get(0) + ", " + list1.get(3));
			System.out.println("\tlist2, get(0), get(3): " + list2.get(0) + ", " + list2.get(3));
			
			System.out.println("\nTest size():");
			System.out.println("\tlist1: " + list1.size());
			System.out.println("\tlist2: " + list2.size());
			System.out.println("\tempty: " + empty.size());
			
			System.out.println("\nTest isEmpty()");
			System.out.println("\tlist1, false: " + list1.isEmpty());
			System.out.println("\tlist2, false: " + list2.isEmpty());
			System.out.println("\tempty, true: " + empty.isEmpty());
			
			System.out.println("\nTest indexOf(): ");
			System.out.println("\tlist1, indexOf(5), indexOf(56): " + list1.indexOf(5) + ", " + list1.indexOf(56));
			System.out.println("\tlist2, indexOf(5), indexOf(56): " + list2.indexOf(5) + ", " + list2.indexOf(56));
			System.out.println("\tempty, indexOf(5), indexOf(56): " + empty.indexOf(5) + ", " + empty.indexOf(56));
			
			list1.remove(1);
			list1.remove(1);
			list1.remove(1);
			list1.remove(1);
			list2.remove(3);
			
			System.out.println("\nTest remove(): ");
			System.out.println("\t\tlist1 (5's & 7): \t" + list1.toString());
			System.out.println("\t\tlist2 (56): \t\t" + list2.toString());
			
			
			list1.setUnique(true);
			list2.setUnique(false);
			list1.add(2);
			list2.add(7);
			System.out.println("\nTest getUnique & setUnique: ");
			System.out.println("\tlist1, " + list1.getUnique() + " -> true, add(2): \t" + list1.toString());
			System.out.println("\tlist2, " + list1.getUnique() + " -> false, add(7): \t" + list2.toString());
		}
}
