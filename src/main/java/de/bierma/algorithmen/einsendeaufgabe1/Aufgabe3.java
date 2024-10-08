package de.bierma.algorithmen.einsendeaufgabe1;

public class Aufgabe3 {
    public static void main(String[] args) {
        int[] array = generator(1000);
        int left =0;
        int right = 10;
        System.out.println((left + (right - left)) / 2 );
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length + 1;
        System.out.println(right);
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
    private static int[] generator(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }
}
