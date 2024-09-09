package Heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i){
        return (i - 1) / 2;
    }

    private int leftChild(int i){
        return i * 2 + 1;
    }

    private int rightChild(int i){
        return i * 2 + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
