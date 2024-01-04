import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("<<<< TO-DO Deal List >>>>");

    Scanner scanner = new Scanner(System.in);
    int userChoise = 0;

    DealList current = new DealList();

    do {
      printMenu();
      try {
        userChoise = scanner.nextInt();

        switch (userChoise) {
          case 1: {
            // add deal
            current.addDeal();
            break;
          }
          case 2: {
            // show (print deals)
            current.printDeals();
            break;
          }
          case 3: {
            // search deal by date
            String name = current.searchDeal();
            System.out.println("Deal: " + name); // печатаем результат работы метода
            // }
            break;
          }
          case 4: {
            // delete deal
            String name = current.deleteDeal();
            break;
          }
          case 5: {
            current.writeDeal();
            System.out.println("Check the file: 'res/out.txt'");
            break;
          }
          case 0: {
            // Exit
            return;
          }
          default: {
            System.out.println("Wrong input, try again.");
          }
        } // конец оператора switch
      } catch (InputMismatchException e) { // проверка на некорректный ввод
        System.out.println("Wrong input, try again.");
        scanner.next();
      } catch (ParseException e) {
        System.out.println("Unparseable date, try again.");
      }
    } while (true); // конец цикла while
  }

  public static void printMenu() {
    System.out.println("==== Task Menu ====");
    System.out.println("1. Add Deal.");
    System.out.println("2. Show Deals.");
    System.out.println("3. Search Deal by Date.");
    System.out.println("4. Delete Deal by Name.");
    System.out.println("5. Write DealsList in File - 'res/out.txt'.");
    System.out.println("0. Exit.");
    System.out.println();
    System.out.print("Please input your choice: ");
  }
}
