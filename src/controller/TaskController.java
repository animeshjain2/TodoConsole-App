package controller;

import service.TaskService;
import dto.Task;
import dto.Status;
import dto.Category;
import validator.TaskDate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class TaskController {

    private final TaskService taskService = new TaskService();
    public void startApp()
    {
        taskService.JsonToObject();
        while (true)
        {
            showMenu();
            String inputTask = getUserInput("Action you want to perform: ");
            performAction(inputTask);
        }
    }
    public void showMenu()
    {
        System.out.println("welcome to the to do app");
        System.out.println("1. Add a Task");
        System.out.println("2. Update a Task");
        System.out.println("3. Delete a Task");
        System.out.println("4. List all Task");
        System.out.println("5. Exact Task Search");
        System.out.println("6. Fuzzy Task Search");
        System.out.println("7. Exit the App");

    }

    public String getUserInput(String inputMessage)
    {
        System.out.print(inputMessage);
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public void performAction(String s) {
        int n; // meaning name of variables

        try {
            n = Integer.parseInt(s);
        } catch (Exception e)
        {
            System.out.println("Enter the valid number");
            return;
        }

        switch (n){
            case 1: {
                addTask();
                break;
            }
            case 2: {
                updateTask();
                break;
            }
            case 3:{
                deleteTask();
                break;
            }
            case 4:{
                listTask();
                break;
            }
            case 5:{
                exactSearchTask();
                break;
            }
            case 6: {
                fuzzySearchTask();
                break;
            }
            case 7:{
                convertToJson();
                System.exit(200);
            }
            default:
                System.out.println("Invalid Action");
        }
    }

    public void addTask()
    {
        String name = getUserInput("Task Name : ");
        while(name.isEmpty())
        {
            System.out.println("Name is required to enter");
            name = getUserInput("Enter valid task Name : ");
        }

        String deadline = getUserInput("Enter the date : ");

        Task task = new Task(Task.getTaskAutoId(),name,Category.PERSONAL,deadline,Status.Pending);
        taskService.addTask(task);
    }

    public void deleteTask(){

        String id = getUserInput("Enter TaskId: ");
        boolean isDeleted = taskService.removeTask(Integer.parseInt(id));

        if (!isDeleted) {
            System.out.println("Invalid Task ID");
        } else {
            System.out.println("Task is deleted successfully");
        }
    }

    public void updateTask() {

        try{
            String id = getUserInput("Enter the Id of the task for update: ");
            Task task = getTask(Integer.parseInt(id));

            String fieldname = getUserInput("Enter field name you want to update: ");
            List<String> fields = Arrays.asList("Name", "Status", "Deadline");

            while(!fields.contains(fieldname))
            {
                System.out.println("Enter valid field name from"+ fields);
                fieldname = getUserInput("Enter field name you want to update: ");
            }

            switch (fieldname) {
                case "Name" -> task.setTaskName(getUserInput("Name: "));
                case "Status" -> task.setTaskStatus(Status.valueOf(getUserInput("Status: ")));
                case "Deadline" -> task.setTaskDeadline(getUserInput("Deadline: "));
            }

        } catch (Exception e){
            System.out.println("Task not found");
        }

    }
    public void listTask(){
        List<Task> tasks = taskService.listTask();
        System.out.println(tasks);
    }

    public Task getTask(int id) throws Exception {
        return taskService.getTask(id);
    }

    public void exactSearchTask(){
        String task = getUserInput("Enter the task name: ");
        List<String> tasks = taskService.exactSearchTask(task);
        System.out.println(tasks);

    }

    public void fuzzySearchTask(){
        String task = getUserInput("Enter the task name: ");
        List<String> tasks = taskService.fuzzySearchTask(task);
        System.out.println(tasks);
    }

    public void convertToJson() {
         taskService.convertToJson();
    }


}

// TODO - Name empty is not allowed -- done
// Deadline optional -- done
// Update ask user for field want to update
