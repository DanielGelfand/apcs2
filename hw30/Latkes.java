//Daniel Gelfand
//APCS2 pd2
//HW30 -- Stacks on Stacks on Stacks on Stacks…
//2018-04-10 T

/*****************************************************
* skeleton for class Latkes
* Implements a stack of Strings using an encapsulated array
*****************************************************/

public class Latkes
{
  private String[] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
    _stack = new String[size];
    _stackSize = 0;

  }

  //means of insertion
  public void push( String s )
  {

    //if the stack is full ignore requests to push
    if( isFull() ){
      return;
    }
    //shift elements
    for(int i = _stackSize - 1; i >= 0 ; i--){
      _stack[i + 1] = _stack[i];

    }
    //insert to top of stack
    _stack[0] = s;
    _stackSize += 1;
  }

  //means of removal
  public String pop( )
  {
    //can't remove top element with an empty stack
    if( isEmpty()){
      return null;
    }

    //stored the element to be popped
    String popped = _stack[0];

    //shift elements
    for(int i = 0; i < _stack.length - 1; i ++ ){
      _stack[i] = _stack[ i + 1];
    }

    _stackSize -= 1;
    return popped;
  }

  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }

  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }


  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    //  tastyStack.push("coocoo"); ignored
    //tastyStack.push("cachoo"); ignored

    //cachoo
    //System.out.println( tastyStack.pop() );
    //coocoo
    //System.out.println( tastyStack.pop() );

    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );


  }//end main()

}//end class Latkes
