
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public Object[] clone(){
        Object eleClone[] = new Object[size];
        for (int i =0; i < size;i++){
            eleClone[i] = this.elements[i];
        }
        return eleClone;
    }
    public boolean contain(E o){
        for (int i =0; i < size;i++){
           if( o == this.elements[i]) return true;
        }
        return false;
    }
    public void clear(){
        this.size = 0;
        this.elements = new Object[size];
    }
    public void remove(int index){
        Object newEle[] = new Object[size-1];
        for (int i =0; i < index;i++){
            newEle[i] = elements[i];
        }
        for (int i =index+1; i <= newEle.length;i++){
            newEle[i-1] = elements[i];
        }
        this.size--;
        for (int i =0; i < size;i++){
            this.elements[i] = newEle[i];
        }
    }
    public int getSize(){
        return this.size;
    }
    public int indexOf(E o){
        for (int i =0; i < size;i++){
            if (this.elements[i]== o){
                return i;
            }
        }
        return -1;
    }
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
}
