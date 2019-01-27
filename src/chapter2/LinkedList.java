package chapter2;

class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data){
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null){
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }

            last.next = newNode;
        }
        return list;
    }

    public static Node search(Node node, int data){
        if (node == null) return null;
        if (node.data == data) return node;
        else return search(node.next, data);
    }

    public static void printList(LinkedList list){
        Node currentNode = list.head;
        System.out.println("LinkedList: ");
        while (currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public static void printNode(Node node){
        if (node == null) System.out.println("Null");
        else System.out.println("Node :" + node.data);
    }

    public static LinkedList insertInTheBeginning(LinkedList list, int data){
        Node newHead = new Node(data);
        newHead.next = list.head;
        LinkedList newList = new LinkedList();
        newList.head = newHead;
        return newList;
    }

    public static Node predecessor(Node node, int data){
        if (node == null || node.next == null){
            System.out.println("Error: Predecessor sought on NULL list");
            return null;
        }
        if (node.next.data == data){
            return node;
        } else {
            return predecessor(node.next, data);
        }
    }

    public static void deleteNode(LinkedList list, int data){
        Node doomed = search(list.head, data);
        if (doomed == null){
            System.out.println("A node with given value does not exist in this list!");
        } else {
            Node predecessor = predecessor(list.head, data);
            if (predecessor == null) {
                /**Removing from the head of the list*/
                list.head = list.head.next;
            } else {
                predecessor.next = doomed.next;
                /**GC will take care of the node that is not used anymore*/
            }
        }
    }
}
