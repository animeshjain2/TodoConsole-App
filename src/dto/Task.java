package dto;
import controller.TaskController;
import java.util.*;
import java.time.LocalDateTime;

public class Task {

    private static int Id;
    private String Name;
    private Category Category;
    private Status taskStatus;
    private String deadline;

    private static int taskAutoId=0;
    public Task(int id,String taskname, Category taskcategory, String taskDeadline, Status taskStatus)
    {
        this.Id=id;
        this.Name=taskname;
        this.Category=taskcategory;
        this.deadline=taskDeadline;
        this.taskStatus = taskStatus;
    }


    public int getId() { return Id; }
    public Status getTaskStatus(){  return taskStatus; }

    public String getName() {
        return Name;
    }


    public Category getCategory() {
        return Category;
    }

    public String getDateTime() {
        return deadline;
    }

    public String toString()
    {
        return "Name="+this.Name+", Category="+this.Category+", Time="+this.deadline;
    }

    public static int getTaskAutoId(){
        return taskAutoId++;
    }
}
