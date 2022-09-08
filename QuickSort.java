import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10);
        }

        System.out.println("Before: ");
        printArr(numbers);

        quickSort(numbers);
        System.out.println("After: ");
        printArr(numbers);
    }

    private static void quickSort (int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        //choose the pivot randomly
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, highIndex);

        // divide the array into sub arrays
        int leftPointer = partitioning(numbers, lowIndex, highIndex, pivot);

        /* recursively call the same method to the other sub arrays */
        quickSort(numbers, lowIndex, leftPointer - 1);
        quickSort(numbers, leftPointer + 1, highIndex);
    }

    private static void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static int partitioning (int[] numbers, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(numbers, leftPointer, rightPointer);
        }
        swap(numbers, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] numbers, int index1, int index2) {
        int tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    private static void printArr(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
            System.out.println("");
        }
    }
}
