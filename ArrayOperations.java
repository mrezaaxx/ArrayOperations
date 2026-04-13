import java.util.Arrays;

public class ArrayOperations {
    public static void traverse(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int linearSearch(int[] array, int target) {
        // Linear search memeriksa elemen satu per satu dari awal hingga akhir.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        // Binary search hanya benar jika array sudah terurut.
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (sortedArray[middle] == target) {
                return middle;
            }

            if (sortedArray[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static int[] insert(int[] array, int value, int index) {
        if (index < 0 || index > array.length) {
            throw new IllegalArgumentException("Index di luar batas array.");
        }

        // Array baru dibuat karena ukuran array Java bersifat tetap.
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, index);
        result[index] = value;
        System.arraycopy(array, index, result, index + 1, array.length - index);
        return result;
    }

    public static int[] delete(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Index di luar batas array.");
        }

        // Elemen setelah indeks yang dihapus digeser satu posisi ke kiri.
        int[] result = new int[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);
        return result;
    }

    public static int[] sortCopy(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }
}
