/**
 * Represents a task with a name and a completion status.
 */
public class Task {

  // The name of the task; can be null.
  private String taskName = null;

  // The status of the task: true if completed, false if not.
  private boolean taskStatus = false;

  /**
   * Default constructor that creates a Task with a null name and false status.
   */
  public Task() {
    this.taskName = null;
    this.taskStatus = false;
  }

  /**
   * Constructs a Task with the specified name and status.
   *
   * @param taskName   the name of the task; may be null
   * @param taskStatus the status of the task; true for completed, false for
   *                   uncompleted
   */
  public Task(String taskName, boolean taskStatus) {
    this.taskName = taskName;
    this.taskStatus = taskStatus;
  }

  /**
   * Returns the name of the task.
   *
   * @return the task name, which may be null
   */
  public String getTaskName() {
    return this.taskName;
  }

  /**
   * Sets the task name.
   *
   * @param taskName the new name of the task
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  /**
   * Sets the task status.
   *
   * @param taskStatus the new status of the task; true for completed, false for
   *                   uncompleted
   */
  public void setTaskStatus(boolean taskStatus) {
    this.taskStatus = taskStatus;
  }

  /**
   * Returns a string representation of the task's status.
   *
   * @return "Completed" if the task is finished, otherwise "Unfinished"
   */
  public String showTaskStatus() {
    if (this.taskStatus) { // no need to compare to true explicitly
      return "Completed";
    } else {
      return "Unfinished";
    }
  }
}
