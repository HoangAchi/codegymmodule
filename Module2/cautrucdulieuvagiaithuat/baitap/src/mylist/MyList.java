package mylist;

public interface MyList<E> extends java.lang.Iterable<E> {
    public void add(int index, E element);
    public E remove(int index);
    public int size();
    public boolean contains(E e);
    public int indexof(E e);
    public void add(E e);
    public void ensureCapacity(int minCapacity);
    public E get(int i);
    public void clear();
}
