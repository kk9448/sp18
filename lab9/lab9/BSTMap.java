package lab9;

import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size = 0; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        //        throw new UnsupportedOperationException();
        V value;
        if (p == null) {
            return null;
        }
        int bigOrSmall = key.compareTo(p.key);
        if (bigOrSmall > 0) {
            p = p.right;
            value = getHelper(key, p);
        } else if (bigOrSmall == 0) {
            return p.value;
        } else {
            p = p.left;
            value = getHelper(key, p);
        }
        return value;
    }


    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
//        throw new UnsupportedOperationException();
        V value = getHelper(key, root);
        return value;

    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
//        throw new UnsupportedOperationException();
        if (p == null) {
            size += 1;
            p = new Node(key, value);
            return p;
        } else {
            int bigOrSmall = key.compareTo(p.key);
            if (bigOrSmall > 0) {
//                p = p.right;
                p.right = putHelper(key, value, p.right);
            } else if (bigOrSmall == 0) {
                p.value = value;
            } else {
//                p = p.left;
                p.left = putHelper(key, value, p.left);
            }
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
//        throw new UnsupportedOperationException();
        if (root == null) {
            root = new Node(key, value);
            size = 1;
            return;
        }
        putHelper(key, value, root);

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
//        throw new UnsupportedOperationException();
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    private class MapIterator implements Iterator {

        @Override
        public boolean hasNext() {
            if (root == null) {
                return false;
            }
            return hasNextHelper(root);
        }

        public boolean hasNextHelper (Node x) {
            if (x == null) {
                return true;
            } else {
                hasNextHelper(x.left);
                hasNextHelper(x.right);
            }
            if (x == root) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public Object next() {
            return null;
        }
    }

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {

        throw new UnsupportedOperationException();
    }
}
