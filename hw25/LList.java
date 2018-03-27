//Daniel Gelfand
//APCS2 pd2
//HW#25 -- Generically Speaking...
//2018-03-27


/*****************************************************
* class LList
* Implements a linked list of DLLNodes, each containing String data
* new in v2: add-at-index, remove
*****************************************************/

/******************ADVANTAGES**************************
*Setting, getting, and adding to the last index now takes constant time
*Can traverse in both directions.
*Multi-direction traversal allows for choosing best point to start traversal from.
******************************************************/
public class LList<T> implements List<T> //your List interface must be in same dir
{

  //instance vars
  private DLLNode<T> _head;
  private DLLNode<T> _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }

  //check if there are no elements
  //uses _size instance variable
  public boolean isEmpty(){
    return _size == 0;
  }

  //--------------v  List interface methods  v--------------


  //add node to list, containing input String as its data
  public boolean add( T newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _head, null );
    _head = tmp;
    //_tail and _head point to same node initally.  _size has not been updated yet
    if(isEmpty()){
      _tail = _head;
    }
    //set the previous pointer for the _tail once there are 2 nodes
    else if(_size == 2){
      _tail.setPrev(_head.getNext());
    }
    _size++;
    return true;
  }

  //return data in element at position index
  public T get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    T retVal;

    //List traversal is not needed when the last element is wanted
    if(index == _size - 1){
      return _tail.getCargo();
    }

    //walk to desired node
    //Choose whether to traverse from _head or _tail
    if(index < (_size - 1) - index){
      //from _head
      DLLNode tmp = _head; //create alias to head
      for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

      //check target node's cargo hold
      retVal = (T) tmp.getCargo();
      return retVal;
    }
    else{
      //from _tail
      //System.out.println("TRAVERSING FROM TAIL");
      DLLNode tmp = _tail; //create alias to tail

      for( int i=_size-1; i > index; i-- )
      tmp = tmp.getPrev();

      //check target node's cargo hold
      retVal = (T) tmp.getCargo();
      return retVal;

    }
  }
  //overwrite data in element at position index
  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();


    if(index == _size - 1){
      //obtain cargo to be replaced
      T ret = _tail.getCargo();
      //set new cargo
      _tail.setCargo(newVal);
      return ret;
    }

    if(index < (_size - 1) - index){
      DLLNode tmp = _head; //create alias to head
      //walk to desired node from _head
      for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

      //store target node's cargo
      T oldVal = (T) tmp.getCargo();

      //modify target node's cargo
      tmp.setCargo( newVal );

      return oldVal;
    }

    else{
      DLLNode tmp = _tail; //create alias to tail
      //walk to desired node from _head
      //System.out.println("TRAVERSING FROM TAIL");
      for( int i=_size-1; i > index; i-- )
      tmp = tmp.getPrev();

      //store target node's cargo
      T oldVal = (T) tmp.getCargo();

      //modify target node's cargo
      tmp.setCargo( newVal );

      return oldVal;
    }
  }

  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
    add( newVal );

    else if(index == _size - 1){
      //similar to add method that adds node to the front
      //no need for list traversal from _head
      DLLNode temp = new DLLNode(newVal,_tail,_tail.getPrev());
      _tail.getPrev().setNext(temp);
      //set previous pointer for the tail
      _tail.setPrev(temp);
      _size++;
    }
    else {
      DLLNode tmp = _head; //create alias to head

      //walk to node before desired node
      for( int i=0; i < index-1; i++ )
      tmp = tmp.getNext();

      //insert new node
      newNode.setNext( tmp.getNext() );
      newNode.setPrev( tmp );
      tmp.setNext( newNode );

      //increment size attribute
      _size++;
    }
  }


  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    T retVal;

    //if index==0, remove head node
    if ( index == 0 ) {
      //check target node's cargo hold
      retVal = _head.getCargo();

      //remove target node
      _head = _head.getNext();
    }

    else if (index == _size - 1){
      retVal = _tail.getCargo();
      _tail.getPrev().setNext(null);
      _tail = _tail.getPrev();
    }
    else {

      if(index < (_size-1) - index){
        DLLNode tmp = _head; //create alias to head

        //walk to node before desired node from head
        for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

        //check target node's cargo hold
        retVal = (T) tmp.getNext().getCargo();

        //remove target node
        tmp.setNext( tmp.getNext().getNext() );
      }
      else{
        DLLNode tmp = _tail; //create alias to tail
        //walk to node after desired node from head
        //System.out.println("REMOVE! TRAVERSING FROM TAIL");
        for( int i=0; i > index-1; i-- )
        tmp = tmp.getPrev();

        //check target node's cargo hold
        retVal = (T) tmp.getPrev().getCargo();

        //remove target node
        tmp.setPrev( tmp.getPrev().getNext() );

      }
    }
    //decrement size attribute
    _size--;

    return retVal;
  }

  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );
    System.out.println( "3rd item is: " + james.get(2) );

    System.out.println( "...setting 'got' by replacing " + james.set(1,"got") );
    System.out.println( james );

    System.out.println( "...setting 'boot' by replacing " + james.set(3,"boot") );
    System.out.println( james );

    System.out.println( "...setting 'a' by replacing " + james.set(2,"the") );
    System.out.println( james );


    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(james._size-1,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: "
    + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(2): " + james.remove(2) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
    /********************TESTING LINE ************************
    */

  }

}//end class LList
