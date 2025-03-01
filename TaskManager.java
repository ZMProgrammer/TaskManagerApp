import java.util.Scanner;
import java.util.ArrayList;

public class TaskManager {

  private ArrayList<Task> taskHolder = new ArrayList<Task>();
  Scanner UserInput = new Scanner(System.in);

  /**
   * @apiNote Creates an empty taskList Array for decleration purposes
   */
  public TaskManager() {
    this.taskHolder = new ArrayList<Task>();
  }

  public void addTask() {

    System.out.println(
        "Please enter in the Task Name! Followed by the task's status as true for completed or false for uncompleted!");
    String name = UserInput.nextLine();

    System.out.println("Enter in the completion status as 'true' or 'false'");
    boolean Status = Boolean.parseBoolean(UserInput.nextLine());

    Task newTask = new Task(name, Status);
    this.taskHolder.add(newTask);

    System.out.println("Task has been added.");

  }

  /**
   * 
   * @param index User will speify which task they want to delete i.e if they want
   *              to rid task 2 then index will be subtracted by 1 to rid that
   *              task
   * 
   */
  public void deleteTask(int index) {
    boolean validInput = false;

    if (taskHolder.isEmpty()) {
      System.out.println("You have 0 Tasks! There are no tasks to delete.");
      return;
    }

    while (!validInput) {
      if (index < 1) {
        System.out.println("Invalid task number: Task numbers must be 1 or greater.");
        System.out.print("Please enter a valid task number: ");
        try {
          index = Integer.parseInt(UserInput.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Error: Please enter a numeric value.");
        }
      } else if (index > taskHolder.size()) {
        System.out.println("Invalid task number: You only have " + taskHolder.size() + " tasks.");
        System.out.print("Please enter a valid task number: ");

        try {
          index = Integer.parseInt(UserInput.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Error: Please enter a numeric value.");
        }
      } else {
        validInput = true;
      }
    }

    // Remove the task, adjusting for zero-based indexing
    taskHolder.remove(index - 1);
    System.out.println("Task " + index + " has been removed.");
  }

  public void showTaskList() {

    if (taskHolder.size() == 0) {
      System.out.println("You have 0 Tasks to show!");
    }

    else {

      for (Task TASKS : this.taskHolder) {

        System.out
            .println(taskHolder.indexOf(TASKS) + 1 + ")" + " " + TASKS.getTaskName() + " " + TASKS.getTaskStatus());

      }
    }
  }

}
