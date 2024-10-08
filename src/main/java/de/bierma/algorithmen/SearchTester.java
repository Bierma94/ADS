package de.bierma.algorithmen;

public class SearchTester {
    final int key;
    final int loops;
    final int[] array;
    private int[] indexes = new int[5];   //Binary search, Binary search recursive, Sequential search sort, Sequential search unsort, Interpolation search
    private double [] times = new double[5]; //Binary search, Binary search recursive, Sequential search sort, Sequential search unsort, Interpolation search


    public SearchTester(int key, int loops, int[] array) {
        this.key = key;
        this.loops = loops;
        this.array = array;
    }

    public void testIndexes() {
        for(int i = 0; i < this.loops; i++) {
            indexes[0] = Search.binarySearch(array, key);
            indexes[1] = Search.binarySearchRecursive(array, key, 0, array.length - 1);
            indexes[2] = Search.sequentielSearchSort(array, key);
            indexes[3] = Search.sequentielSearchUnsort(array, key);
           indexes[4] = Search.interpolationSearch(array, key);
        }

    }

    public void testTime() {
        long avrtime = 0;
        for(int i = 0; i < this.loops; i++) {
            long start = System.nanoTime();
            Search.binarySearch(array, key);
            long end = System.nanoTime();
            avrtime += end - start;
        }
        this.times[0] = (double) avrtime / this.loops;
        avrtime = 0;
        for(int i = 0; i < this.loops; i++) {
            long start = System.nanoTime();
            Search.binarySearchRecursive(array, key, 0, array.length - 1);
            long end = System.nanoTime();
            avrtime += end - start;
        }
        times[1] = (double) avrtime / this.loops;
        avrtime = 0;
        for(int i = 0; i < this.loops; i++) {
            long start = System.nanoTime();
            Search.sequentielSearchSort(array, key);
            long end = System.nanoTime();
            avrtime += end - start;
        }
        times[2] = (double) avrtime / this.loops;
        avrtime = 0;
        for(int i = 0; i < this.loops; i++) {
            long start = System.nanoTime();
            Search.sequentielSearchUnsort(array, key);
            long end = System.nanoTime();
            avrtime += end - start;
        }
        times[3] = (double) avrtime / this.loops;
        avrtime = 0;
        for(int i = 0; i < this.loops; i++) {
            long start = System.nanoTime();
            Search.interpolationSearch(array, key);
            long end = System.nanoTime();
            avrtime += end - start;
        }
        times[4] = (double) avrtime / this.loops;
    }
    public void display() {
        System.out.println("Key: " + key);
        System.out.println("Binary search: Found at: " + indexes[0] + " Time: " + times[0] + "ns");
        System.out.println("Binary search recursive: Found at: " + indexes[1] + " Time: " + times[1]+ "ns");
        System.out.println("Sequential search sort: Found at: " + indexes[2] + " Time: " + times[2]+ "ns");
        System.out.println("Sequential search unsort: Found at: " + indexes[3] + " Time: " + times[3]+ "ns");
        System.out.println("Interpolation search: Found at: " + indexes[4] + " Time: " + times[4]+ "ns");
    }
}
