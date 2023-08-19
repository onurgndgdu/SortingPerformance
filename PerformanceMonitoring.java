import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
public class PerformanceMonitoring {
    public static void main(String[] args) {

        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        int[] arraySort = generateRandomArray(10000);

        measureSortingTime(arraySort.clone(), "Bubble Sort", operatingSystemMXBean);
        measureSortingTime(arraySort.clone(), "Selection Sort", operatingSystemMXBean);
        measureSortingTime(arraySort.clone(), "Quick Sort", operatingSystemMXBean);
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }
    public static void measureSortingTime(int[] array, String algorithm, OperatingSystemMXBean osBean) {
        System.out.println("Sorting with " + algorithm + "...");

        long startTime = System.nanoTime();

        switch (algorithm) {
            case "Bubble Sort":
                bubbleSort(array);
                break;
            case "Selection Sort":
                selectionSort(array);
                break;
            case "Quick Sort":
                quickSort(array, 0, array.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println(algorithm + " took " + elapsedTime + " nanoseconds.");
        System.out.println("CPU Usage: " + osBean.getSystemLoadAverage());
    }
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
