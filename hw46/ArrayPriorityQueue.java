//Daniel Gelfand and Maxwell Vale
//APC2 pd2
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-10 R

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

  private ArrayList<String> _queue;

  public ArrayPriorityQueue(){
    _queue = new ArrayList<String>();
  }


  //Adds an item to this priority queue.
  //O(1) - amortized constant time
  public void add(String s){
    _queue.add(s);
  }

  //Returns true if this stack is empty, otherwise returns false.
  //O(1)
  public boolean isEmpty(){
    return _queue.isEmpty();
  }

  //Returns the smallest item stored in this priority queue without removing it.
  //O(n)
  public String peekMin(){

    //find the smallest item in the queue
    String curr = _queue.get(0);
    String min = curr;
    for(int i = 1; i < _queue.size(); i++){

      curr = _queue.get(i);

      //  System.out.println("Curr:" + curr);
      //  System.out.println("Min:" + min);
      if(curr.compareTo( min ) <= 0) {
        //update min
        min = curr;
      }
    }
    return min;
  }

  //Removes and returns the smallest item stored in this priority queue.
  //O(n)
  public String removeMin(){
    return _queue.remove( _queue.indexOf( peekMin() ) );
  }

  public String toString(){
    return _queue.toString();
  }

  public static void main(String[] args){

    ArrayPriorityQueue bob = new ArrayPriorityQueue();
    bob.add("foo");
    bob.add("moo");

    System.out.println("Current Priority Queue: " + bob);

    System.out.println("Min: "  + bob.peekMin());
    bob.removeMin();
    System.out.println("Priority Queue After dequeue: " + bob); //[moo]

    bob.add("goo");
    bob.add("hoo");
    bob.add("doo");

    System.out.println("Current Priority Queue: " + bob);

    System.out.println("FINDING MIN... "  + bob.peekMin());
    bob.removeMin();
    System.out.println("Priority Queue After dequeue: " + bob);


  }

} //end class
