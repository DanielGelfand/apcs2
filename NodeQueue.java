//Daniel Gelfand
//APCS2 pd2
//HW34 -- The English Do Not Wait In Line
//2018-04-16 M

public class NodeQueue<Quasar> implements Queue<Quasar>{

  LLNode<Quasar> front;
  LLNode<Quasar> back;

  public NodeQueue(){
    //no front or back initially
    front = null;
    back = null;
  }

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public Quasar dequeue(){
    //store value that is dequeued
    Quasar dequeued = front.getValue();
    //adjust the front
    front = front.getNext();
    return dequeued;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( Quasar x ){
    //with one element front and back point to the same node
    if(this.isEmpty()){
      front = new LLNode(x,null);
      back = front;
    }
    else{
      //add a node and adjust the back to accomodate the new node
      back.setNext( new LLNode(x,back.getNext() ) );
      back = back.getNext();
    }
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
    return front == null;
  }

  //Returns the first element of the queue without dequeuing it.
  public Quasar peekFront(){
    return front.getValue();
  }
  public static void main(String[] args){

    NodeQueue<String> test = new NodeQueue<String>();

    System.out.println("Is the Queue currently empty: " + test.isEmpty()); //true

    test.enqueue("hi");
    test.enqueue("how");
    test.enqueue("are");
    test.enqueue("you");
    test.enqueue("today");

    System.out.println("Is the Queue currently empty: " + test.isEmpty()); //false
    System.out.println("Peek: " + test.peekFront()); //hi

    test.dequeue();
    System.out.println("Peek after dequeue: " + test.peekFront()); //how
    test.dequeue();
    System.out.println("Peek after dequeue: " + test.peekFront()); //are
    test.dequeue();
    System.out.println("Peek after dequeue: " + test.peekFront()); //you
    test.dequeue();
    System.out.println("Peek after dequeue: " + test.peekFront()); //today

    //NullPointer Exception
    //test.dequeue();
    //System.out.println("Peek after dequeue: " + test.peekFront()); //today

  }

} //end class
