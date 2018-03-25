//Daniel Gelfand
//APCS2 pd2
//HW18 -- QuickSort
//2018-03-13t

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr): Choose a pivot and parition the array. Keep choosing pivots
and paritioning until arrays of size 1 are reached, terminating the recursion and leaving a sorted array.

*
* 2a. Worst pivot choice and associated runtime: Many elements are smaller or greater than the pivot. O(n^2)
Choosing left most or right most element as pivot may not be a good idea especially if you have a sorted array.
*
* 2b. Best pivot choice and associated runtime: Random pivot with O(nlogn) runtime. Used to avoid
getting a pivot with many smaller or greater elements than itself. If this case is avoided, then
at about logn good pivots the recursion will terminate.
*
* 3. Approach to handling duplicate values in array: I don't think there is a need for a specific
case for dupes. Paritioning the dupe of a pivot point will simply put the dupe adjacent to the pivot point.
*
*****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
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
  public static int partition( int arr[], int a, int b)
  {
    //random pivot withing range [a,b]
    int rand = a + (int)(Math.random() * ((b-a)+1));
    int v = arr[rand];

    swap( rand, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
      }
      swap(s,b,arr);

      return s;
    }//end partition

    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
    * void qsort(int[])
    * @param d -- array of ints to be sorted in place
    *****************************************************/
    public static void qsort( int[] d )
    {
      qsortHelp(d,0,d.length-1);
    }

    //you may need a helper method...
    //Helper method for quicksort
    public static void qsortHelp(int[] d, int left, int right){
      if(left < right){
        int pvtPos = partition(d,left,right);
        qsortHelp(d,left,pvtPos-1);
        qsortHelp(d,pvtPos+1,right);
      }
    }
    //main method for testing
    public static void main( String[] args )
    {

      //get-it-up-and-running, static test case:
      int [] arr1 = {7,1,5,12,3};
      System.out.println("\narr1 init'd to: " );
      printArr(arr1);

      qsort( arr1 );
      System.out.println("arr1 after qsort: " );
      printArr(arr1);

      // randomly-generated arrays of n distinct vals
      int[] arrN = new int[10];
      for( int i = 0; i < arrN.length; i++ )
      arrN[i] = i;

      System.out.println("\narrN init'd to: " );
      printArr(arrN);

      shuffle(arrN);
      System.out.println("arrN post-shuffle: " );
      printArr(arrN);

      qsort( arrN );
      System.out.println("arrN after sort: " );
      printArr(arrN);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



      //get-it-up-and-running, static test case w/ dupes:
      int [] arr2 = {7,1,5,12,3,7};
      System.out.println("\narr2 init'd to: " );
      printArr(arr2);

      qsort( arr2 );
      System.out.println("arr2 after qsort: " );
      printArr(arr2);

      int [] arr3 = {7,1,5,12,7,3,1};
      System.out.println("\narr3 init'd to: " );
      printArr(arr3);

      qsort( arr3 );
      System.out.println("arr3 after qsort: " );
      printArr(arr3);


      // arrays of randomly generated ints
      int[] arrMatey = new int[20];
      for( int i = 0; i < arrMatey.length; i++ )
      arrMatey[i] = (int)( 48 * Math.random() );

      System.out.println("\narrMatey init'd to: " );
      printArr(arrMatey);

      shuffle(arrMatey);
      System.out.println("arrMatey post-shuffle: " );
      printArr(arrMatey);

      qsort( arrMatey );
      System.out.println("arrMatey after sort: " );
      printArr(arrMatey);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

  }//end class QuickSort
