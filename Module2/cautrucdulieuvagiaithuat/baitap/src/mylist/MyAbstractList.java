package mylist;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;
    protected MyAbstractList(){}
    protected MyAbstractList(E[] objects){
        for (int i =0; i< objects.length;i++){
            add(objects[i]);
        }
    }
    @Override
    public void add(E e){
        add(size,e);
    }
    @Override
    public int size(){
        return size;
    }
}
