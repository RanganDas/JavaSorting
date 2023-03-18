import java.util.*;

public class SortingProgram {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int choice, size;
    int[] arr;
    
    System.out.print("Enter the size of the array: ");
    size = input.nextInt();
    arr = new int[size];
    
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < size; i++) {
      arr[i] = input.nextInt();
    }
    
    do {
      System.out.println("\nMENU:");
      System.out.println("1. Bubble Sort");
      System.out.println("2. Selection Sort");
      System.out.println("3. Insertion Sort");
      System.out.println("4. Merge Sort");
      System.out.println("5. Quick Sort");
      System.out.println("6. Exit");
      
      System.out.print("\nEnter your choice: ");
      choice = input.nextInt();
      
      switch (choice) {
        case 1:
          bubbleSort(arr);
          printArray(arr);
          break;
        case 2:
          selectionSort(arr);
          printArray(arr);
          break;
        case 3:
          insertionSort(arr);
          printArray(arr);
          break;
        case 4:
          mergeSort(arr, 0, size - 1);
          printArray(arr);
          break;
        case 5:
          quickSort(arr, 0, size - 1);
          printArray(arr);
          break;
        case 6:
          System.out.println("Exiting program...");
          break;
        default:
          System.out.println("Invalid choice!");
          break;
      }
      
    } while (choice != 6);
    
  }
  
  public static void bubbleSort(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
  
  public static void selectionSort(int[] arr) {
    int minIndex, temp;
    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
  
  public static void insertionSort(int[] arr) {
    int key, j;
    for (int i = 1; i < arr.length; i++) {
      key = arr[i];
      j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
  
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }
  
  public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    
    while (i <= mid && j <= right) {
      if (arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }
    
    while (i <= mid) {
      temp[k] = arr[i];
      i++;
      k++;
    }
    
    while (j <= right) {
      temp[k] = arr[j];
      j++;
      k++;
    }
    
    for (i = left; i <= right; i++) {
      arr[i] = temp[i - left];
    }
  }
  
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }
  
  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    int temp;
    for (int j = low; j <= high - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
  
  public static void printArray(int[] arr) {
    System.out.println("Sorted array:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

