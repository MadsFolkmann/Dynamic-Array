import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;
    private static final int INITIAL_SIZE = 10;
    private static final int GROW_SIZE = 10;

    public DynamicArray() {
        array = new int[INITIAL_SIZE];
        size = 0;
    }

    public void add(int element) {
        ensureCapacity();
        array[size++] = element;
    }

    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    public void remove() {
        if (size > 0) {
            size--;
            shrinkIfNeeded();
        }
    }

    public void remove(int index) {
        checkIndex(index);
        if (size > 0) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
            shrinkIfNeeded();
        }
    }

    public void set(int index, int element) {
        checkIndex(index);
        array[index] = element;
    }

    public void clear() {
        size = 0;
        shrinkIfNeeded();
    }

    private void ensureCapacity() {
        if (size == array.length) {
            grow();
        }
    }

    private void grow() {
        int newSize = array.length + GROW_SIZE;
        array = Arrays.copyOf(array, newSize);
    }

    private void shrinkIfNeeded() {
        if (canShrink()) {
            shrink();
        }
    }

    private boolean canShrink() {
        return (array.length - size) >= GROW_SIZE && (array.length - GROW_SIZE) >= INITIAL_SIZE;
    }

    private void shrink() {
        int newSize = array.length - GROW_SIZE;
        array = Arrays.copyOf(array, newSize);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        System.out.println("Size: " + dynamicArray.size());
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        dynamicArray.remove(1);

        System.out.println("Size after removal: " + dynamicArray.size());
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        dynamicArray.clear();

        System.out.println("Size after clearing: " + dynamicArray.size());
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }
    }
}
