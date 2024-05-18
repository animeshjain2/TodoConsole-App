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

    public void removeTask(int id){
        taskrepo.removeTask(id);
    }
}
