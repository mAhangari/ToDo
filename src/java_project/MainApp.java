package java_project;

public class MainApp {
	public static void main(String[] args) {
		LinkList<Integer> list = new LinkList<>();
		System.out.println("List Size Before add: " + list.size());
		list.add(4);
		list.add(5);
		list.add(9);
		list.add(10);
		System.out.println("List Size After add: " + list.size());
		System.out.print("List Elenet: ");
		for(Integer integer: list)
			System.out.print(integer + "  ");
		
		list.remove(1);
		System.out.println();
		System.out.print("List Elenet After Remove: ");
		for(Integer integer: list)
			System.out.print(integer + "  ");
		System.out.println();
		System.out.println("List Size After remove: " + list.size());
		System.out.println("Element of index 2: " + list.get(2));
		list.set(3, 2);
		System.out.print("List Element After set number: ");
		for(Integer integer: list)
			System.out.print(integer + "  ");
	}
}
