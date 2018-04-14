//Team Stressed
//Roster: Jerry Ye, Daniel Gelfand, Shayan Chowdhury
//APCS2 pd2
//HW#07 -- A Man, A Plan, A Canal: Panama!
//2018-02-13
public class Resrever{

  //Pre-condition: Inputted a String.
  //Post-condition: Returns the reversed string and is done in O(n) time.
  public static String revN(String str){
    String result = "";
    for(int i = str.length(); i > 0; i--){ //Linear time as increases with number of characetrs in the string
      result += str.substring(i-1, i);
    }
    return result;
  }

  /*  //Pre-condition: Inputted a String.
  //Post-condition: Returns the reversed string and is done in O(nlogn) time.
  public static String revLog(String str){
  if(str.length() <= 1){
  return str;
}

int mid = str.length()/2;
String left = str.substring(mid); //the left comes from the right of inputted string
String right = str.substring(0,mid); //the right comes from the left of the inmputted string
//System.out.println(left);
//System.out.println(right);

// +: constant time but is executed n times
return revLog(left)+revLog(right);

}*/

/*It is impossible to implement a method for the task that runs in O(logn). To obtain the logn
part, splitting into halves would be neccessary. To obtain the reversed string from those halves,
concatenations would have to be performed. The number of concatentions depends on the number of splits,
which depends on the number of characters in the string. This would result in O(nlogn) rather than O(logn).

public static void main(String[] args){
//O(n)
System.out.println(revN("hi")); //"ih"
System.out.println(revN("desserts")); //"stressed"
System.out.println(revN("yooo")); //"ooy"
System.out.println(revN("")); //""
//-------------------------------------
//O(nlogn)
//  System.out.println(revLog("hi")); //"ih"
//    System.out.println(revLog("desserts")); //"stressed"
//System.out.println(revLog("yooo")); //"ooy"
//  System.out.println(revLog("")); //""

}

}//end class
