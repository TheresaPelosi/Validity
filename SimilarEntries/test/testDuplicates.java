import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import similarchecking.FindDuplicates;
import static org.junit.Assert.assertEquals;

public class testDuplicates {
  @Test
  public void testDuplicates1() {
    String[][] test1 = {{"1", "James", "Smith", "Northeastern", "j@yahoo.com", "20 Abbey Way",
            null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"1", "Jaymes", "Smith", "Northeastern", "j@yahoo.com", "20 Abbey Way",
                    null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"1", "James", "Schmidt", "Northeastern", "j@yahoo.com", "20 Abbey Way",
                    null, "68468", "Boston", "Massachusetts", "MA", "4679288825"}};

    FindDuplicates find1 = new FindDuplicates(test1);

    assertEquals(find1.duplicates(), new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
  }

  @Test
  public void testDuplicates2() {
    String[][] test1 = {{"1", "James", "Smith", "Northeastern", "j@yahoo.com", "20 Abbey Way",
            null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"1", "Jaymes", "Smith", "Northeastern", "j@yahoo.com", "20 Abbey Way",
                    null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"2", "Biron", "Sales", "Validity", "biron@gmail.com", "4 Court Street",
                    null, "63975", "Boston", "Massachusetts", "MA", "4850894468"}};

    FindDuplicates find1 = new FindDuplicates(test1);

    assertEquals(find1.duplicates(), new ArrayList<Integer>(Arrays.asList(0, 1)));
  }

  @Test
  public void testDuplicates3() {
    String[][] test1 = {{"1", "James", "Smith", "Northeastern", "j@yahoo.com", "20 Abbey Way",
            null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"1", "Robert", "Shu", "Northeastern", "j@yahoo.com", "20 Abbey Way",
                    null, "68468", "Boston", "Massachusetts", "MA", "4679288825"},
            {"2", "Biron", "Sales", "Validity", "biron@gmail.com", "4 Court Street",
                    null, "63975", "Boston", "Massachusetts", "MA", "4850894468"}};

    FindDuplicates find1 = new FindDuplicates(test1);

    assertEquals(find1.duplicates(), new ArrayList<Integer>(Arrays.asList(0, 1)));
  }
}
