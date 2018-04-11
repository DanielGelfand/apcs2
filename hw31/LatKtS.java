//Daniel Gelfand
//APCS2 pd2
//HW31 -- Stack: What is it good for?
//2018-04-11 T

/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

  /**********************************************************
  * precondition:  input string has length > 0
  * postcondition: returns reversed string s
  *                flip("desserts") -> "stressed"
  **********************************************************/
  public static String flip( String s )
  {
    String res = "";
    Latkes t = new Latkes(s.length());

    //input the characters of the string into the stack
    while(s.length() > 0){
      t.push(s.substring(0,1));
      s = s.substring(1);
    }

    //get the reversed string
    while(! t.isEmpty()){
      res += t.pop();
    }

    return res;
  }//end flip()


  /**********************************************************
  * precondition:  s contains only the characters {,},(,),[,]
  * postcondition: allMatched( "({}[()])" )    -> true
  *                allMatched( "([)]" )        -> false
  *                allMatched( "" )            -> true
  **********************************************************/
  public static boolean allMatched( String s )
  {
    Latkes t = new Latkes(s.length());

    //loop through the given string

    for(int i = 0; i < s.length(); i++){
      String curr = s.substring(i,i+1);
      //System.out.println("curr: " + curr);

      //if opening symbol, add to stack
      if(curr.equals("(") || curr.equals("[") || curr.equals("{")){
        t.push(curr);
      }
      else{
        //avoid errors
        if(t.isEmpty()){
          return false;
        }
        //compare opener with closer
        String opener = t.pop();
        if(opener.equals("(") && !curr.equals(")")) return false;
        if(opener.equals("{") && !curr.equals("}")) return false;
        if(opener.equals("[") && !curr.equals("]")) return false;
      }
    }
    //popped all openers
    return t.isEmpty();
  }

  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed")); //desserts
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    System.out.println(allMatched("")); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
