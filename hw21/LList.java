//Daniel Gelfand
//APCS2 pd2
//HW#21c -- Rockin' Through The Night
//2018-03-20

public class LList implements List{
  //first node
  private LLNode node;

  public LList(){
    node = new LLNode();
  }
  public boolean add(String x){
    //create a temporary node with given cargo and attach to first node
    LLNode temp = new LLNode();
    temp.setCargo(x);
    temp.setNext(node);
    node = temp;
    return true;

}
public String get(int i){
  //Make sure in range
  if(i >= size()) return "Index too large";
  LLNode temp = node;
  //Cut down until we can get the wanted cargo
  for(int x = i; x > 0; x--){
    temp = temp.getNext();
  }
  return temp.getCargo();
}


public String set(int i, String x ){
  LLNode temp = node;
  for(int j=0; j < i; j++)
  {
    temp = temp.getNext();
  }
  return temp.setCargo(x);
}
public int size(){
  int size = 1;
  LLNode temp = node;
  while(temp.getNext()!=null){
    temp = temp.getNext();
    size +=1;
    //  System.out.println(size);
  }
  return size;
}


public static void main(String[] args){
  LList bob = new LList();
  bob.node.setCargo("bobCargo");
  bob.add("test");
  System.out.println(bob.node);
  //System.out.println(bob.size());
  System.out.println(bob.get(0));
  System.out.println(bob.get(1));
  System.out.println(bob.size());
  bob.set(0,"REPLACEDHAH");
  System.out.println(bob.node);
  bob.add("ADDED");
  System.out.println(bob.node);
  bob.add("AddeD2");
  System.out.println(bob.node);
  //System.out.println(bob.get(2));
  //System.out.println(bob.get(1));
}
}
