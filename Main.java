import java.util.*;
import java.io.*;
public class Main extends TaskManager
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        taskManager.loadTasksFromFile("Records.txt");

        while(true)
        {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1 -> {
                    System.out.println("Enter Task Title:");
                    String title = sc.nextLine();

                    System.out.println("Enter Category (1. Work, 2. Personal, 3. Shopping, 4. Others): ");
                    String cChoice = sc.nextLine();

                    System.out.println("Enter Due Date (YYYY-MM-DD): ");
                    String dueDate = sc.next();

                    taskManager.addtask(title, cChoice, dueDate);
                    System.out.println("Task Added Successfully!");
                }

                case 2 -> {
                    if(taskManager.count == 0)
                    {
                        System.out.println("No tasks available.");
                    }
                    else
                    {
                        taskManager.displayalltasks();
                    }
                }
                    
                case 3 -> {
                    System.out.println("Enter Task ID to mark as done:");
                    int doneId = sc.nextInt();
                    sc.nextLine();

                    taskManager.marktaskdone(doneId);
                    System.out.println("Task marked as done.");
                }

                case 4 -> {
                    System.out.println("Enter Task ID to delete:");
                    int delId = sc.nextInt();
                    sc.nextLine();

                    taskManager.deletetask(delId);
                    System.out.println("Task deleted successfully.");
                }

                case 5 -> {
                    System.out.println("Exiting...");   
                    taskManager.saveTasksToFile("Records.txt");     // save before quitting
                    System.out.println("Goodbye!");

                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    static void showMenu() 
    {
        System.out.println("1. Add Task");
        System.out.println("2. Display All Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }  
}