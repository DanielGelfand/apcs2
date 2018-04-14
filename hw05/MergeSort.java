//Daniel Gelfand
//APCS2 pd2
//HW#05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2018-02-06
/*======================================
class MergeSort
Implements mergesort on array of ints.

Summary of Algorithm:

Divide and Conquer!

MergeSort divides an inputted array into halves, calling itself
until sorted arrays(arrays of length 1) are achieved. Note that this a
precondition for our merge method to work. The subarrays are then merged
until a sorted array with the original inputted array length is attained.

======================================*/

public class MergeSort
{
  /******************************************************
  * int[] merge(int[],int[])
  * Merges two input arrays
  * Precond:  Input arrays are sorted in ascending order
  * Postcond: Input arrays unchanged, and
  * output array sorted in ascending order.
  ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int aIndex =  0;
    int bIndex = 0;
    int aLen = a.length;
    int bLen = b.length;
    int[] merged = new int[aLen + bLen];
    int mIndex= 0;
    while(aIndex < aLen && bIndex < bLen){
      //Begin element comparisons
      if(a[aIndex] <= b[bIndex]){
        merged[mIndex] = a[aIndex];
        aIndex+=1;
      }
      else{
        merged[mIndex] = b[bIndex];
        bIndex += 1;
      }
      mIndex += 1;

    }

    //Copy over remaining elements
    while(aIndex < aLen){
      merged[mIndex] = a[aIndex];
      aIndex+=1;
      mIndex+=1;
    }
    while(bIndex < bLen){
      merged[mIndex] = b[bIndex];
      bIndex += 1;
      mIndex += 1;
    }

    return merged;
  }//end merge()


  /******************************************************
  * int[] sort(int[])
  * Sorts input array using mergesort algorithm
  * Returns sorted version of input array (ascending)
  ******************************************************/
  public static int[] sort( int[] arr )
  {
    //printArray(arr);
    int n = arr.length;
    int mid = n / 2;

    if(n < 2){ //base case
      return arr;
    }
    else{

      int[] left = new int[mid];
      int[] right = new int[arr.length - mid];

      for(int i = 0; i < mid; i+=1){
        left[i] = arr[i];
      }
      //System.out.println("left");
      //printArray(left);
      for(int j = mid; j < n;j+=1){
        right[j - mid] = arr[j];
      }
      //System.out.println("right");
      //printArray(right);
      return merge(sort(left),sort(right));
    }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
    a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
    System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {


    int[] arr0 = {0};
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {3,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {4,3,2,1};
    int[] arr6 = {9,42,17,63,0,512,23};
    int[] arr7 = {9,42,17,63,0,9,512,23,9};
    int[] arr8 = {1,4,100,200,400};
    int[] arr9 = {-5,-4,-3,-2,-1,100};
    int[] arr10 = {4,3,1};

  //  System.out.println("\nTesting mess-with-array method...");
  //  printArray( arr3 );
    //mess(arr3);
    //printArray( arr3 );

    System.out.println("\nMerging arr1 and arr0: ");
    printArray( merge(arr1,arr0) );

    System.out.println("\nMerging arr4 and arr8: ");
    printArray( merge(arr4,arr8) );

    System.out.println("\nMerging arr4 and arr9: ");
    printArray( merge(arr4,arr9) );

    //System.out.println("\nMerging arr2 and arr3: ");
    //printArray( merge(arr2,arr3) );

    System.out.println();
    System.out.println("\nSorting arr4-7...");
    printArray( sort( arr4 ) );
    printArray( sort( arr5 ) );
    printArray( sort( arr6 ) );
    printArray( sort( arr7 ) );
    printArray( sort( arr10 ) );

    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
