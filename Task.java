public class Task {

  private String taskName = null;
  private boolean taskStatus = false;

  /**
   * @apiNote constructor can allow for nullable empty task names
   */

  public Task() {
    this.taskName = null;
    this.taskStatus = false;
  }

  public Task(String TaskName, boolean TaskStatus) {
    this.taskName = TaskName;
    this.taskStatus = TaskStatus;
  }

  /**
   * @apiNote Getters for task name and task status marked complete from true or
   *          uncomplete from false
   * 
   */
  public String getTaskName() {
    return this.taskName;
  }

  public boolean getTaskStatus() {
    return this.taskStatus;
  }

  /**
   * @apiNote Setters for task name and task status marked complete from true or
   *          uncomplete from false
   * 
   */
  public void setTaskName(String TaskName) {
    this.taskName = TaskName;
  }

  public void setTaskStatus(boolean TaskStatus) {
    this.taskStatus = TaskStatus;
  }

}
