/**
 * The GenLinkList class holds a generic linked list of generic objects. It has
 * all the methods needed to conduct operations on the nodes of the linked list.
 * 
 *<p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = GenLinkList.Java
 */

package assignment6;

/**
 * GenLinkList is a Public class that has all the methods needed to operate on
 * node objects. To use the GenLinkList class the external code will need to 
 * create and hold a GenLinkList object and send the information required by 
 * its methods.
 * 
 * @param <E> GenLinkList is a generic class.
 */
public class GenLinkList<E> {
    
    private Node head;          // pointer to first Node on the list
    private int size;            //holds the size of the list
    /**
     * GenLinkList() is a no argument constructor that initiates the list by
     * pointing the head to "null".
     */
    public GenLinkList()
    {
        //System.out.println ("** Entered GenLinkList() **");
        head = null;	  // (not necessary, already null)
    }
    
    /**
     * append() accepts a generic object. It then creates a node with the object
     * and adds the node to the end of the list.
     * 
     * @param x object to be added to the end of list.
     */
    public void append(E x)
    {
        //System.out.println ("** Entered append() **");
        // create new Node with "info" member pointing to x
        //System.out.println ("** append() received " + x + " **");
        Node temp = new Node(x);

        if (head == null)           // Check if list is empty
        {
            //System.out.println ("**append() head == null **");
            head = temp;            // put the new Node at head of list.
            size++;
        } 
        else                        // the list is not empty
        {
            Node lastNode = head ;         //used to hold last node when found
            while (lastNode.next != null)  // find the last node (last node has null in next)
            {
                //System.out.println ("**append() lastnode " + lastNode.info + " **");
                lastNode = lastNode.next;	// move to next node
            }
            lastNode.next=temp; //add node to the end of the list
            size++;  //increase size of list
        }
        //System.out.println ("** Exit append() " + size + " **");
    }
    
    /**
     * add() accepts a location as an int and a generic object. It then creates 
     * a node with the object and adds the node in the desired location of the 
     * list and increases the size of the list by 1.
     * 
     * @param element location to place in list
     * @param x       object 
     */
    public void add(int element,E x)
    {
        //System.out.println ("** Entered add() **");
        //System.out.println ("** add() received element " + element + " and item "
        //        + x + " **");
        if (element > size+1) //error location is outside of list bounds +1 is due to adding to the end
        {
            System.out.println ("** add() ERROR!!! Invalid element received"  //display error message.
                    + " **");                            
            return;
        }
        Node temp = new Node(x);         //create a node
        Node appendAfter = head;         //used to hold node that is before the desired location
        int count = 1;                   //Count used to traverse the nodes
        
        if (element == 1)                //if adding to first location
        {
            temp.next = head;            //put location 1 after new node
            head = temp;                 //make head point to new node
            size++;                      //increase size
        }
        else                             //not first location find the location
        {
            while (count != element -1)      //use count to search for the node before location
            {
                appendAfter =  appendAfter.next;      //once found this will hold node 
                count++;                              //not found increase count
                //System.out.println ("** add() count " + count + " **");
            }
            temp.next = appendAfter.next;              //put node pointed by appendAfter behind temp
            appendAfter.next= temp;                    //put temp after appendAfter.
            size++;                                    //increase size
        }
        //System.out.println ("** Exit add() " + size + " **");
        
    }
    /**
     * delete() accepts a location of a node to remove as an int. It removes 
     * the object and decrements the size by 1.
     * 
     * @param element location of element to delete
     */
    public void delete(int element)
    {
        //System.out.println ("** Entered delete() **");
        if (element > size) //error if element is outside of scope
        {                    //display error
            System.out.println ("** delete() ERROR!!! Invalid element received"
                    + " **");
            return;                //exit method.
        }
        Node deleteAfter = head;         //will hold node before delete location
        Node toDelete;                   //holds node to be deleted
        int count = 1;                   //used to find nodes
        
        if (element == 1)                //check if first node is to be deleted.
        {
            head = head.next;            //remove the first node
            size--;                      //decrease size of list by 1
        }
        else                             //not first node so search the list
        {
            while (count != element -1)  //find the node before the location to be deleted
            {
                deleteAfter= deleteAfter.next;              //not found so move to next node
                count++;                                  //increase count
                //System.out.println ("** delete() count " + count + " **");
            }
            toDelete= deleteAfter.next;                  //node to be deleted is the next node from deleteAfter.
            deleteAfter.next = toDelete.next;            //remove the node to be deleted.
            
            size--;                                       //decrease size of list
        }
        //System.out.println ("** Exit delete() " + size + " **");
    }
    
    /**
     * swap() method accepts to locations as integers. It then swaps the location
     * of the desired nodes.
     * 
     * @param m  location of node to be swapped as an integer.
     * @param n  location of other node to be swapped as an integer.
     */
    public void swap(int m, int n)
    {

        //System.out.println ("** Entered swap() " + m + " " + n +  " **");
        if (m==n)              //check if location is the same
            return;            //nothing to be done as cannot trade places with same object.
        Node node1 = findItem(m);   //get the location of the first item.
        Node node2 = findItem(n);   //get location of the next item.
        
        Node beforeNode1 = findItem(m - 1);  //get the node before the first item
        Node beforeNode2 = findItem(n - 1);  //get the node before the second item
        
       //System.out.println ("** beforeNode1 " + beforeNode1.info + " **");
       //System.out.println ("** node1 " + node1.info + " **");
       //System.out.println ("** beforeNode2 " + beforeNode2.info + " **");
       //System.out.println ("** node2 " + node2.info + " **");  
        
        if (m==1)   //if the item to be swaped is the first on the list
        {
            head=node2;              //make head point to second item
            Node temp = node2.next;    //make temp hold the items after the second item
            if (n==2)                  //if the second item is in the second location
            {
                node2.next=node1;      //put the first item behind the second item
                node1.next= temp;      //put the items held by temp behind the original first item.
            }
            else
            {
                node2.next = node1.next;  //put the items behind the first node behind the second node
                beforeNode2.next =node1; //put the first node behind the item before the second nodes original location
                node1.next=temp;         //put the items help by temp (items behind 2nd node original location) behind node1
            }
            return;                    //swap completed return
        }
        else if (n==1)                //check to see if the second location is first on the list
        {
            head = node1;               //swap second item with first
            Node temp = node1.next;     //put all items behind first in temp location
            if (m==2)                   //if first item is second on list
            {
                node1.next=node2;       //make first item opoint to second item
                node2.next= temp;       //put items help in temp behind second item
            }
            else
            {
            node1.next = node2.next;       //put items behind second element behind first element
            node2.next = temp;             //put items held by temp behind second element
            beforeNode1.next = node2;      //put second element in first elements location
            }
            return;   //return
        }
        Node temp =node1.next;            //put items behind first element in temp location
        beforeNode1.next = node2;         //put second element in the original location of first element
        node1.next=node2.next;            //put the items behind second element after the first element
        if ((m-n)==1||(m-n)==-1)          //  if the two elements are next to each other
        {
            node2.next= node1;            //move first element behind second element
        }
        else
        {
        node2.next= temp;                 //move items held by temp behind second element
        beforeNode2.next= node1;          //move first element in second elements original location
        }
               
        //System.out.println ("** Exit swap() **");
  
    }
    
    private Node findItem(int loc)
    {
        //System.out.println ("** Entered findItem() **");
        int count = 1;               //count used to find location
        Node toReturn= head;         //holds the node
        if (loc == 1 || loc == 0)    //check if location desired is 1 or 0
            return head;             //return head
        else                        //look for node 
        {
        while (count != loc )        //traverse list till reach location
            {
                toReturn = toReturn.next;   //move to next node
                count++;                    //increase count
                //System.out.println ("** delete() count " + count + " **");
            }
        return toReturn;             //return node
        }
        
    }
    
    /**
     *reverse() method reverses the order of the objects on the list
     * This is done by reversing the order of the nodes themselves rather than 
     * by swapping the data stored. For each node on the list except the current 
     * “head" node, it deletes the node and inserts it as the new head.	
     * 
     */
    public void reverse()
    {
        if (head==null)                    //Nothing to do if list is empty;
            return;                        
        Node next= head.next;             //Begin with the second node.
        E info;                           //Will hold the information from the node.
        for(int count=1; count < size;count++)       //delete and add each node to the begining.
        {
            info=next.info;                          //get information from the node
            //System.out.println(info);                
            next= next.next;                         //move to the next node before deleting
            //System.out.println("delete");
            this.delete(count+1);                    //delete the node
            //System.out.println("add");
            this.add(1,info);                        //create a new node with the info and add it to the begining
            //System.out.print(this);
            
        }
        /**
         *  reverse() method reverses the order of the objects on the list
        * This is done by reversing the order of the nodes themselves rather than 
        * by swapping the data stored. For each node on the list after the current 
        *  “head” node,, the node after it is moved to the front as the new head.	
        //System.out.println ("** Entered reverse() **");
        //System.out.println("Begin with " + this);
        Node front =head;           //set the front
        Node nextNode =front.next;   //holds the next node to be moved
        Node temp =nextNode.next;   //holds the nodes after the next node to be moved
        Node priorNode= front;      //holds the node prior to the one to be moved.
        
        head = nextNode;           // move the second node in front
	front.next = temp;         //put the items behind the original first node in temp
	head.next = front;        //move the original first item behind the new front
	nextNode = temp;          //move the nextNode over to the next node.
        temp =nextNode.next;      //move temp to the node after next node.
        while (priorNode.next!=null)      //priorNode is the original first item. When this is Null the reverse is complete
        {
          // System.out.println("begin round " + this);
           front =head;           //reset front to point to the first element
	   head = nextNode;       //make nextNode the new head
           nextNode.next=front;   //point the head to the old head element
           priorNode.next= temp;  //put the items behind the moved element behind the original head
           nextNode = temp;        //move over to the next node.
           if (temp!= null)       //check if temp has reached the end
               temp = temp.next;  //assign temp to the next node if temp is null cannot move to a new node.
        }   
        **/
    }
    
    /**
     * clear() method removes all nodes from the list by assigning head to "Null"
     * 
     */
    public void clear()
    {
        //System.out.println ("** Entered clear() **");
        head = null;                // remove all items by assigning head to null
        //System.out.println ("** Exit clear() **");
        size = 0;              //set size to 0
    }
    /**
     * toString() is an overridden method used to return a string of the objects 
     * on the list in the order in which they occur.
     * 
     * @return a formatted string of the objects in the list.
     */
    @Override
    public String toString()
    {
        //System.out.println ("** Entered toString() **");
        String out = "";                //String to return
        Node temp = head; 		// set temp to the begining of the list
        if (temp==null)
            out = "The list is empty.";
        else
        while (temp != null)            // traverse the list till the end
        {
            out += temp.info + "  ";	// add the item to the list
            temp = temp.next;		// move to the next item
        }
        out += "\n";
        
        //System.out.println ("** Exit toString() **");
        return out;  //return the formatted string
    }
    /**
     * Node() is an inner class accessible only to the GenLinkList class.
     * Each Node object has two instance variables: an object of the 
     * “type variable” class, and a pointer to the next node on the list.
     */
    class Node // note: "package" access (no specifier)
    {
        E info;     // each node stores a generic object
                    
        Node next;  // a pointer only used when there is another node on the list

        /**
         * Node() is a constructor that acceppts a generic object and then uses
         * the object to create a node.
         * 
         * @param x A generic object. 
         */
        Node(E x) // constructor takes one param of class E
        {
            //System.out.println ("** Entered Node() **");
            info = x;       // holds the generic object
            next = null;    // initialize to null, will point to another node
                            // when a new node is created.
            //System.out.println ("** Exit Node() **");
        }
        
    } 

    
}
