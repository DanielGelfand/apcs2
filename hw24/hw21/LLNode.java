/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode next;

  // constructor
  public LLNode(){
    cargo = "";
    next = null;
  }

  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return cargo;
  }

  public LLNode getNext()
  {
    return next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo(String s)
  {
    cargo = s;
    return s;
  }

  public LLNode setNext(LLNode n)
  {
    next = n;
    return n;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return getCargo() + "--->" + getNext();
  }


  //main method for testing
  public static void main( String[] args )
  {
    //PROTIP: try creating a few nodes: traversible, connected...
    //note anything notable as you develop and test...
    LLNode bob = new LLNode();
    LLNode tracy = new LLNode();
    LLNode yolo = new LLNode();

    //Setting cargo
    bob.setCargo("BOB");
    tracy.setCargo("TRACY");
    yolo.setCargo("YOLO");

    bob.setNext(tracy);
    tracy.setNext(yolo);
    System.out.println(bob);
  }//end main

}//end class LLNode
