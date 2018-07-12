import java.util.ArrayList;
public class CompareArrayList {

	public static boolean hasDuplicatesInArrayList(ArrayList<?> list) {
	    for (int i = 0; i < list.size(); i++) {
	        for (int j = i + 1; j < list.size(); j++) {
	        if (list.get(i) == list.get(j)) {
	            return true;
	        }
	        }
	    }
	    return false;
	    }
	
	static Set<Object> removeDuplicatesInArrayList(ArrayList<?> list) {
		Set<Object> set = new LinkedHashSet<Object>(list);
		// return type is object elements
		return set;
	}

	static List<String> convertObjectArrayTOString(Set<Object> set) {
		List<String> strArrayList = new ArrayList<String>();
		for (Object object : set) {
			strArrayList.add(object != null ? object.toString() : null);
		}

		// To print Data type of array List
		if (strArrayList instanceof List && strArrayList.size() > 0) {
			System.out.println(strArrayList.get(0).getClass().getCanonicalName()); //java.lang.String
		}
		return strArrayList;
	}

	static List<Integer> convertObjectArrayToInt(Set<Object> set) {
		List<Integer> integerarray = new ArrayList<Integer>();

		for (Object object : set) {
			integerarray.add(object != null ? Integer.parseInt(object.toString()) : null);
		}
		if (integerarray instanceof List && integerarray.size() > 0) {
			System.out.println(integerarray.get(0).getClass().getCanonicalName());  // java.lang.Integer
		}
		return integerarray;
	}
	
	static boolean comparewithorder(ArrayList<?> a, ArrayList<?> b) {
		  if (a == null && b == null) return true;


		    if ((a == null && b!= null) || (a != null && b== null) || (a.size() != b.size()))
		    {
		        return false;
		    }
		return a.equals(b);
	}

	static boolean comparewithoutorder(ArrayList<?> a, ArrayList<?> b) {
		  if (a == null && b == null) return true;


		    if ((a == null && b!= null) || (a != null && b== null) || (a.size() != b.size()))
		    {
		        return false;
		    }
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
		
		ArrayList<Integer> arl = new ArrayList<Integer>();
		arl.add(1);
		arl.add(22);
		arl.add(-2);

		// compare with order of each element

		System.out.println("compare with order of each element -> " + comparewithorder(list1, list2));

		// compare without order of each element

		System.out.println("compare without order of each element -> " + comparewithoutorder(list1, list2));

		// compare with size

		System.out.println("compare with size -> " + compareWithSize(list1, list2));
		
		System.out.println("set -> " + removeDuplicatesInArrayList(list));

		System.out.println(convertObjectArrayTOString(removeDuplicatesInArrayList(list)));

		System.out.println(convertObjectArrayToInt(removeDuplicatesInArrayList(arl)));

	}

}
