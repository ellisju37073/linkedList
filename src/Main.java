// A complete working Java program to
// demonstrate all insertion methods
// on linked list
//https://www.geeksforgeeks.org/java-program-for-inserting-a-node-in-a-linked-list/
//https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
class LinkedList
{
    // head of list
    Node head;


    // Linked list Node
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public int GetNth(int index)
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    public void insertAtNth(int index, int data)
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
            {
                Node new_node = new Node(data);
                new_node.next = current.next;
                current.next = new_node;
                return;
            }
            count++;
            current = current.next;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
    }

    public void RemoveNth(int index)
    {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (index == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1;
             i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next
                = next; // Unlink the deleted node from list
    }

    // Inserts a new Node at front
    // of the list.
    public void insertAtStart(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        // 3. Make next of new Node as head
        new_node.next = head;

        // 4. Move the head to point to
        // new Node
        head = new_node;
    }

    // Inserts a new node after the
    // given prev_node.
    public void insertAfter(Node prev_node,
                            int new_data)
    {
        // 1. Check if the given Node is null
        if (prev_node == null)
        {
            System.out.println(
                    "The given previous node cannot be null");
            return;
        }

        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        // 4. Make next of new Node as next
        // of prev_node
        new_node.next = prev_node.next;

        // 5. make next of prev_node as
        // new_node
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.
       This method is defined inside
       LinkedList class shown above */
    public void append(int new_data)
    {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty,
              then make the new node as head */
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        /* 4. This new node is going to be
              the last node, so make next
              of it as null */
        new_node.next = null;

        // 5. Else traverse till the last node
        Node last = head;
        while (last.next != null)
            last = last.next;

        // 6. Change the next of last node
        last.next = new_node;
        return;
    }


    /* This function prints contents of
       linked list starting from the
       given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        // Start with the empty list
        LinkedList llist = new LinkedList();

        // Insert 6. So linked list
        // becomes 6->NUllist
        llist.append(6);

        // Insert 7 at the beginning.
        // So linked list becomes
        // 7->6->NUllist
        llist.insertAtStart(7);

        // Insert 1 at the beginning.
        // So linked list becomes
        // 1->7->6->NUllist
        llist.insertAtStart(1);

        // Insert 4 at the end.
        // So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked
        // list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head, 7);
        llist.insertAtNth(0, 5);
        llist.RemoveNth(3);
        System.out.println(
                "Created Linked list is: ");
        llist.printList();

        System.out.println("Element at index 3 is "
                + llist.GetNth(3));

    }
}
// This code is contributed by Rajat Mishra