import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    public static void traverse(ArrayList<Integer> list) {
        System.out.println(list);
    }

    public static void addElement(ArrayList<Integer> list, int value) {
        list.add(value);
    }

    public static void addElement(ArrayList<Integer> list, int index, int value) {
        list.add(index, value);
    }

    public static boolean removeElement(ArrayList<Integer> list, Integer value) {
        return list.remove(value);
    }

    public static Integer removeAt(ArrayList<Integer> list, int index) {
        return list.remove(index);
    }

    public static int searchElement(ArrayList<Integer> list, int target) {
        // indexOf melakukan pencarian berurutan seperti linear search.
        return list.indexOf(target);
    }

    public static void sortElements(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}
