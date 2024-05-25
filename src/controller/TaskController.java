package controller;

import service.TaskService;
import dto.Task;
import dto.Status;
import dto.Category;

import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class TaskController {

    private TaskService taskService = new TaskService();
    public void startApp()
    {
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
        System.out.println("5. Exit the App");


    }

    public String getUserInput(String inputMessage)
    {
        System.out.print(inputMessage);
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        return s;
    }

    public void performAction(String s)
    {
        int n;
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
//                updateTask();
                break;
            }
            case 3:{
//                deleteTask();
                break;
            }
            case 4:{
                listTask();
                break;
            }
            case 5:{
                System.exit(200);
            }
            default:
                System.out.println("Invalid Action");
        }
    }

    public void addTask()
    {

        String name = getUserInput("Task Name :");
        String deadline = getUserInput("Enter the date in DD-MM-YYYY format");

        Task task = new Task(Task.getTaskAutoId(),name,Category.PERSONAL,deadline,Status.Pending);
        taskService.addTask(task);
    }

    public void listTask(){
        List<Task> tasks = taskService.listTask();
        System.out.println(tasks);
    }
}
