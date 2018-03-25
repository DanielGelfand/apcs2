//Daniel Gelfand
//APCS2 pd2
//HW#24a -- On The DLL
//2018-03-26

/*****************************************************
* class DLLNode
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type String
*****************************************************/

public class DLLNode
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  public DLLNode(String value, DLLNode next, DLLNode prev){
    _cargo = value;
    _prevNode = prev;
    _nextNode = next;
  }

  //--------------v  ACCESSORS  v--------------
  public String getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }

  public DLLNode getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo ) {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext ) {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev(DLLNode newPrev){
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }

  public static void main(String[] args){
    DLLNode bob = new DLLNode("A",null,null);
    bob.setNext(new DLLNode("B",null,bob));
    System.out.println(bob);
    System.out.println(bob.getNext());

  }

}//end class DLLNode
