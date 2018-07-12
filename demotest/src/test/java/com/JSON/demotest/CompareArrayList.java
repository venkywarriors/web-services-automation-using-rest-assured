import java.util.ArrayList;
public class CompareArrayList {

	static boolean comparewithorder(ArrayList<?> a, ArrayList<?> b) {
		return a.equals(b);
	}

	static boolean comparewithoutorder(ArrayList<?> a, ArrayList<?> b) {
		return a.containsAll(b);
	}

	public static boolean compareWithSize(ArrayList<?> a, ArrayList<?> b) {
		return (b.size() == a.size()) ? true : false;
	}

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		list1.add("JavaFx");
		list1.add("Java");
		list1.add("WebGL");
		list1.add("OpenCV");
		
		list2.add("JavaFx");
		list2.add("OpenCV");
		list2.add("Java");
		list2.add("WebGL");
		list2.add("python");

		System.out.println(list1);
		System.out.println(list2);

		// compare with order of each element

		System.out.println("compare with order of each element -> " + comparewithorder(list1, list2));

		// compare without order of each element

		System.out.println("compare without order of each element -> " + comparewithoutorder(list1, list2));

		// compare with size

		System.out.println("compare with size -> " + compareWithSize(list1, list2));

	}

}
