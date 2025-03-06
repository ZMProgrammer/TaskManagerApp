import java.util.Scanner;
import java.util.ArrayList;

/**
 * The TaskManager class handles the creation, deletion, and display of tasks.
 * It interacts with the user via console input and manages a list of Task
 * objects.
 */
public class TaskManager {

  // List to hold Task objects.
  private ArrayList<Task> taskHolder = new ArrayList<Task>();

  // Scanner to read user input from the console.
  Scanner UserInput = new Scanner(System.in);

  /**
   * Default constructor for TaskManager.
   * Initializes the taskHolder list to manage tasks.
   */
  public TaskManager() {
    this.taskHolder = new ArrayList<Task>();
  }

  /**
   * Prompts the user to add a new task.
   * Reads the task name and its completion status from the user,
   * creates a new Task, and adds it to the taskHolder list.
   */
  public void addTask() {
    System.out.println(
        "Please enter the Task Name");
    String name = UserInput.nextLine();

    System.out.println("Enter the completion status as 'true' or 'false'");
    boolean Status = Boolean.parseBoolean(UserInput.nextLine());

    // Create a new Task with the provided name and status.
    Task newTask = new Task(name, Status);
    this.taskHolder.add(newTask);

    System.out.println("Task has been added.");
  }

  /**
   * Deletes a task based on user input.
   * First, it checks if there are any tasks to delete.
   * Then it calls the auxiliary method to obtain a valid task index.
   * If the index is valid, the corresponding task is removed from the list.
   */
  public void deleteTask() {
    // Check if there are any tasks to delete.
    if (taskHolder.size() == 0) {
      System.out.println("You have 0 Tasks! You cannot delete anything!");
      return;
    }

    // Get the task index for deletion from user input.
    int tempIndex = auxDeleteTask();

    // If tempIndex is -1, it indicates that the deletion was aborted.
    if (tempIndex == -1) {
      System.out.println("Deletion aborted!");
      return;
    }

    // Check if the entered index is greater than the number of tasks.
    if (tempIndex > taskHolder.size()) {
      System.out.println("You entered a task number greater than the amount of tasks you have!");
      return;
    }

    // Remove the task (convert user input from 1-based to 0-based indexing).
    taskHolder.remove(tempIndex - 1);
    System.out.println("Your task at number " + tempIndex + " has successfully been deleted!");
  }

  /**
   * Auxiliary method that prompts the user for a valid task index to delete.
   * The user must enter a positive integer or 'q' to quit.
   *
   * @return the valid task index, or -1 if the user chooses to abort deletion.
   */
  private int auxDeleteTask() {
    boolean properInput = false;
    int tempIndex = -1;
    String Input = null;

    // Loop until proper input is received.
    do {
      System.out.println("Enter an integer for index deletion or 'q' to quit:");
      Input = UserInput.nextLine();

      // If the user inputs 'q', break the loop and return -1.
      if (Input.equalsIgnoreCase("q")) {
        properInput = true;
        break;
      } else {
        try {
          tempIndex = Integer.parseInt(Input);

          // Validate that the entered index is greater than 0.
          if (tempIndex <= 0) {
            System.out.println("You cannot have 0 or negative tasks; please enter a valid task number (e.g., 1)!");
            properInput = false;
          } else {
            properInput = true;
          }
        } catch (NumberFormatException e) {
          // Inform the user if the input is not a valid integer.
          System.out.println("The value entered '" + Input
              + "' is not a valid integer for index deletion or 'q' for quitting deletion!");
        }
      }
    } while (!properInput);

    return tempIndex;
  }

  /**
   * Displays the current list of tasks.
   * If no tasks are present, informs the user that there are no tasks to show.
   */
  public void showTaskList() {
    // If the task list is empty, inform the user.
    if (taskHolder.size() == 0) {
      System.out.println("You have 0 Tasks to show!");
    } else {
      // Iterate over the task list and display each task's details.
      for (Task TASKS : this.taskHolder) {
        System.out.println((taskHolder.indexOf(TASKS) + 1) + ") " +
            TASKS.getTaskName() + "; Status: " + TASKS.showTaskStatus());
      }
    }
  }
}
