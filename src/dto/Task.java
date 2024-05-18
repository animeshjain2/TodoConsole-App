package dto;
import controller.TaskController;
import java.util.*;
import java.time.LocalDateTime;

public class Task {

    private int Id;
    private String Name;
    private String Category;
    private String dateTime;

    public Task(int id,String taskname, String taskcategory, String taskDeadline)
    {
        this.Id=id;
        this.Name=taskname;
        this.Category=taskcategory;
        this.dateTime=taskDeadline;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getCategory() {
        return this.Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String toString()
    {
        return this.Name;
    }

}
