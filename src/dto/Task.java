package dto;

public class Task implements Comparable<Task> {

//    private static int Id;
    private final int taskId;
    private String taskName;
    private Category taskCategory;  // TaskCategory ENUM
    private Status taskStatus;
    private String taskDeadline;

    private static int taskAutoId=0;
    public Task(int id,String taskname, Category taskcategory, String taskDeadline, Status taskStatus)
    {
        this.taskId=id;
        this.taskName=taskname;
        this.taskCategory=taskcategory;
        this.taskDeadline=taskDeadline;
        this.taskStatus = taskStatus;
    }

    public Task(){
        this.taskId = 0;
    }

    // remove unwanted getters
    public int getTaskId() { return taskId; }
    public Status getTaskStatus(){  return taskStatus; }

    public void setTaskStatus(Status status){
        this.taskStatus=status;
    }
    public void setTaskDeadline(String deadline){
        this.taskDeadline=deadline;
    }
    public String getTaskDeadline(){
        return taskDeadline;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName=taskName;
    }

    public static int getTaskAutoId(){
        return taskAutoId++;
    }

    public int compareTo(Task o) {
        return this.getTaskStatus().compareTo(o.getTaskStatus());
    }

    public Category getTaskCategory() {
        return taskCategory;
    }

    public String toString(){

        return "Task" + taskId +": [Name= "+  taskName +", Category= "+this.taskCategory+ ", taskStatus=" + taskStatus+ ", Deadline= "+taskDeadline+ "]\n";
    }
    public void setTaskCategory(Category taskCategory) {
        this.taskCategory = taskCategory;
    }
}
