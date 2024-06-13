package dao;

import dto.Task;
import com.google.gson.*;

import java.util.*;

public class TaskRepo {

    private List<Task> taskDB = new ArrayList<>();

    public void addTask(Task task){
        taskDB.add(task);
    }

    public List<Task> listTask(){
        Collections.sort(taskDB);
//        2nd Method
//        Collections.sort(taskDB, new Comparator<Task>() {
//            @Override
//            public int compare(Task o1, Task o2) {
//
//                return o1.getTaskStatus().compareTo(o2.getTaskStatus());
//            }
//        });
        return taskDB;
    }

    public void setTask(List<Task> taskList){
        taskDB=taskList;
    }



    public boolean removeTask(int id){

        if(id>taskDB.size()-1)
        {
            System.out.println("Enter the valid taskId");
            return false;
        }

        return taskDB.removeIf(task -> task.getTaskId() == id);

    }

    public boolean updateTask(int id){

        if(id>taskDB.size()-1){
            System.out.println("Task does not exists!");
            return false;
        }

        return true;
    }

    public Task getTask(int id) {
        return taskDB.get(id);
    }

    public List<String> fuzzySearchTask(String taskname){
        List<String> tasks = new ArrayList<>();

        for(Task task : taskDB){
            if(task.getTaskName().contains(taskname)){
                tasks.add(task.getTaskName());
            }
        }

        return tasks;
    }


    public List<String> exactSearchTask(String searchTask){
        List<String> tasks = new ArrayList<>();

        for(Task task : taskDB){
            String[] taskNames =task.getTaskName().split(" ");

            for(String s : taskNames)
            {
                if(s.equals(searchTask)){
                    tasks.add(s);
                }
            }
        }

        return tasks;
    }

}
