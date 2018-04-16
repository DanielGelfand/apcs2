//KEKE - Daniel Gelfand and Rubin Peci
//APCS2 pd2
//HW35 -- ...Nor Do Aussies
//2018-04-17 T

import java.util.ArrayList;
public class ALQueue<Quasar> implements Queue<Quasar>{

  //Front -> Back (0th index is first in line...)


  ArrayList<Quasar> _queue;

  public ALQueue(){
    //Initialize an ArrayList
    _queue = new ArrayList<Quasar>();
  }

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  //O(n) due to element shift
  public Quasar dequeue(){
    //.remove() returns the element removed
    return _queue.remove(0);
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  //O(1)
  public void enqueue(Quasar x){
    //append element to end of queue
    _queue.add(x);
  }

  //Returns true if this queue is empty, otherwise returns false.
  //O(1)
  public boolean isEmpty(){
    return _queue.size() == 0;
  }

  //Returns the first element of the queue without dequeuing it.
  //O(n)
  public Quasar peekFront(){
    return _queue.get(0);
  }

  //Use ArrayList's toString
  public String toString() {
    return _queue.toString();
  }


  public static void main(String[] args){
    ALQueue keke = new ALQueue();
    keke.enqueue("hello");
    keke.enqueue("nice");
    keke.enqueue("to");
    keke.enqueue("meet");
    keke.enqueue("you");

    System.out.println("Initial: " + keke);
    System.out.println();

    for(int i = 0; i < 5; i++){
      System.out.println("Quick peek: " + keke.peekFront());
      System.out.println("Dequeued: " + keke.dequeue());
    }

    System.out.println();
    System.out.println("Final: " + keke);
    System.out.println("Queue empty? " + keke.isEmpty());

  }
} //end class
