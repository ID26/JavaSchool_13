package ru.sberbank.denisov26.lesson_1.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    private int [] array;
    private int arrayLength;
    private int countItrOutLoop = 0;
    private int countItrInLoop = 0;
    private int [] countersItrInLoop;


    public BubbleSort() {
        countersItrInLoop = new int[arrayLength];
    }

    public BubbleSort(int [] array) {
        this.array = array;
        arrayLength = array.length;
        countersItrInLoop = new int[arrayLength];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        arrayLength = array.length;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(new int[]{1, 15, 37, 99, 66, 00, 27, 58, 3, 7, 1, 6, 0, 2, 9});
        bubbleSort.doBubbleSort();

        printSortedArray(bubbleSort);
        printCounters(bubbleSort);

    }

    public static void printCounters(BubbleSort bubbleSort) {
        System.out.println();
        Arrays.stream(bubbleSort.countersItrInLoop)
                .mapToObj(i -> Integer.toString(i))
                .forEach(System.out::println);
    }

    public static void printSortedArray(BubbleSort bubbleSort) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : bubbleSort.getArray()) {
            System.out.print(integer + " ");
        }
    }

    public void doBubbleSort() {
        for (int i = arrayLength - 1; i >= 0; i--) {
            for (int j = 1; j < arrayLength; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j);
                }
                countItrInLoop++; // счетчик внутреннего цикла
            }
            arrayLength--;

//            ниже в этом методе ненужный код с моими проверками
            countersItrInLoop[countItrOutLoop] = countItrInLoop;
            countItrInLoop = 0;
            countItrOutLoop++;
        }
    }

    private void swap(int j) {
        int temp = array[j - 1];
        array [j - 1] = array [j];
        array [j] = temp;
    }

}
