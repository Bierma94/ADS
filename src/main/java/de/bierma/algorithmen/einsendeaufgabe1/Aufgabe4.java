package de.bierma.algorithmen.einsendeaufgabe1;

public class Aufgabe4 {

    public static void main(String[] args) {
        int[] data = {0,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,63,66,69,72,75,78,81,84,87,90,93,96,99};
        int key = 33; // Testwert für die Suche

        // Test Binäre Suche
        int resultBinary = BinarySearch(data, key);
        System.out.println("Binäre Suche: " + (resultBinary != -1
                ? "Gefunden bei Index " + resultBinary
                : "Nicht gefunden"));

        // Test Interpolationssuche
        int resultInterpolation = InterpolationSearch(data, key);
        System.out.println("Interpolationssuche : " + (resultInterpolation != -1
                ? "Gefunden bei Index " + resultInterpolation
                : "Nicht gefunden"));


    }

    public static int BinarySearch(int[] data, int key) {
        int pos = -1;
        int left = 0;
        int right = data.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (data[middle] < key) {
                left = middle + 1;
            } else if (data[middle] > key) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return pos;
    }

    public static int InterpolationSearch(int[] data, int key) {
        int pos = -1;
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int middle = left + ((key - data[left]) * (right - left)) / (data[right] - data[left]); // Geänderte Formel
            if (data[middle] < key) {
                left = middle + 1;
            } else if (data[middle] > key) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return pos;
    }


}
