import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.Date;
import java.text.ParseException;

public class DealList {

  private List<Deal> deals = new ArrayList<>();

  // метод добавляет задание
  public void addDeal() throws ParseException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input name: ");
    String name = scanner.nextLine();
    while (name.isEmpty()) {
      System.out.println("The name can't be empty. Please, try again!");
      System.out.print("Input name: ");
      name = scanner.nextLine();
    }
    System.out.print("Input date in format 'dd.mm.yyyy': ");
    String dealDate = scanner.nextLine();

    deals.add(new Deal(name, dealDate));

  }

  public void writeDeal() throws IOException {
    File outputFile = new File("res/out.txt");
    FileWriter outputFileWriter = new FileWriter(outputFile);
    // в конец строки ставим `\n` - символ конца строки
    for (Deal deal : deals) {
      outputFileWriter.write(deal + "\n");
    }
    outputFileWriter.close();
  }

  // метод печатает все задания
  public void printDeals() {
    Collections.sort(deals);
    // цикл for each переберет весь массив и напечатает
    if (deals.isEmpty()) {
      System.out.println(">>> TO-DO List is empty. <<<");
    }
    for (Deal deal : deals) {
      System.out.println(deal);
    }
  }

  public String searchDeal() throws ParseException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input a date to search in list (dd.mm.yyyy): ");
    Date dealDate = Deal.formatter.parse(scanner.nextLine());
    for (int i = 0; i < deals.size(); i++) {
      if (dealDate.equals(deals.get(i).getDealDate())) {
        // System.out.println("Deal is present: " + i);
        return deals.get(i).getName();
      }
    }
    return "NOT FOUND";
  }

  // метод для удаления задания
  public String deleteDeal() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input a name to delete: ");
    String name = scanner.next();
    for (int i = 0; i < deals.size(); i++) {
      if (name.equals(deals.get(i).getName())) {
        System.out.println("To delete: " + deals.get(i).getName());
        return deals.remove(i).getName();
      }
    }
    System.out.println("Deal not present.");
    return "Deal not present.";
  }
}
