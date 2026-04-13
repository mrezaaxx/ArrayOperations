import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Comparison {
    private static final int REPETITIONS = 1000;

    public static void runPerformanceTest(int size, int target) {
        int[] arrayData = createSequentialArray(size);
        ArrayList<Integer> arrayListData = createSequentialArrayList(size);
        int insertIndex = size / 2;

        double arrayLinearSearchTime = averageTime(() -> ArrayOperations.linearSearch(arrayData, target));
        double arrayBinarySearchTime = averageTime(() -> ArrayOperations.binarySearch(arrayData, target));
        double arrayInsertTime = averageTime(() -> ArrayOperations.insert(arrayData, -1, insertIndex));
        double arrayDeleteTime = averageTime(() -> ArrayOperations.delete(arrayData, insertIndex));

        double arrayListSearchTime = averageTime(() -> ArrayListOperations.searchElement(arrayListData, target));
        double arrayListInsertTime = averageTime(() -> {
            ArrayList<Integer> temp = new ArrayList<>(arrayListData);
            ArrayListOperations.addElement(temp, insertIndex, -1);
        });
        double arrayListDeleteTime = averageTime(() -> {
            ArrayList<Integer> temp = new ArrayList<>(arrayListData);
            ArrayListOperations.removeAt(temp, insertIndex);
        });
        double arrayListSortTime = averageTime(() -> {
            ArrayList<Integer> temp = new ArrayList<>(arrayListData);
            ArrayListOperations.sortElements(temp);
        });

        // Estimasi sederhana untuk membantu analisis laporan.
        double estimatedArrayMemory = arrayData.length * Integer.BYTES;
        double estimatedArrayListMemory = arrayListData.size() * Integer.BYTES * 2.0;

        System.out.println("\nTabel Perbandingan Kinerja");
        System.out.println("+----------------------+----------------+----------------+");
        System.out.println("| Operasi              | Array (ms)     | ArrayList (ms) |");
        System.out.println("+----------------------+----------------+----------------+");
        printRow("Pencarian Linear", arrayLinearSearchTime, arrayListSearchTime);
        printRow("Pencarian Binary", arrayBinarySearchTime, Double.NaN);
        printRow("Penyisipan Tengah", arrayInsertTime, arrayListInsertTime);
        printRow("Penghapusan Tengah", arrayDeleteTime, arrayListDeleteTime);
        printRow("Pengurutan", averageTime(() -> Arrays.sort(Arrays.copyOf(arrayData, arrayData.length))), arrayListSortTime);
        System.out.println("+----------------------+----------------+----------------+");

        System.out.println("\nEstimasi Penggunaan Memori");
        System.out.println("+----------------------+----------------------+");
        System.out.println("| Struktur Data        | Estimasi Memori      |");
        System.out.println("+----------------------+----------------------+");
        System.out.printf(Locale.US, "| %-20s | %18.0f byte |\n", "Array", estimatedArrayMemory);
        System.out.printf(Locale.US, "| %-20s | %18.0f byte |\n", "ArrayList", estimatedArrayListMemory);
        System.out.println("+----------------------+----------------------+");
        System.out.println("\nCatatan: estimasi memori ArrayList dibuat sederhana karena ada overhead objek dan kapasitas internal.");
    }

    private static void printRow(String operation, double arrayTime, double arrayListTime) {
        String arrayText = String.format(Locale.US, "%.6f", arrayTime);
        String arrayListText = Double.isNaN(arrayListTime)
            ? "-"
            : String.format(Locale.US, "%.6f", arrayListTime);
        System.out.printf("| %-20s | %14s | %14s |\n", operation, arrayText, arrayListText);
    }

    private static double averageTime(Runnable operation) {
        long total = 0L;
        for (int i = 0; i < REPETITIONS; i++) {
            long start = System.nanoTime();
            operation.run();
            long end = System.nanoTime();
            total += (end - start);
        }
        return total / (double) REPETITIONS / 1_000_000.0;
    }

    private static int[] createSequentialArray(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }
        return data;
    }

    private static ArrayList<Integer> createSequentialArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i + 1);
        }
        return list;
    }
}
