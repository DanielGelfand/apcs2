//Daniel Gelfand
//APCS2 pd2
//HW51 -- Heaping Piles of Sordidness
//2018-05-21 M

public class HeapSort{

  public static void HeapSort(int[] arr) {

    ALHeapMax temp = new ALHeapMax();

    //creating MaxHeap
    for(int i = 0; i < arr.length; i++ ){
      temp.add(arr[i]);
    }

    //putting back values into array
    for(int i = temp.getSize()- 1; i >=0 ; i--){
      arr[i] = temp.removeMax();
    }

  }

  public static void printArr(int[] arr){
    String res = "[ ";
    for(int i = 0; i < arr.length; i++ ){
      res += arr[i] + " ";
    }
    System.out.println(res + "]");
  }

  public static void main(String[] args){
    int[] test0 = {6,5,10};
    printArr(test0);
    System.out.println("Sorting....");
    HeapSort(test0);
    printArr(test0);

    System.out.println();

    int[] test1 = {7,5,3,12,1};
    printArr(test1);
    System.out.println("Sorting....");
    HeapSort(test1);
    printArr(test1);

    System.out.println();

    int[] test2 = {10,9,8,7,6,5,4,3,2,1};
    printArr(test2);
    System.out.println("Sorting....");
    HeapSort(test2);
    printArr(test2);

  }



} //end class
