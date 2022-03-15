
public class LinkedList {
  
 static class Node {
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
    }
    Node()
    {
        
    }
  }
  public Node head;
 
    Node newhead;
  //Class constructors
  LinkedList() {
    head = null;
  }
  public void insertionSort()
  {

      newhead = null;
      Node current = head;
      while (current != null)
      {
        Node temp = current.next;
          sortedInsert(current);
          current = temp;
      }
      head = newhead;
  }
  void sortedInsert(Node newnode)
  {
      if (newhead == null || newhead.data >= newnode.data)
      {
          newnode.next = newhead;
          newhead = newnode;
      }
      else
      {
          Node current = newhead;
          while (current.next != null && current.next.data < newnode.data)
          {
              current = current.next;
          }
          newnode.next = current.next;
          current.next = newnode;
      }
  }
  
 
 

  public void swapData(Node a,Node b)
  {
      int temp = a.data;
      a.data = b.data;
      b.data = temp;
  }
  public void selectionSort()
  {
      Node auxiliary = this.head;
     Node temp = null;
     Node node = null;
      // Execute linked list node
      while (auxiliary != null)
      {
          node = auxiliary;
          temp = auxiliary.next;
          // Find the minimum node
          while (temp != null)
          {
              if (node.data > temp.data)
              {
                  node = temp;
              }
              // Visit to next node
              temp = temp.next;
          }
          if (auxiliary.data > node.data)
          {
              // Transfer minimum value to initial position
              // Swap the node value
              swapData(auxiliary, node);
          }
          // Visit to next node
          auxiliary = auxiliary.next;
      }
  }
  //insert element
  public void insert(int value) {
    //Create  node
    Node node = new Node();
    node.data = value;
    node.next = null;
    if (head == null) head = node;
    else {
      Node temp = head;
      //find last node
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }

  }
  //Display all Linked List elements
  public void display() {
    if (head != null) {

      Node temp = head;
      while (temp != null) {
        System.out.print("  " + temp.data);
        temp = temp.next;
      }
    } else {
      System.out.println("Empty Linked list");
    }
  }
  //perform bubble sort in single linked list
  public void bubbleSort() {

    if (head != null) {

      Node current = null;

      int status = 0;
      do {
        current = head;
        status = 0;
        while (current != null && current.next != null) {

          if (current.data > current.next.data) {
            //Swap node values
            status = 1;
            current.data = current.data + current.next.data;

            current.next.data = current.data - current.next.data;

            current.data = current.data - current.next.data;
          }
          current = current.next;
        }

      } while (status == 1);

    } else {
      System.out.println("Empty Linked list");
    }
  }

  public static void main(String[] args) {

    LinkedList obj = new LinkedList();
    //insert element of linked list
    obj.insert(7);
    obj.insert(50);
    obj.insert(9);
    obj.insert(42);
    obj.insert(5);
    obj.insert(15);
    System.out.print("Before sort : ");

    //display all node
    obj.display();

    obj.insertionSort();
    obj.bubbleSort();
    obj.selectionSort();
    System.out.print("\nAfter sort  : ");

    obj.display();
  }
}