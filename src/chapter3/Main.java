package chapter3;

public class Main {
    public static void main(String args[]){
        /** Testing Linked list */
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            LinkedList.insert(list, i);
        }
        LinkedList.printList(list);
        LinkedList.printNode((LinkedList.search(list.head, 3)));
        LinkedList.printNode((LinkedList.search(list.head, 10)));

        LinkedList.printList(LinkedList.insertInTheBeginning(list, -1));

        LinkedList.printNode(LinkedList.predecessor(list.head, 6));

        LinkedList.deleteNode(list, 6);
        LinkedList.printList(list);

        /** Testing Binary Search Tree */
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        tree.printTree();

        System.out.println("Searching for the node: ");
        BinarySearchTree.Node node7 = tree.search(tree.root, 7);
        tree.inOrder(node7);
        tree.inOrder(tree.search(tree.root, 10));


        BinarySearchTree.Node min = tree.findMinimum();
        BinarySearchTree.Node max = tree.findMaximum();
        System.out.println("Minimum:");
        tree.inOrder(min);
        System.out.println("Maximum");
        tree.inOrder(max);

        System.out.println("Node 7 - in order ");
        tree.inOrder(node7);
        System.out.println("Node 7 - pre order ");
        tree.preOrder(node7);
        System.out.println("Node 7 - post order ");
        tree.postOrder(node7);

    }
}
