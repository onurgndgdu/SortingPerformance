## Performance Monitoring Java Application
This project is a simple Java application that demonstrates performance monitoring while executing different sorting algorithms (Bubble Sort, Selection Sort, and Quick Sort). It leverages Java's ManagementFactory to access system-level performance data such as CPU usage.

Features:

Sorting Algorithms: Implements Bubble Sort, Selection Sort, and Quick Sort.
Performance Measurement: Measures the time taken by each sorting algorithm to sort an array.
System Load Monitoring: Uses OperatingSystemMXBean to monitor the system's CPU load during execution.
Prerequisites:

Java: Ensure that you have JDK 8 or later installed.
How It Works:

Random Array Generation: The program generates an array of 10,000 random integers.
Sorting Algorithms: It sorts this array using three different algorithms:
Bubble Sort
Selection Sort
Quick Sort
Performance Measurement: For each algorithm:
Measures the time (in nanoseconds) taken to sort the array.
Prints the system CPU load average after the sorting operation.
Code Structure:

Main Class (PerformanceMonitoring):
Initializes the OperatingSystemMXBean to track CPU load.
Generates a random array.
Calls the measureSortingTime method for each sorting algorithm.
Sorting Methods:
bubbleSort(int[] array): Implements the Bubble Sort algorithm.
selectionSort(int[] array): Implements the Selection Sort algorithm.
quickSort(int[] array, int low, int high): Implements the Quick Sort algorithm.
Utility Method:
generateRandomArray(int size): Generates an array of random integers within a specified size.
Performance Monitoring:
measureSortingTime(int[] array, String algorithm, OperatingSystemMXBean osBean): Measures sorting time and logs system CPU usage after the sorting process.

Sorting with Bubble Sort...
Bubble Sort took 123456789 nanoseconds.
CPU Usage: 1.5

Sorting with Selection Sort...
Selection Sort took 987654321 nanoseconds.
CPU Usage: 1.6

Sorting with Quick Sort...
Quick Sort took 543216789 nanoseconds.
CPU Usage: 1.4
