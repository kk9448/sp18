public class ArrayDeque<T> {
    private T[] item = (T[]) new Object[8];
    private int tail = 0;
    private int head = item.length - 1;
    private int sizeHead = 0;
    private int sizeTail = 0;
    private int size = 0;
    private int FirstEnd = item.length-1;
    private int tailFirst = 0;


    public void addFirst(T x) {
        if (size == item.length || head == tail - 1 || tail == head - 1) {
            resize();
        }
        item[head] = x;
        if (head != 0) {
            head = head - 1;
            sizeHead = sizeHead +1;
            size = sizeHead + sizeTail;
        } else {
            resize();
        }

    }

    public void addLast(T x) {
        if(size == item.length || head == tail - 1 || tail == head - 1) {
            resize();
        }
        item[tail] = x;
        if (tail != item.length -1) {
            tail = tail + 1;
            sizeTail = sizeTail +1;
            size = sizeHead + sizeTail;
        } else {
            resize();
        }

    }

    public T removeLast() {
        if (sizeTail == 0) {
            if (sizeHead ==0) {
                return null;
            }
            sizeHead = sizeHead - 1;
            size = sizeHead + sizeTail;
            T a = removeFirstEnd();
            return a;
        }
        int tmp = tail - 1;
//        if (tail == 1) {
//            tail = 0;
//        } else {
//            tail = tail - 2;
//        }
        tail = tail - 1;
        sizeTail = sizeTail -1;
        size = sizeHead + sizeTail;
        return item[tmp];
    }

    private T removeFirstEnd() {
        int tmp = FirstEnd;
        FirstEnd = FirstEnd - 1;
        return item[tmp];

    }

    public T removeFirst() {
        if (sizeHead == 0) {
            if (sizeTail ==0) {
                return null;
            }
            sizeTail = sizeTail - 1;
            size = sizeHead + sizeTail;
            T a = removeTailFirst();
            return a;
        }
        int tmp = head + 1;
        head = head + 1;
        sizeHead = sizeHead -1;
        size = sizeHead + sizeTail;
        return item[tmp];
    }

    private T removeTailFirst() {
        int tmp = tailFirst;
        tailFirst = tailFirst + 1;
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
        if(index >= sizeHead) {
            int remain = index - sizeHead;
            if(remain > sizeTail) {
                return null;
            } else {
                return item[remain + tailFirst];
            }
        } else {
            return item[head + 1 + index];
        }

    }

    private void resize() {
        T[] item2 = (T[]) new Object[item.length*2];
        System.arraycopy(item,0,item2,0,sizeTail);
        System.arraycopy(item, head , item2,item2.length - sizeHead - 1, sizeHead + 1 );
        item = item2;
        head = item2.length - sizeHead - 2 ;
        FirstEnd = item.length-1;
    }

}
