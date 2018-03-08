//Daniel Gelfand
//APCS2 pd2
//HW#16 -- About Face
//2018-03-07

public class Mysterion{

/*
sortLeftRight is given a start position, the end position, and the middle position of the inputted array.
The function finds the integer at the middle index. The ints smaller than the middle value will be placed to
the left of the value. The ints larger than the middle value will be placed to the right of the value.
*/
  public static int sortLeftRight(int start, int end, int mid, int[] arr){
    int v = arr[mid];
    int[] temp = new int[1];
    //swap
    temp[0] = arr[end];
    arr[end] = arr[mid];
    arr[mid] = temp[0];
    int s = start;
    for(int i = start; i < end; i++){
      if(arr[i] < v){
        //swap
        temp[0] = arr[s];
        arr[s] = arr[i];
        arr[i] =temp[0];
        s+=1;
      }
    }
    //swap
    temp[0] = arr[end];
    arr[end] = arr[s];
    arr[s] = temp[0];
    return s;

  }
  public static String arrayLook(int[] arr){
    String ret = "[";
    for(int i: arr){
      ret += i + ",";
    }
    return ret + "]\n";
  }

  public static void main(String[] args){
    int[] arr1 = {7,1,5,12,3};
    int[] arr2 = {7,5,12,1,3};
    int[] arr3 = {1,7,12,5,3};
    int[] arr4 = {5,1,7,12,3};
    int[] arr5 = {7,3,5,1,12};
    int[] arr6 = {7,3,5,1,12,9,10,26};
    System.out.print("Before " + arrayLook(arr1));
    System.out.println(mysterion(0,4,2,arr1));
    System.out.print(arrayLook(arr1));
    System.out.println();

    System.out.print("Before " + arrayLook(arr2));
    System.out.println(mysterion(0,4,2,arr2));
    System.out.print(arrayLook(arr2));
    System.out.println();

    System.out.print("Before " + arrayLook(arr3));
    System.out.println(mysterion(0,4,2,arr3));
    System.out.print(arrayLook(arr3));
    System.out.println();

    System.out.print("Before " + arrayLook(arr4));
    System.out.println(mysterion(0,4,2,arr4));
    System.out.print(arrayLook(arr4));
    System.out.println();

    System.out.print("Before " + arrayLook(arr5));
    System.out.println(mysterion(0,4,2,arr5));
    System.out.print(arrayLook(arr5));
    System.out.println();

    System.out.print("Before " + arrayLook(arr6));
    System.out.println(mysterion(0,6,3,arr6));
    System.out.print(arrayLook(arr6));
    System.out.println();

  }

}//end class
