//Daniel Gelfand
//APCS2 pd2
//HW #32: Leon Leonwood Stack
//2018-04-12
import java.util.ArrayList;
public class ALStack<PANCAKE> implements Stack<PANCAKE>{

  private ArrayList<PANCAKE> _stack; //stack variable
  private int _sizeStack;

  public ALStack(){
    //instantiate ArrayList
    _stack = new ArrayList<PANCAKE>();
    _sizeStack = 0;
  }

  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){
    return _sizeStack == 0;
  }

  //Return top element of stack without popping it.
  public PANCAKE peek(){
    return _stack.get(_sizeStack - 1);
  }

  //Pop and return element popped
  public PANCAKE pop(){
    //Don't use pop on an empty stack
    if( isEmpty() ){
      return null;
    }
    //variable to hold value at _sizeStack
    PANCAKE popped = _stack.get(_sizeStack - 1);
    _stack.remove(_sizeStack - 1);
    _sizeStack -= 1;
    return popped;
  }

  //Push an element onto top of this stack.
  public void push(PANCAKE x){
    _stack.add(x);
    _sizeStack += 1;
  }




}
