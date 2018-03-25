//Daniel Gelfand
//APCS2 pd2
//HW17 -- So So Fast
//2018-03-11

public class FastSelect{

  //*****************PARITION***************
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  //O(n)
  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
      }
      swap(s,b,arr);

      return s;
    }//end partition

    //******************************************
    /*ythSmall creturns the yth smallest elements in an inpuuted array.
    First, it checks if the inputted y would cause an out of bounds error, returning -1 if so.
    Second, it obtains the initial pivot point by picking the yth element.
    Third, the pivot value is compared with a partitioned array repeatedley until the pivot value no longer moves.
    If the pivot value does not move, the pivot value its proper position relating to elements that
    are smaller and larger than it - meaning that it is the yth smallest element.
    Lastly, the static pivot value is returned.
    */

    //Best Case(after one paritition the pivot value is the same): O(n)
    //Worst Case(pivot value needs more than 1 parititon to stick): O(n^2)
    public static int ythSmall(int[] arr,int y){
      printArr(arr);
      int partCounter = 1;
      //can't have a yth smallest elements with more the num of elements in arr
      if(y > arr.length) return -1;
      int pivInit = y-1;
      int pivFinal = partition(arr,0,arr.length-1,y-1);
      //keep checking if position of the pivot is maintained.
      while(pivInit != pivFinal){
        //System.out.println(loop);
        pivFinal = partition(arr,0,arr.length-1,y-1);
        partCounter +=1;
      }
      System.out.println("# of Paritions: " + partCounter);
      return arr[pivFinal];

    }
    public static void main(String[] args){
      int[] arr1 = {1,2,3,4};
      int[] arr2 = {4,2,1,3};
      int[] arr3 = {7,1,5,12,3};
      int[] arr4 = {5,3,7,12,1};
      int[] arr5 = {100,5,9,8,6,16,7};

      //***************Best Case(pivot stays in place after one parititon)************
      //1 partition
      System.out.println("3rd smallest element: " + ythSmall(arr1,3)); //3
      System.out.println("1st smallest element: " + ythSmall(arr1,1)); //1
      //******************************************************************************

      //************Worst Case(> 1 paritions are needed for pivot to stay in place)*****
      //3 paritions - O(n^2) While loops compares pivInit and pivFinal in addition to paritioning
      //(which is O(n)) every time an extra parition is needed.
      System.out.println("1st smallest element: " + ythSmall(arr5,1)); //5
      //******************************************************************************

      //*************************TEST TO MAKE SURE METHOD IS WORKING******************
      /*System.out.println("3rd smallest element: " + ythSmall(arr2,3)); //3
      System.out.println("4th smallest element: " + ythSmall(arr2,4)); //4
      System.out.println("1st smallest element: " + ythSmall(arr2,1)); //1
      System.out.println("3rd smallest element: " + ythSmall(arr3,3)); //5
      System.out.println("4th smallest element: " + ythSmall(arr3,4)); //7

      System.out.println("1st smallest element: " + ythSmall(arr4,1)); //1
      System.out.println("2nd smallest element: " + ythSmall(arr4,2)); //3
      System.out.println("3rd smallest element: " + ythSmall(arr4,3)); //5
      System.out.println("4th smallest element: " + ythSmall(arr4,4)); //7
      System.out.println("5th smallest element: " + ythSmall(arr4,5)); //12*/

    }
  }//end class
