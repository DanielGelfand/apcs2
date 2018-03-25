//Daniel Gelfand
//APCS2 pd2
//HW#10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-27

/***
* class QueenBoard
* Generates solutions for N-Queens problem.
*/

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
  * precondition: board is filled with 0's only.
  * postcondition:
  * If a solution is found, board shows position of N queens,
  * returns true.
  * If no solution, board is filled with 0's,
  * returns false.
  */
  public boolean solve()
  {
    if(solveH(0)){
      this.printSolution();
      return true;
    }
    else{
      System.out.println(this);
      return false;
    }
  }


  /**
  *Helper method for solve.
  */
  private boolean solveH( int col )
  {
    if(col == _board.length) return true;
    for(int r = 0; r < _board.length; r++){
      if(addQueen(r,col)){
        //check if added queen works

        //keep calling to solve for next column
        if(solveH(col + 1)){
          //we doneso if this thing made it here
          return true;
        }
        //if we couldn't solve for the next column remove the queen we placed.
        //we shall try another row then through the for loop.
        removeQueen(r,col);
      }
    }
    return false;
  }

  /** Print board, a la toString...
  Except:
  all negs and 0's replaced with underscore
  all 1's replaced with 'Q'
  */

  public void printSolution()
  {
    String str = "";
    //loops through board and checks the values to replace
    for(int r = 0; r < _board.length; r++){
      for(int c= 0; c < _board[0].length; c++){
        if(_board[r][c]==1){
          str += "Q";
        }
        else {
          str += "_";
        }
        str+="\t";
      }
      str += "\n";
    }
    System.out.println(str);
  }



  //================= YE OLDE SEPARATOR =================

  /***
  * Adds queen to the chessboard and replaces the queen's possible paths with negatives.
  Ignores column of queen placement.
  * precondition: Row and col have to be in the bounds of the chessboard
  * postcondition: Adds queen to specified position and replaces closed off paths with negatives.
  */
  private boolean addQueen(int row, int col){
    //if queen is already in that place
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--; //diagonals
      }
      if(row + offset < _board.length){ //diagonals
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
  * Reverses what addQueen does.
  * precondition: Row,col in bounds of chessboard
  * postcondition: If there is a queen at a square, removes the queens and opns previously closed paths
  by adding to negatives in the chessboard.
  */
  private boolean removeQueen(int row, int col){
    //checks if specified position has a queen
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) { //diagonal
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) { //diagonal
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
  * Prints the chess board with locations of queens(1) and the paths they can take(<0).
  * precondition: Given 2D array
  * postcondition: Returns the current chess board
  */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard a = new QueenBoard(3);
    QueenBoard b = new QueenBoard(4);
    QueenBoard c = new QueenBoard(5);
    QueenBoard d= new QueenBoard(6);
    QueenBoard e= new QueenBoard(7);
    QueenBoard f= new QueenBoard(8);

    //System.out.println(b);
    //b.addQueen(0,0);
    //b.addQueen(0,1);
    //System.out.println(b);
    //  b.addQueen(4,0);
    //	b.removeQueen(3,0);
    //b.addQueen(3,2);
    //System.out.println(b);
    //printSolution() works
    //b.printSolution();
    a.solve();
    System.out.println("\n");
    b.solve();
    System.out.println("\n");
    c.solve();
    System.out.println("\n");
    d.solve();
    System.out.println("\n");
    e.solve();
    System.out.println("\n");
    f.solve();

  }

}//end class
