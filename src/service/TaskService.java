package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import dao.TaskRepo;
import dto.Task;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.util.List;

public class TaskService {

    private final TaskRepo taskrepo = new TaskRepo();

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

    public Task getTask(int id) {

        return taskrepo.getTask(id);
    }

    public List<String> exactSearchTask(String taskname){
        return taskrepo.exactSearchTask(taskname);
    }
    public List<String> fuzzySearchTask(String taskname){
        return taskrepo.fuzzySearchTask(taskname);
    }

    public void convertToJson() {

        List<Task> taskDB = taskrepo.listTask();
        ObjectMapper obj = new ObjectMapper();
        try {
            obj.writeValue(new File("myTask.json"), taskDB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void JsonToObject() {

        ObjectMapper obj = new ObjectMapper();
            try {
                List<Task> taskDB = obj.readValue(new File("myTask.json"), new TypeReference<List<Task>>(){});
                taskrepo.setTask(taskDB);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


    }
}