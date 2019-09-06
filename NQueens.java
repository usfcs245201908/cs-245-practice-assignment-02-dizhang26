public class NQueens {

    // the number of Queens
    private int n;

    // number of solution,here we use this to determine one solution
    private int count;
    //initilize an array to store queens in one row
    private int[] storeRowQueens;
    //n is the number of queens
    public NQueens(int n) {
        this.n = n;
        this.storeRowQueens = new int[n];
    }
    //check which spot is aviliable for the queens.
    private boolean safeToPut(int[] storeRowQueens, int row) {
        for (int i = 0; i < row; i++) {
            if ((storeRowQueens[i] == storeRowQueens[row])) {
                return false;
            }
            // this means line has two queens
            if (Math.abs(i - row) == Math.abs(storeRowQueens[i] - storeRowQueens[row])) {
                return false;
            }
        }
        return true;
    }

    public boolean placeNQueens() throws Exception {
        // if n < 1 throw exception
        if (n < 1) {
            throw new Exception();
        } else {
            placeNQueens(storeRowQueens, 0 , n);
            if (count == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
//use recursive to place queens
    private void placeNQueens(int[] storeRowQueens, int row ,int n) {
        
        if (row >= n) {
            count++;
            return;
        } else {
            for (int j = 0; j < n; j++) {
                if (count == 1) {
                    return;
                }
                storeRowQueens[row] = j;
                if (safeToPut(storeRowQueens,row)) {
                    //recursive
                    placeNQueens(storeRowQueens, row+1,n);
                }
            }
        }
    }
//print out the board with queens on it.
    public void printToConsole() {
        char[][] nQueensBoard = new char[n][n];
        try {
            if (placeNQueens()) {
                System.out.println(n + " is a valid number!");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (storeRowQueens[i] == j) {
                            nQueensBoard[i][j] = 'Q';
                            System.out.print(nQueensBoard[i][j] + " ");
                        } else {
                            nQueensBoard[i][j] = '-';
                            System.out.print(nQueensBoard[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
            }
            else
                //if the number entered is invalid, it will show this message
                System.out.println(n + " is a Invalid Number!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //if NQueens is ran independently, it will print the six different boards with 
    //different numbers of queens.
    public static void main(String[] args){
        int [] sizes = {1, 6, 8, 18, 2, 3};
        for (int i : sizes){
            NQueens nQueens = new NQueens(i);
            nQueens.printToConsole();
        }
    }

}