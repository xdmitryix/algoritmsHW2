package ru.geekbrains.lesson2;

/**
 * Утилиты для сортировки массива
 */
public class SortUtils {


    /**
     * Сортировка выбором
     *
     *  0 1 2 3 4
     *  =========
     *  5 4 1 0 1
     *
     *
     *
     * @param array массив
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int saveIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[saveIndex]){
                    saveIndex = j;
                }
            }
            if (i != saveIndex){
                int buf = array[i];
                array[i] = array[saveIndex];
                array[saveIndex] = buf;
            }
        }
    }


    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;
        int middle = array[(start + end) / 2];

        do{
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }

        if (start < right){
            quickSort(array, start, right);
        }
    }

    // Сортировка кучей

    public static void Heapsort(int arr[])
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2; 
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

}
