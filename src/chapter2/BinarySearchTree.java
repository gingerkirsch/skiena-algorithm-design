package chapter2;

class BinarySearchTree {
    Node root;

    BinarySearchTree(){ root = null; }

    static class Node{
        int key;
        Node parent, left, right;

        Node(int k){
            key = k;
            parent = left = right = null;
        }
    }

    void insert(int key){
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.key){
            root.left = insertNode(root.left, key);
        } else if (key > root.key){
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    /*void insertNode(Node subtree, int key, Node parent){
        if (subtree == null){
            Node node = new Node(key);
            node.parent = parent;
            // the link from root is missing
            return;
        }
        if (key < subtree.key) insertNode(subtree.left, key, subtree);
        else insertNode(subtree.right, key, subtree);
    }*/

    void printTree(){
        inOrder(this.root);
    }

    void inOrder(Node node){
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    void preOrder(Node node){
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    Node search(Node node, int key){
        if (node == null) return null;
        if (node.key == key) return node;
        if (key < node.key) return search(node.left, key);
        else return search(node.right, key);
    }

    Node findMinimum(){
        if (root == null) return null;
        Node min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    Node findMaximum(){
        if (root == null) return null;
        Node max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }
}
