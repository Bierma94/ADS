package de.bierma.algorithmen;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25,2142, 12, 22, 11, 90};
        int[] sortedArray = bubbleSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }

    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
