/*************************************************
 * ALGORITHM 3.3 Binary search tree symbol table
 *************************************************/
package bst;

public class Bst<Key extends Comparable<Key>,Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    private void put(Key key, Value val){
        root = put(root,key,val);
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            put(x.left, key, val);
        else if (cmp > 0)
            put(x.right, key, val);
        else
            x.val = val;

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }




}
