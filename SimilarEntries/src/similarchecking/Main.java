package similarchecking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {
  public String main() throws FileNotFoundException {
    try (BufferedReader br = new BufferedReader(new FileReader("advanced.csv"))) {
      ArrayList<String[]> entriesTemp = new ArrayList<>();
      String line;

      while ((line = br.readLine()) != null) {
        String[] entry = line.split(",");
        entriesTemp.add(entry);
      }
      String[][] entries = new String[entriesTemp.size()][entriesTemp.get(0).length];
      entriesTemp.toArray(entries);
      FindDuplicates finder = new FindDuplicates(entries.clone());
      ArrayList<Integer> dups = finder.duplicates();
      ArrayList<Integer> nonDups = new ArrayList<>();

      for (int row = 0; row < entries.length; row++) {
        if (!dups.contains(row)) {
          nonDups.add(row);
        }
      }

      String output = "";

      output += "Duplicate pairs:\n";
      for (Integer row : dups) {
        for (int col = 0; col < entries[row].length; col++) {
          //if statement to not have trailing comma
          if (col == 0) {
            output += (entries[row][col]);
          }
          else {
            output += (", " + entries[row][col]);
          }
        }
        output += "\n";
      }
      System.out.println("Rest of data:");
      for (Integer row : nonDups) {
        for (int col = 0; col < entries[row].length; col++) {
          //if statement to not have trailing comma
          if (col == 0) {
            output += (entries[row][col]);
          }
          else {
            output += (", " + entries[row][col]);
          }
        }
        output += "\n";
      }

      return output;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
