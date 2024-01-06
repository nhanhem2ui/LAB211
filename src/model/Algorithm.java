package model;

import java.util.Random;

public class Algorithm {

    //Bubble sort function
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted array: ");
        printArray(arr);
    }
    
    // Quicksort function
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }

        // Print the sorted array after the sorting process is complete
        if (low == 0 && high == arr.length - 1) {
            System.out.println("Sorted array:");
            printArray(arr);
        }
    }

    // Function to partition the array and return the index of the pivot element
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Function to swap two elements in an array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print an array
    public void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //generate random arrays
    public void generateRandomArray(int[] arr) {
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100); // Generates random numbers between 0 and 99
        }
    }

    public int linearSearch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int arr[], int left, int right, int element) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // if the element is present at the middle 
            if (arr[mid] == element) {
                return mid;
            }

            //left subarray
            if (arr[mid] > element) {
                return binarySearch(arr, left, mid - 1, element);
            }

           
            // right subarray 
            return binarySearch(arr, mid + 1, right, element);
        }

        // element is not present in array 
        return -1;
    }
}
