import java.util.Scanner;

/**
 * The Application class serves as the main controller for the task management
 * application.
 * It handles user interactions through the console and delegates task
 * operations to the TaskManager.
 */
public class Application {

  // Instance of TaskManager to manage tasks (add, delete, display)
  private TaskManager taskManager = new TaskManager();

  // Scanner for reading user input from the console
  private Scanner userIn = new Scanner(System.in);

  /**
   * Starts the application by displaying a menu of options for the user.
   * The loop continues until the user enters 'q' to quit.
   */
  public void start() {
    String userInput;
    System.out.println("Hello User!");

    // Main loop for user interaction
    do {
      // Display menu options
      System.out.println("\n1) Create new Task\n2) Delete task\n3) Show Tasks\nTo exit the program please enter 'q'");

      // Read user input and convert it to lowercase for case-insensitive matching
      userInput = userIn.nextLine().toLowerCase();

      // Process the user input using a switch-case structure
      switch (userInput) {
        case "1":
          // Delegate to TaskManager to add a new task
          taskManager.addTask();
          break;
        case "2":
          // Inform the user about deletion specifics and delegate deletion to TaskManager
          System.out.println("Please indicate the number of the task you would like to delete.");
          taskManager.deleteTask();
          break;
        case "3":
          // Delegate to TaskManager to display the list of tasks
          taskManager.showTaskList();
          break;
        case "q":
          // Inform the user and prepare to exit the program
          System.out.println("The program will now exit!");
          break;
        default:
          // Handle any unrecognized input by notifying the user
          System.out.println("Your input does not match a valid option! Please enter (1), (2), (3), or (q) to quit.");
      }
    } while (!userInput.equals("q")); // Continue the loop until 'q' is entered

    // Close the scanner to free system resources
    userIn.close();
  }
}
