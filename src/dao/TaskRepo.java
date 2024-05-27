package dao;

import dto.Task;

import java.util.*;

public class TaskRepo {

    private List<Task> taskDB = new ArrayList<>();

    public void addTask(Task task){
        taskDB.add(task);
    }

    public List<Task> listTask(){
        return taskDB;
    }

    public boolean removeTask(int id){

        if(id>taskDB.size()-1)
        {
            System.out.println("Enter the valid taskId");
            return false;
        }

        return taskDB.removeIf(task -> task.getId() == id);

    }

    public boolean updateTask(int id){

        if(id>taskDB.size()-1){
            System.out.println("Task does not exists!");
            return false;
        }

        return true;
    }

    public Task getTask(int id){
        return taskDB.get(id);
    }
}
