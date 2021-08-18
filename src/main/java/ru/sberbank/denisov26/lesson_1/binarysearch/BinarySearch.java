package ru.sberbank.denisov26.lesson_1.binarysearch;

import java.util.Arrays;


public class BinarySearch {
    private int [] sortedArray;
    private int min;
    private int max;

    public BinarySearch(int [] sortedArray) {
        this.sortedArray = sortedArray;
        min = 0;
        max = sortedArray.length - 1;
    }

    public static void main(String[] args) {
        int[] notSortedArray = {2, 6, 99, 56, 78, 36, 26, 78, 11, 97, 45, 15, 3};
        Arrays.sort(notSortedArray);

        Arrays.stream(notSortedArray)
                .mapToObj(i -> Integer.toString(i))
                .forEach(System.out::println);

        System.out.printf("Искомый элемент находится в массиве под индексом = %d",
                new BinarySearch(notSortedArray).toSearch(36));

    }


    public int toSearch(int num) {
            int value = Integer.MAX_VALUE;

            while (min <= max) {
                int mid = min  + ((max - min) / 2);
                if (sortedArray[mid] < num) {
                    min = mid + 1;
                } else if (sortedArray[mid] > num) {
                    max = mid - 1;
                } else if (sortedArray[mid] == num) {
                    value = mid;
                    break;
                }
            }
            return value;
    }
}
