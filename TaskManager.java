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

  // TODO: Ensure that user input all sorts are handled in the Completion status
  // indicator

  public void addTask() {

    System.out.println(
        "Please enter in the Task Name! Followed by the task's status as true for completed or false for uncompleted!");
    String name = UserInput.nextLine();

    System.out.println("Enter in the completion status as 'true' or 'false'");
    boolean Status = Boolean.parseBoolean(UserInput.nextLine());

    Task newTask = new Task(name, Status);
    this.taskHolder.add(newTask);

  }

  /**
   * 
   * @param index User will speify which task they want to delete i.e if they want
   *              to rid task 2 then index will be subtracted by 1 to rid that
   *              task
   * 
   */
  public void deleteTask(int index) {
    this.taskHolder.remove(index - 1);
  }

  public void showTaskList() {
    int taskCounter = 1;

    for (Task TASKS : this.taskHolder) {

      System.out.println(taskCounter + TASKS.getTaskName() + TASKS.getTaskStatus());
      taskCounter++;

    }
  }

}
