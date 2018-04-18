//Daniel Gelfand
//APCS2 pd2
//HW36 -- Now Let’s Consider You Lot at Fake Terry’s
//2018-04-18 W

/*****************************************************
* class RQueue
* A linked-list-based, randomized queue
* (a collection with FIIDKO property)
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point opposite direction for O(1) en/dequeuing
*            N <- N <- ... <- N <- N
*      _end -^                     ^- _front
*
******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = null;
    _end = null;
    _size = 0;
  }//end default constructor


  public void enqueue( T enQVal )
  {
    //With 1 node front and end point to same node
    if(this.isEmpty())
    {
      _front = new LLNode(enQVal,null);
      _end = _front;

    }
    else{
      _end.setNext( new LLNode(enQVal,_end.getNext() ) );
      _end = _end.getNext();
    }
    _size++;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    //jst in case user tries to be funny
    if(isEmpty()){
      return null;
    }

    else{
      //store value that is dequeued
      T dequeued  = _front.getValue();
      //adjust the front
      _front = _front.getNext();

      //sample();

      _size--;
      return dequeued;
    }
  }//end dequeue()

  //Get front value
  public T peekFront()
  {
    return _front.getValue();
  }


  /******************************************
  * void sample() -- a means of "shuffling" the queue
  * Algo:
  * Dequeue and enqueue multiple times to shuffle the queue
  *
  ******************************************/
  public void sample ()
  {
    //Shuffle queue
    for(int i = 0; i < (int) ( Math.random() * _size ); i++ ){
      enqueue(dequeue());
    }
  }//end sample()


  public boolean isEmpty()
  {
    return _size == 0;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT-> ";
    LLNode tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getValue() + " -> ";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

    RQueue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dreaded");
    //System.out.println(PirateQueue._front);
    //System.out.println(PirateQueue._front.getNext());
    System.out.println(PirateQueue._end);

    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Robert");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("end:" + PirateQueue._end);
    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );
    PirateQueue.sample();
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...");
    System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
