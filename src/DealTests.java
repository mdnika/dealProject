import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class DealTests {

  private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

  @Test
  public void testConstructor() throws ParseException {
    // arrange - задание начальных значений
    String name = "Test";
    String dealDate = "21.05.2023";

    Date date = formatter.parse(dealDate);
    // arrange & act - задание начальных значений и совершение действия
    Deal deal = new Deal(name, dealDate);

    // assert - предположение, что результат верен
    assertEquals(name, deal.getName());
    assertEquals(date, deal.getDealDate());
  }

  @Test
  public void testNotEqual() throws ParseException {
    // arrange
    Deal deal1 = new Deal("Test", "21.05.2023");
    Deal deal2 = new Deal("Test", "12.02.2022");

    // act
    int result12 = deal1.compareTo(deal2);
    int result21 = deal2.compareTo(deal1);

    // assert
    assertTrue(result12 > 0); //  deal1 > deal2
    assertTrue(result21 < 0); //  deal2 < deal1
  }

  @Test
  public void testEqual() throws ParseException {
    // arrange
    Deal deal1 = new Deal("Test", "25.04.2023");
    Deal deal2 = new Deal("Test", "25.04.2023");

    // act
    int result11 = deal1.compareTo(deal1);
    int result22 = deal2.compareTo(deal2);
    int result12 = deal1.compareTo(deal2);
    int result21 = deal2.compareTo(deal1);

    // assert
    assertEquals(0, result11); // deal1 == deal1
    assertEquals(0, result22); // deal2 == deal2
    assertEquals(0, result12); // deal1 == deal2
    assertEquals(0, result21); // deal2 == deal1
  }
}
