/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
public static void main( String[] args )
{

  System.out.print("Testing Stack using ArrayList...\n");

  Stack<String> cakes = new ALStack<String>();
  cakes.push("you");
  cakes.push("are");
  cakes.push("how");
  cakes.push("hello");
  System.out.println(cakes.peek()); //hello

  System.out.println();

  System.out.println(cakes.pop()); //hello
  System.out.println(cakes.pop()); //how
  System.out.println(cakes.pop()); //are
  System.out.println(cakes.pop()); //you

  //stack became empty
  System.out.println(cakes.pop()); //null

  System.out.print("----------------------------------");

  System.out.print("\n");

  System.out.print("Testing Stack using LinkedList...\n");

  Stack<String> cakes2 = new LLStack<String>();
  cakes2.push("nine");
  cakes2.push("eight");
  cakes2.push("seven");
  cakes2.push("had");
  cakes2.push("why");

  System.out.println(cakes2.peek()); //why

  System.out.println();

  System.out.println(cakes2.pop()); //why
  System.out.println(cakes2.pop()); //had
  System.out.println(cakes2.pop()); //seven
  System.out.println(cakes2.pop()); //eight
  System.out.println(cakes2.pop()); //nine
  //stack became empty
  System.out.println(cakes2.pop()); //null

  System.out.print("----------------------------------");

}

}//end class
