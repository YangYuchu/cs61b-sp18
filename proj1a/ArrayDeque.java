/**
 * Create Array Deque
 *
 * @author Jason Yang
 */

public class ArrayDeque<T> {
    private T[] items;
    public int size;
    private int nextFirst;
    private int nextLast;
    public int len;

    /* reate empty list. */
    public ArrayDeque(){
        len = 64;
        items = (T[]) new Object[len];
        size = 0;
        nextFirst =31;
        nextLast = 32;
    }

    public ArrayDeque(T x) {
        len = 64;
        items = (T[]) new Object[len];
        nextFirst =30;
        nextLast = 32;
        items [31] = x;
        size = 1;
    }

    public void printDeque() {
        for (int i=0; i<size; i++){
            System.out.print(items[(nextFirst+1+i)] + " ");
        }
    }
    public void addFirst(T item) {
        if (size == (len/2)-1){
            resizeUp(2*len);
        }
        items[nextFirst] = item;
        size ++;
        nextFirst = (nextFirst-1)%len;
    }

    public void addLast(T item) {
        if (size == (len/2)-1){
            resizeUp(2*len);
        }
        items[nextLast] = item;
        size ++;
        nextLast = (nextLast+1)%len;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeFirst() {
        if ((len>64) && (size==len/4)){
            resizeDown(len/2);
        }
        items[nextFirst] = null;
        size --;
        nextFirst = (nextFirst + 1);
    }

    public void removeLast() {
        if ((len>64) && (size==len/4)){
            resizeDown(len/2);
        }
        items[nextLast] = null;
        size --;
        nextLast = (nextLast - 1);
    }

    public T get(int index){
        return items[(nextFirst+1+index)%len];
    }

    public int size() {
        return size;
    }
    private void resizeUp(int capacity){
        T[] a = (T[]) new Object[capacity];
        int init = len*3/4;
        System.arraycopy(items, nextFirst+1, a, init+1, size );
        items = a;
        nextFirst = init;
        nextLast = nextFirst +size+1;
        len = capacity;
    }
    private void resizeDown(int capacity){
        T[] a = (T[]) new Object[capacity];
        int init = len/8;
        System.arraycopy(items, nextFirst+1, a, init+1, size );
        items = a;
        nextFirst = init;
        nextLast = nextFirst +size+1;
        len = capacity;
    }
}
