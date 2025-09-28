import java.io.*;
import java.util.*;
public class TaskManager
{

    Task[] tasks = new Task[100];
    int count = 0;
    
    void addtask(String title, String category, String deadline)
    {
        Task t = new Task(title, category, deadline, count + 1);
        tasks[count] = t;
        count++;
    }

    void displayalltasks()
    {
        if(count == 0)
        {
            System.out.println("No tasks available.");
            return;
        }
        
        else
        {
            for(int i = 0; i < count; i++)
            {
                tasks[i].displaytask();
            }
        }
    }

    void marktaskdone(int id)
    {
        for(int i = 0; i < count; i++)
        {
            if(tasks[i].id == id)
            {
                tasks[i].isdone = true;
                break;
            }
        }
    }
    void deletetask(int id)
    {
        for(int i = 0; i < count; i++)
        {
            if(tasks[i].id == id)
            {
                for(int j = i; j < count - 1; j++)
                {
                    tasks[j] = tasks[j + 1];
                }
                tasks[count - 1] = null;
                count--;
                break;
            }
        }
    }

    void loadTasksFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                return; // no file, nothing to load
            }

            Scanner sc = new Scanner(f);
            count = 0;  // reset before loading

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String category = parts[2];
                    String deadline = parts[3];
                    boolean isdone = parts[4].equals("1");

                    Task t = new Task(title, category, deadline, id);
                    t.isdone = isdone;
                    tasks[count] = t;
                    count++;
                }
            }

            sc.close();
            System.out.println("Tasks loaded from " + filename);

        } catch (Exception e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    void saveTasksToFile(String filename) {
        PrintWriter fw = null;
        try {
            fw = new PrintWriter(filename);
        }
        catch (Exception e) {
            System.out.println("Error opening file for writing: " + e.getMessage());
            return;
        }
        for(int i = 0;i<count;i++)
        {
            Task t = tasks[i];
            int isdone = t.isdone ? 1 : 0;
            fw.println(t.id + "," + t.title + "," + t.category + "," + t.deadline + "," + isdone);

        }
        fw.close();
        System.out.println("Tasks saved to " + filename);
    }


}