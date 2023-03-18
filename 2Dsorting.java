import java.util.Scanner;

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n = input.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }
    System.out.println("Select the sorting algorithm:");
    System.out.println("1. Bubble Sort");
    System.out.println("2. Selection Sort");
    System.out.println("3. Insertion Sort");
    System.out.println("4. Merge Sort");
    System.out.println("5. Quick Sort");
    int choice = input.nextInt();
    switch(choice) {
      case 1:
        bubbleSort(arr);
        break;
      case 2:
        selectionSort(arr);
        break;
      case 3:
        insertionSort(arr);
        break;
      case 4:
        mergeSort(arr, 0, n - 1);
        break;
      case 5:
        quickSort(arr, 0, n - 1);
        break;
      default:
        System.out.println("Invalid choice!");
    }
    printArray(arr, n);
    input.close();
}
  
public static void bubbleSort(int[] arr) 
{
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) 
    {
       for (int j = 0; j < n - i - 1; j++) 
       {
            if (arr[j] > arr[j + 1]) 
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
      
    }
}
  
  public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) 
      {
        if (arr[j] < arr[minIndex]) 
        {
            minIndex = j;
        }
      }
      if (minIndex != i) 
      {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }
}
  
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) 
    {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) 
      {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
}
  
public static void mergeSort(int[] arr, int left, int right) 
{
    if (left < right) 
    {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
}
  
public static void merge(int[] arr, int left, int mid, int right) 
{
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; i++) {
      L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[mid + j + 1];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            } else {
                 arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

        
    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) 
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
        
public static int partition(int[] arr, int low, int high) 
{
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) 
    {
        if (arr[j] < pivot) 
        {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
        
public static void printArray(int[] arr, int n) 
{
    System.out.println("Sorted array:");
    for (int i = 0; i < n; i++) 
    {
        System.out.print(arr[i] + " ");
    }
}
