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

    public void removeTask(int id){

        taskDB.removeIf(task -> task.getId() == id);

    }
}
