package similarchecking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import doublemetaphone.DoubleMetaphone;

public final class FindDuplicates {
  private final String[][] entries;
  private HashMap<Integer, Integer> rowScore = new HashMap<>();

  /**
   * Converts parsed csv file to double metaphone equivalent.
   * Loads hashmap with the indexes of each row with an initial duplicate
   * value of 0.
   * @param e The parsed csv file in the form of a 2d String array.
   */
  public FindDuplicates(String[][] e) {
    DoubleMetaphone metaphone = new DoubleMetaphone();

    for (String[] row : e) {
      for (String col : row) {
        col = metaphone.doubleMetaphone(col);
      }
    }

    this.entries = e;
    for (int row = 0; row < e.length; row++) {
      rowScore.put(row, 0);
    }
  }

  /**
   * Looks for duplicate or similar entries within an array of Strings, where every row is
   * one entry. Checks whether entries are similar and if they are treats them the same as
   * duplicates.
   *
   * Duplicate criteria:
   * Goes through duplicate applicable columns (first name, last name, company, email, phone number)
   * and tallies how many contains duplicates. If tally > 3, then entry is most likely
   * a duplicate.
   * @return The index of the duplicate pairs
   */
  public ArrayList<Integer> duplicates() {
    ArrayList<Integer> rowsToCompute = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 11));
    ArrayList<Integer> indexSimilarPairs = new ArrayList<>();
    for (int i: rowsToCompute) {
      this.similarRows(i);
    }

    for (Map.Entry<Integer, Integer> row : rowScore.entrySet()) {
      if (row.getValue() > 3) {
        indexSimilarPairs.add(row.getKey());
      }
    }
    return indexSimilarPairs;
  }

  /**
   * Computes whether a column contains any duplicate entries.
   * EFFECT: Mutates hashmap rowScore for each duplicate identified.
   * @param colNum The column the comparison should run through
   */
  private void similarRows(int colNum) {
    HashMap<String, Integer> map = new HashMap<>();

    for (int row = 0; row < this.entries.length; row++) {
      if (entries[row].length > colNum) {
        if (map.isEmpty() || !map.containsKey(this.entries[row][colNum])) {
          map.put(this.entries[row][colNum], row);
        } else {
          rowScore.replace(row, rowScore.get(row) + 1);
          rowScore.replace(map.get(this.entries[row][colNum]),
                  rowScore.get(map.get(this.entries[row][colNum])) + 1);
        }
      }
    }
  }
}
