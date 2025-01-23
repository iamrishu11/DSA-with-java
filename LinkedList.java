public class LinkedList {
    
    // Node class representing each element in the linked list
    private static class Node {
        int data;
        Node next;  
          
        Node(int data) {
            this.data = data;
            this.next = null;  
        } 
    }
    
    private Node head; // Head of the linked list

    // Constructor to initialize the linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Method to insert a new node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete the first occurrence of a node with the given value
    public void delete(int data) {
        if (head == null) return; // List is empty

        // If the node to be deleted is the head
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Search for the node to be deleted
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // If the node to be deleted was found
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Method to display all nodes in the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        
        System.out.println("null");
    }

    // Main method to test the linked list operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);

        System.out.println("Linked List after adding elements:");
        list.display();

        // Deleting an element from the linked list
        list.delete(2);
        
        System.out.println("Linked List after deleting element 2:");
        list.display();
    }
}

