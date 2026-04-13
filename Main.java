import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int target = 30;

        System.out.println("=== Operasi Array ===");
        System.out.print("Array Traversal: ");
        ArrayOperations.traverse(array);

        int linearIndex = ArrayOperations.linearSearch(array, target);
        System.out.println("Pencarian " + target + " dalam Array (Linear Search): " + formatSearchResult(linearIndex));

        int[] sortedArray = ArrayOperations.sortCopy(array);
        int binaryIndex = ArrayOperations.binarySearch(sortedArray, target);
        System.out.println("Pencarian " + target + " dalam Array (Binary Search): " + formatSearchResult(binaryIndex));

        int[] insertedArray = ArrayOperations.insert(array, 25, 2);
        System.out.println("Array setelah penyisipan elemen 25: " + Arrays.toString(insertedArray));

        int[] deletedArray = ArrayOperations.delete(insertedArray, 2);
        System.out.println("Array setelah penghapusan indeks 2: " + Arrays.toString(deletedArray));

        System.out.println("\n=== Operasi ArrayList ===");
        System.out.print("ArrayList Traversal: ");
        ArrayListOperations.traverse(arrayList);

        int arrayListIndex = ArrayListOperations.searchElement(arrayList, target);
        System.out.println("Pencarian " + target + " dalam ArrayList: " + formatSearchResult(arrayListIndex));

        ArrayList<Integer> insertedList = new ArrayList<>(arrayList);
        ArrayListOperations.addElement(insertedList, 2, 25);
        System.out.println("ArrayList setelah penyisipan elemen 25: " + insertedList);

        ArrayList<Integer> deletedList = new ArrayList<>(insertedList);
        ArrayListOperations.removeAt(deletedList, 2);
        System.out.println("ArrayList setelah penghapusan indeks 2: " + deletedList);

        ArrayList<Integer> unsortedList = new ArrayList<>(Arrays.asList(40, 10, 50, 20, 30));
        ArrayListOperations.sortElements(unsortedList);
        System.out.println("ArrayList setelah diurutkan: " + unsortedList);

        System.out.println("\n=== Perbandingan Kinerja ===");
        Comparison.runPerformanceTest(1000, 900);
    }

    private static String formatSearchResult(int index) {
        return index >= 0 ? "Ditemukan di indeks " + index : "Tidak ditemukan";
    }
}
