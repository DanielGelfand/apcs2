//Daniel Gelfand
//APCS2 pd2
//HW33 -- What A Racket
//2018-04-13 F
/*****************************************************
* class Scheme
* Simulates a rudimentary Scheme interpreter
*
* ALGORITHM for EVALUATING A SCHEME EXPRESSION:
*   1. Steal underpants.
*   2. ...
*   5. Profit!
*
* STACK OF CHOICE: ALStack
* b/c pushing to the stack is an enjoyable ammortized constant time.
* Peek runs in constant time.
******************************************************/

public class Scheme
{
  /******************************************************
  * precond:  Assumes expr is a valid Scheme (prefix) expression,
  *           with whitespace separating all operators, parens, and
  *           integer operands.
  * postcond: Returns the simplified value of the expression, as a String
  * eg,
  *           evaluate( "( + 4 3 )" ) -> 7
  *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
  ******************************************************/
  public static String evaluate( String expr )
  {
    //array with split up expression
    String[] tempArray = expr.split("\\s+");
    Stack<String> nums = new ALStack<String>();
    //used for unloads
    Stack<String> tempStack = new ALStack<String>();
    int op = 0;

    for(int i=0; i<tempArray.length; i++){

      if(tempArray[i].equals(")")){

        //while you are not at the bottom of the stack
        while(!nums.peek().equals("(")){
          //check operators and get rid of them afterwards
          if(nums.peek().equals("+")){ op = 1;nums.pop(); }
          else if(nums.peek().equals("-")){ op = 2;nums.pop(); }
          else if(nums.peek().equals("*")){ op = 3;nums.pop(); }
          else{ tempStack.push( nums.pop() ); }

        }
        //get rid of paren below most recently popped number
        nums.pop();

        //push results of operation to the nums array
        nums.push(unload(op,tempStack));
      }
      else{ nums.push(tempArray[i]); }
    }
    //final answer
    return nums.pop();
  }//end evaluate()
  /******************************************************
  * precond:  Assumes top of input stack is a number.
  * postcond: Performs op on nums until closing paren is seen thru peek().
  *           Returns the result of operating on sequence of operands.
  *           Ops: + is 1, - is 2, * is 3
  ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    int total = Integer.parseInt(numbers.pop());

    while(!numbers.isEmpty()){

      if(op == 1)
        total += Integer.parseInt(numbers.pop());
      else if(op == 2)
        total -= Integer.parseInt(numbers.pop());
      else if(op == 3)
        total *= Integer.parseInt(numbers.pop());

    }
    return "" + total;
  }//end unload()

  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
}
catch( NumberFormatException e ) {
return false;
}
}
*/


//main method for testing
public static void main( String[] args )
{

  /*  ALStack test = new ALStack();
  test.push(")");
  test.push("2");
  test.push("1");
  System.out.println(unload(3,test));*/


  String zoo1 = "( + 4 3 )";
  System.out.println(zoo1);
  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
  //...7

  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
  System.out.println(zoo2);
  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
  //...17

  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
  System.out.println(zoo3);
  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
  //...29

  String zoo4 = "( - 1 2 3 )";
  System.out.println(zoo4);
  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
  //...-4
  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
}//main

}//end class Scheme
