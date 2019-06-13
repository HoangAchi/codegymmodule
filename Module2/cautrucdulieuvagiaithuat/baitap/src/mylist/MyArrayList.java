package mylist;

public class MyArrayList<E> extends MyAbstractList<E> implements Cloneable{
    public static final int INITIAL_CAPACITY = 20;
    private E[]data = (E[]) new Object[INITIAL_CAPACITY];
    MyArrayList(){}
    MyArrayList(E[] objects){
        for (int i =0;i<objects.length;i++){
            add(objects[i]);
        }
    }

    @Override
    public void add(int index,E e){
        for (int i = size-1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    @Override
    public void ensureCapacity(int minCapacity) {
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    @Override
    public E remove(int index){
        checkIndex(index);
        E e = data[index];
        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];
        data[size - 1] = null;
        size--;
        return e;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }
    @Override
    public boolean contains(E e){
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return true;
        return false;
    }
    @Override
    public int indexof(E e){
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return i;
        return -1;
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }
    @Override
    public void clear() {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }
    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator
            implements java.util.Iterator<E> {
        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
