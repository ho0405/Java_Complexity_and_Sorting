
package utility;

import java.util.Comparator;
import java.lang.reflect.Array;

public class Sorts {

    // Bubble Sort
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static <T> void bubbleSort(T[] arr, Comparator<? super T> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

	// Selection Sort
	public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        int min_idx = i;
	        for (int j = i + 1; j < arr.length; j++) {
	            if (arr[j].compareTo(arr[min_idx]) < 0) {
	                min_idx = j;
	            }
	        }
	        T temp = arr[min_idx];
	        arr[min_idx] = arr[i];
	        arr[i] = temp;
	    }
	}

	public static <T> void selectionSort(T[] arr, Comparator<? super T> c) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        int min_idx = i;
	        for (int j = i + 1; j < arr.length; j++) {
	            if (c.compare(arr[j], arr[min_idx]) < 0) {
	                min_idx = j;
	            }
	        }
	        T temp = arr[min_idx];
	        arr[min_idx] = arr[i];
	        arr[i] = temp;
	    }
	}
	
	// Insertion Sort
	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
	    for (int i = 1; i < arr.length; i++) {
	        T key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && arr[j].compareTo(key) > 0) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}

	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {
	    for (int i = 1; i < arr.length; i++) {
	        T key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && c.compare(arr[j], key) > 0) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}
	
	// Merge Sort
	public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
	    if (arr.length > 1) {
	        int mid = arr.length / 2;

	        // Split array into two halves using reflection to instantiate generic arrays
	        T[] left = (T[]) Array.newInstance(arr.getClass().getComponentType(), mid);
	        T[] right = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length - mid);
	        
	        System.arraycopy(arr, 0, left, 0, mid);
	        System.arraycopy(arr, mid, right, 0, arr.length - mid);

	        // Recursively sort both halves
	        mergeSort(left);
	        mergeSort(right);

	        // Merge the sorted halves
	        int i = 0, j = 0, k = 0;
	        while (i < left.length && j < right.length) {
	            if (left[i].compareTo(right[j]) <= 0) {
	                arr[k++] = left[i++];
	            } else {
	                arr[k++] = right[j++];
	            }
	        }
	        while (i < left.length) arr[k++] = left[i++];
	        while (j < right.length) arr[k++] = right[j++];
	    }
	}

    // Quick Sort
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Comb Sort
    public static <T extends Comparable<? super T>> void combSort(T[] arr) {
        int gap = arr.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;
            for (int i = 0; i < arr.length - gap; i++) {
                if (arr[i].compareTo(arr[i + gap]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
    
 // Merge Sort with Comparator
    public static <T> void mergeSort(T[] arr, Comparator<? super T> c) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            T[] left = (T[]) Array.newInstance(arr.getClass().getComponentType(), mid);
            T[] right = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length - mid);

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            mergeSort(left, c);
            mergeSort(right, c);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (c.compare(left[i], right[j]) <= 0) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) arr[k++] = left[i++];
            while (j < right.length) arr[k++] = right[j++];
        }
    }

    // Quick Sort with Comparator
    public static <T> void quickSort(T[] arr, Comparator<? super T> c) {
        quickSort(arr, 0, arr.length - 1, c);
    }

    private static <T> void quickSort(T[] arr, int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, c);
            quickSort(arr, low, pivotIndex - 1, c);
            quickSort(arr, pivotIndex + 1, high, c);
        }
    }

    private static <T> int partition(T[] arr, int low, int high, Comparator<? super T> c) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Comb Sort with Comparator
    public static <T> void combSort(T[] arr, Comparator<? super T> c) {
        int gap = arr.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;
            for (int i = 0; i < arr.length - gap; i++) {
                if (c.compare(arr[i], arr[i + gap]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    

}


