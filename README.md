# Array vs ArrayList Operations - Program Documentation

## 📋 Deskripsi Program

Program ini adalah aplikasi demonstrasi struktur data Java yang membandingkan operasi dan kinerja antara **Array** (struktur data primitif) dan **ArrayList** (struktur data dinamis). Program ini dirancang untuk tujuan pembelajaran dalam mata kuliah Data Structures and Algorithm Analysis.

## 🎯 Tujuan Program

1. Memahami perbedaan fundamental antara Array dan ArrayList
2. Membandingkan kompleksitas waktu operasi dasar
3. Menganalisis penggunaan memori relatif
4. Mengukur performa eksekusi dengan data ukuran besar

## 📁 Struktur File

```
src/
├── ArrayOperations.java          # Operasi pada Array statis
├── ArrayListOperations.java      # Operasi pada ArrayList dinamis
├── Comparison.java               # Perbandingan kinerja
├── Main.java                     # Program utama
└── README.md                     # Dokumentasi ini
```

## 📘 Penjelasan Kelas

### 1. **ArrayOperations.java**
Kelas ini menyediakan operasi fundamental pada array statis (fixed-size).

#### Method-method:
- **`traverse(int[] array)`**
  - Menampilkan semua elemen array
  - Kegunaan: Visualisasi data

- **`linearSearch(int[] array, int target)`**
  - Mencari elemen dengan memeriksa satu per satu dari awal hingga akhir
  - Kompleksitas: O(n)
  - Keuntungan: Tidak perlu array terurut
  - Kerugian: Lambat untuk data besar

- **`binarySearch(int[] sortedArray, int target)`**
  - Mencari elemen dengan membagi array menjadi dua bagian
  - Kompleksitas: O(log n)
  - Prasyarat: Array harus terurut (ascending)
  - Keuntungan: Jauh lebih cepat untuk data besar

- **`insert(int[] array, int value, int index)`**
  - Menyisipkan elemen pada indeks tertentu
  - Kompleksitas: O(n) - harus membuat array baru dan menyalin elemen
  - Return: Array baru dengan elemen tambahan

- **`delete(int[] array, int index)`**
  - Menghapus elemen pada indeks tertentu
  - Kompleksitas: O(n) - harus membuat array baru dan menyalin elemen
  - Return: Array baru dengan elemen berkurang

- **`sortCopy(int[] array)`**
  - Mengurutkan salinan array tanpa mengubah asli
  - Kompleksitas: O(n log n)
  - Keuntungan: Non-destructive (array asli tetap aman)

### 2. **ArrayListOperations.java**
Kelas ini menyediakan operasi pada ArrayList (struktur data dinamis).

#### Method-method:
- **`traverse(ArrayList<Integer> list)`**
  - Menampilkan semua elemen ArrayList

- **`addElement(ArrayList<Integer> list, int value)`**
  - Menambahkan elemen ke akhir ArrayList
  - Kompleksitas: O(1) amortized
  - Keuntungan: Otomatis mengalokasikan ruang

- **`addElement(ArrayList<Integer> list, int index, int value)`**
  - Menambahkan elemen pada indeks tertentu
  - Kompleksitas: O(n)
  - Kerugian: Perlu menggeser elemen setelah indeks

- **`removeElement(ArrayList<Integer> list, Integer value)`**
  - Menghapus elemen berdasarkan nilai
  - Kompleksitas: O(n)
  - Return: true jika berhasil, false jika tidak ditemukan

- **`removeAt(ArrayList<Integer> list, int index)`**
  - Menghapus elemen pada indeks tertentu
  - Kompleksitas: O(n)
  - Return: Nilai elemen yang dihapus

- **`searchElement(ArrayList<Integer> list, int target)`**
  - Mencari elemen menggunakan linear search
  - Kompleksitas: O(n)
  - Return: Indeks jika ditemukan, -1 jika tidak

- **`sortElements(ArrayList<Integer> list)`**
  - Mengurutkan ArrayList secara ascending
  - Kompleksitas: O(n log n)
  - Catatan: Mengubah ArrayList asli

### 3. **Comparison.java**
Kelas ini melakukan perbandingan kinerja antara Array dan ArrayList.

#### Method-method:
- **`runPerformanceTest(int size, int target)`**
  - Menjalankan tes perbandingan kinerja komprehensif
  - Mengukur waktu eksekusi (dalam milidetik) untuk:
    - Pencarian Linear
    - Pencarian Binary (hanya Array)
    - Penyisipan Tengah
    - Penghapusan Tengah
    - Pengurutan
  - Menampilkan estimasi penggunaan memori
  - Output: Tabel terformat untuk analisis

- **`averageTime(Runnable operation)`** (private)
  - Menghitung waktu rata-rata eksekusi operasi
  - Menjalankan operasi 1000 kali untuk akurasi
  - Unit: Milidetik (ms)

- **`createSequentialArray(int size)`** (private)
  - Membuat array berisi elemen 1, 2, 3, ..., size

- **`createSequentialArrayList(int size)`** (private)
  - Membuat ArrayList berisi elemen 1, 2, 3, ..., size

### 4. **Main.java**
Program utama yang mendemonstrasikan semua operasi.

#### Alur Program:
1. **Operasi Array**
   - Traversal
   - Linear Search
   - Binary Search
   - Insert
   - Delete

2. **Operasi ArrayList**
   - Traversal
   - Search
   - Insert
   - Delete
   - Sort

3. **Perbandingan Kinerja**
   - Menjalankan tes dengan 1000 elemen
   - Mencari elemen dengan nilai 900

## 🔍 Analisis Hasil

### Array (Struktur Data Statis)
**Kelebihan:**
- Akses elemen sangat cepat O(1)
- Penggunaan memori lebih efisien
- Binary search lebih efisien pada array terurut

**Kekurangan:**
- Ukuran fixed (diketahui saat deklarasi)
- Insert dan delete lambat O(n)
- Perlu alokasi array baru untuk mengubah ukuran

### ArrayList (Struktur Data Dinamis)
**Kelebihan:**
- Ukuran dinamis (dapat berubah)
- Insert di akhir cepat O(1) amortized
- Lebih fleksibel untuk operasi yang tidak diketahui sebelumnya

**Kekurangan:**
- Memori overhead karena kapasitas internal
- Insert di tengah lambat O(n)
- Sedikit lebih lambat untuk akses dibanding array

## 📈 Kapan Menggunakan Array vs ArrayList

### Gunakan Array jika:
- ✓ Ukuran data diketahui dan tetap
- ✓ Performa dan memori sangat kritis
- ✓ Banyak operasi akses random
- ✓ Bekerja dengan tipe primitif

### Gunakan ArrayList jika:
- ✓ Ukuran data tidak diketahui atau berubah-ubah
- ✓ Banyak operasi insert/delete di akhir
- ✓ Memerlukan fleksibilitas
- ✓ Bekerja dengan objek