package de.bierma.algorithmen.einsendeaufgabe1;

    public class Suche {

        public static void main(String[] args) {
            int key = 3;
            int[] data = { 1, 2, 3, 3, 4, 5 };
            int position = sequentialSearch(key, data);
            if (position < 0) {
                System.out.println("Eingabe nicht gefunden");
            } else {
                System.out.println("Eingabe gefunden an Stelle " + position);
            }
            //Schleife durchlaufen, bis keine weiteren Eingaben gefunden werden
            //Wenn die Position -1 ist, wird die Schleife nicht betreten
            while(position >= 0) {
                position = sequentialSearchNext(key, data, position);
                if (position >= 0) {
                    System.out.println("Weitere Eingaben gefunden an Stelle:  " + position);
                }
            }
        }
        /**
         * Gibt die erste gefundene Position des angegebenen Suchschlüssels in einem
         * Datenbestand zurück. Dafür wird das sequentielle Suchverfahren verwendet
         *
         * @param key
         * Schlüssel, der gesucht werden soll
         * @param data
         * Datenbestand, in dem gesucht werden soll
         * @return Position des Schlüssels im Datenbestand oder -1, wenn der
         * Schlüssel nicht gefunden werden kann
         */
        public static int sequentialSearch(int key, int[] data) {
        // Nachteil dieser Implementierung:
        // Es wird nur das erste Vorkommen des Suchschlüssels gefunden.
        // Falls der Suchschlüssel mehrfach im Datenbestand vorkommt, so bleiben
        // die weiteren Vorkommen unberücksichtigt.
            for (int i = 0; i < data.length; i++) {
                if (data[i] == key) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * Gibt den nächsten gefundenen Index des angegebenen Suchschlüssels zurück.
         * @param key
         * Schlüssel, der gesucht werden soll
         * @param data
         * Datenbestand, in dem gesucht werden soll
         * @param position
         * Position, wo der letzte gesuchte Schlüssel gefunden wurde
         * @return Position des Schlüssels im Datenbestand oder -1, wenn der
         * Schlüssel nicht gefunden werden kann
         */
        public static int sequentialSearchNext(int key, int[] data, int position) {
            for (int i = position + 1; i < data.length; i++) {
                if (data[i] == key) {
                    return i;
                }
            }
            return -1;
        }
    }

