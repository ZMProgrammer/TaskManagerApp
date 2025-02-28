import java.util.Scanner;

public class Main {

  static Scanner userIn = new Scanner(System.in);

  public static void main(String[] args) {

    TaskManager newManage = new TaskManager();

    String UserInput = "";

    System.out.println("Hello User!");

    do {
      System.out.println(
          " \n1)Create new Task \n2)Delete task \n3)Show Tasks \nTo exit the program please enter 'q'");
      UserInput = userIn.nextLine().toLowerCase();

      if (UserInput.equals("1")) {
        // Create new task

        newManage.addTask();

      } else if (UserInput.equals("2")) {
        // Delete task
      } else if (UserInput.equals("3")) {
        // Show tasks

        newManage.showTaskList();
      } else if (UserInput.equals("q")) {
        // Exit application

        System.out.println("The program will be exited!");
        System.exit(0);
      } else {

        System.out.println("Your input: " + UserInput + " does not match a valid input!" +
            " please enter from (1), (2), (3), or quit with (q)");
      }

    } while (!UserInput.equals("q"));

  }
}