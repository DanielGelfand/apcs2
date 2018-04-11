//Daniel Gelfand
//APCS2 pd2
//HW #32: Leon Leonwood Stack
//2018-04-12

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

  private LinkedList<PANCAKE> _stack;
  private int _sizeStack;

  public LLStack(){
    //instantiate LinkedList
    _stack = new LinkedList<PANCAKE>();
    _sizeStack = 0;
  }

  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){
    return _sizeStack == 0;
  }

  //Return top element of stack. No popping is performed.
  public PANCAKE peek(){
    return _stack.get(_sizeStack - 1);
  }

  //Pop and return top element of stack.
  public PANCAKE pop(){
    //Nothing to pop in an empty stack
    if( isEmpty() ){
      return null;
    }
    //hold value being popped
    PANCAKE popped = _stack.get(_sizeStack - 1);
    _stack.remove(_sizeStack - 1);
    _sizeStack -= 1;
    return popped;
  }

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ){
    _stack.add(x);
    _sizeStack += 1;

  }



}
