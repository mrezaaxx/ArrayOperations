import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    /**
     * Menampilkan semua elemen dalam ArrayList.
     * @param list ArrayList yang akan ditampilkan
     */
    public static void traverse(ArrayList<Integer> list) {
        System.out.println(list);
    }

    /**
     * Menambahkan elemen ke akhir ArrayList.
     * @param list ArrayList tujuan
     * @param value nilai yang akan ditambahkan
     */
    public static void addElement(ArrayList<Integer> list, int value) {
        list.add(value);
    }

    /**
     * Menambahkan elemen pada indeks tertentu dalam ArrayList.
     * @param list ArrayList tujuan
     * @param index posisi yang dituju
     * @param value nilai yang akan ditambahkan
     */
    public static void addElement(ArrayList<Integer> list, int index, int value) {
        list.add(index, value);
    }

    /**
     * Menghapus elemen berdasarkan nilai dari ArrayList.
     * @param list ArrayList sumber
     * @param value nilai yang akan dihapus
     * @return true jika elemen ditemukan dan dihapus, false jika tidak ditemukan
     */
    public static boolean removeElement(ArrayList<Integer> list, Integer value) {
        return list.remove(value);
    }

    /**
     * Menghapus elemen pada indeks tertentu dari ArrayList.
     * @param list ArrayList sumber
     * @param index indeks elemen yang akan dihapus
     * @return nilai elemen yang dihapus
     */
    public static Integer removeAt(ArrayList<Integer> list, int index) {
        return list.remove(index);
    }

    /**
     * Mencari elemen dalam ArrayList menggunakan pencarian linear.
     * @param list ArrayList yang akan dicari
     * @param target nilai yang dicari
     * @return indeks elemen jika ditemukan, -1 jika tidak ditemukan
     */
    public static int searchElement(ArrayList<Integer> list, int target) {
        // indexOf melakukan pencarian berurutan seperti linear search.
        return list.indexOf(target);
    }

    /**
     * Mengurutkan elemen dalam ArrayList secara ascending.
     * @param list ArrayList yang akan diurutkan
     */
    public static void sortElements(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}
