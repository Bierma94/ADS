package de.bierma.algorithmen;

public class Search  {

    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7,8,9,10};
        int key = 5;
        System.out.println(interpolationSearch(array, key));
    }


    /**
     * Searches for a key in a sorted array
     * @param array the array to be searched
     * @param key the value to be searched for
     * @return the index of the key in the array or -1 if the key is not found
     */
   public static int sequentielSearchSort(int array[], int key) {
        int i = 0;
        while (i <= array.length && array[i] < key) {
            i++;
        }
        if (i <= array.length && array[i] == key) {
            return i;
        } else {
            return -1;
        }
    }
    /**
     * Searches for a key in an unsorted array
     * @param array the array to be searched
     * @param key the value to be searched for
     * @return the index of the key in the array or -1 if the key is not found
     */
   public static int sequentielSearchUnsort(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Binary search algorithm
     * @param array
     * @param key key to search
     * @return
     */
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length + 1;
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
    /**
     * Binary search algorithm using recursion
     * @param array
     * @param key
     * @param left
     * @param right
     * @return
     */
   public static int binarySearchRecursive(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == key) {
            return middle;
        } else if (array[middle] < key) {
            return binarySearchRecursive(array, key, middle + 1, right);
        } else {
            return binarySearchRecursive(array, key, left, middle - 1);
        }
    }

    public static int interpolationSearch(int[] data, int key) {

        int right = (data.length - 1); // HIGH
        int left = 0;              // LOW

        while (key >= data[left] && key <= data[right] && left <= right) {

            int middle
                    = left + (right - left) * (key - data[left]) / (data[right] - data[left]);

            if (right == left) {
                if (data[left] == key) {
                    return left;
                } else {
                    return -1;
                }
            }

            if (data[middle] == key) {
                return middle;
            }

            if (data[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

}
