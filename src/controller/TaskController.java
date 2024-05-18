package controller;

import dto.Task;
import service.TaskService;

import java.util.Scanner;

public class TaskController {

    private TaskService taskService = new TaskService();
    public void startApp()
    {
        showMenu();
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

    public void performAction(int n)
    {
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
//                listTask();
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
        Scanner scn = new Scanner(System.in);
        int id = scn.nextInt();
        String name = scn.next();
        String Category = scn.next();
        String deadline = scn.next();

        Task task = new Task(id,name,Category,deadline);
        taskService.addTask(task);
    }
}
