package dto;
import controller.TaskController;
import java.util.*;
import java.time.LocalDateTime;

public class Task {

    private static int Id;
    private int taskId;
    private String taskName;
    private Category taskCategory;
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


    public int getId() { return taskId; }
    public Status getTaskStatus(){  return taskStatus; }

    public String getName() {
        return taskName;
    }

    public Category getCategory() {
        return taskCategory;
    }

    public String getDateTime() {
        return taskDeadline;
    }

    public void setTaskStatus(Status status){
        this.taskStatus=status;
    }
    public void setTaskDeadline(String deadline){
        this.taskDeadline=deadline;
    }
    public void setTaskName(String name){
        this.taskName=name;
    }
    public void setTaskCategory(Category category){
        this.taskCategory=category;
    }
    public String toString()
    {
        return "Task" + taskId +": [Name= "+  taskName +", Category= "+this.taskCategory+ ", taskStatus=" + taskStatus+ ", Deadline= "+taskDeadline +"]\n";
    }

    public static int getTaskAutoId(){
        return taskAutoId++;
    }
}
