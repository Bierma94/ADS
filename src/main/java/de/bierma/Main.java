package de.bierma;

import de.bierma.algorithmen.SearchTester;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int array[] = generator(1000000, 0, 1000000);
        int key = args.length > 0 ? Integer.parseInt(args[0]) : 502;
        int loops = args.length > 1 ? Integer.parseInt(args[1]) : 100;
        SearchTester searchTester = new SearchTester(key, loops, array);

displayStart(loops, key);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                searchTester.testIndexes();
                searchTester.testTime();

            }
        };
        Thread t = new Thread(runnable);
        t.start();
        System.out.print("Testing Searchalgorithmen ....");
        long start = System.nanoTime();
        do {
            System.out.print(".");
            Thread.sleep(1000);
        } while (t.isAlive());
        long end = System.nanoTime();
        System.out.println("\nFinished in: " + (end - start)  + "ns");
        searchTester.display();


    }



    public static int[] generator(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        Arrays.sort(array);
        return array;
    }

    private static void displayStart(int loops, int key) {
        System.out.println("Starting the search algorithms with random generated array");
        System.out.println("Key: " + key);
        System.out.println("Loops: " + loops);

    }
}