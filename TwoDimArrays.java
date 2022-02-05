import java.util.Random;

public class TwoDimArrays {

  public static boolean unique3x3(int[][] array) {
    String error = "Array size must be 3x3";

    // Check number of rows
    if (array.length != 3) {
      System.out.println(error);
      return false;
    }

    // Check number of columns
    for (int i = 0; i < array[i].length - 1; i++) {
      if (array[i].length != 3) {
        System.out.println(error);
        return false;
      }
    }

    // Execute this if the array is 3x3
    String numsFound = "";
    for (int r = 0; r < array.length; r++) {
      for (int c = 0; c < array[r].length; c++) {
        // ""+ necessary to treat integer as a string
        if (numsFound.indexOf("" + array[r][c]) > -1) {
          return false;
        } else {
          numsFound += array[r][c];
        }
      }
    }
    return true;
  }

  public static int[][] generateTable() {
    Random random = new Random();
    int[][] table = new int[9][9];
    for (int r = 0; r < table.length; r++) {
      for (int c = 0; c < table[r].length; c++) {
        table[r][c] = random.nextInt(9) + 1;
      }
    }
    return table;
  }

  public static void showTable(int[][] array) {
    for (int[] row : array) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  public static void findUnique3x3s(int[][] array) {
    String error = "Array size must be 9x9";

    // Check number of rows
    if (array.length != 9) {
      System.out.println(error);
      return;
    }

    // Check number of columns
    for (int i = 0; i < array[i].length - 1; i++) {
      if (array[i].length != 9) {
        System.out.println(error);
        return;
      }
    }

    // Execute if the array is 9x9
    System.out.println("Searching for unique grids in the following table:");
    showTable(array);
    int gridsFound = 0;

    // row and col are the location in the 9x9 array "array"
    for (int row = 0; row < 7; row++) {
      for (int col = 0; col < 7; col++) {
        int[][] currentGrid = new int[3][3];
        // r and c are the location in the 3x3 array "currentGrid"
        for (int r = 0; r < 3; r++) {
          for (int c = 0; c < 3; c++) {
            currentGrid[r][c] = array[r + row][c + col];
          }
        }
        if (unique3x3(currentGrid)) {
          System.out.println("Unique 3x3 at [" + row + "," + col + "]");
          gridsFound++;
        }
      }
    }
    System.out.println("Found " + gridsFound + " unique sub-grids.");
  }

  public static void main(String[] args) {
    // Tests functionality of unique3x3
    // int[][] numbers = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
    // System.out.println(unique3x3(numbers));

    // Test of sample in project description
    // int[][] numbers = { {1,2,3,4,5,6,7,8,9}, {4,5,6,7,8,9,1,2,3},
    // {7,8,9,1,2,3,4,5,6}, {1,2,3,4,5,6,7,8,9}, {4,5,6,7,8,9,1,2,3},
    // {7,8,9,1,2,3,4,5,6}, {1,2,3,4,5,6,7,8,9}, {4,5,6,7,8,9,1,2,3},
    // {7,8,9,1,2,3,4,5,6} };
    // findUnique3x3s(numbers);

    int[][] table = generateTable();
    findUnique3x3s(table);
  }
}