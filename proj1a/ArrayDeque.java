public class ArrayDeque<T> {
    T[] item = (T[]) new Object[8];
    int tail = 0;
    int head = item.length - 1;
    int sizeHead = 0;
    int sizeTail = 0;
    int size = 0;


    public void addFirst(T x) {
        if (size == item.length) {
            resize();
        }
        item[head] = x;
        head = head - 1;
        sizeHead = sizeHead +1;
        size = sizeHead + sizeTail;
    }

    public void addLast(T x) {
        if(size == item.length) {
            resize();
        }
        item[tail] = x;
        tail = tail + 1;
        sizeTail = sizeTail +1;
        size = sizeHead + sizeTail;
    }

    public T removeLast() {
        int tmp = tail;
        tail = tail - 1;
        sizeTail = sizeTail -1;
        size = sizeHead + sizeTail;
        return item[tmp];
    }

    public T removeFirst() {
        int tmp = head;
        head = head + 1;
        sizeHead = sizeHead -1;
        size = sizeHead + sizeTail;
        return item[tmp];
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(sizeHead > 0) {
            for(int i = head+1; i <= item.length - 1; i++, head++) {
                System.out.print(item[i] + " ");
            }
        }
        if(sizeTail > 0) {
            for(int i = 0; i <= tail -1; i++) {
                System.out.print(item[i] + " ");
            }
        }
    }

    public T get(int index) {
        if(index < 0){
            return null;
        }
        if(index > sizeHead) {
            int remain = index - sizeHead;
            if(remain > sizeTail) {
                return null;
            } else {
                return item[remain -1];
            }
        } else {
            return item[head + index];
        }

    }

    private void resize() {
        T[] item2 = (T[]) new Object[item.length*2];
        System.arraycopy(item,0,item2,0,sizeTail);
        System.arraycopy(item,head+1,item2,item2.length - sizeHead, sizeHead);
        item = item2;
        head = item2.length - sizeHead -1;
    }

}
