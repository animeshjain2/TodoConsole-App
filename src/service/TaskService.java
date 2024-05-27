package service;

import dao.TaskRepo;
import dto.Task;

import java.util.List;

public class TaskService {

    private TaskRepo taskrepo = new TaskRepo();

    public void addTask(Task task){
        taskrepo.addTask(task);
    }

    public List<Task> listTask(){
        return taskrepo.listTask();
    }

    public boolean removeTask(int id){
        return taskrepo.removeTask(id);
    }

    public boolean updateTask(int id){
        return taskrepo.updateTask(id);
    }

    public Task getTask(int id){
        return taskrepo.getTask(id);
    }
}
