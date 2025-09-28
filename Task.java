public class Task
{
    String title, category,deadline;
    int id;
    boolean isdone;

    Task(String title, String category, String deadline,int id)
    {
        this.title = title;
        this.category = category;
        this.deadline = deadline;
        this.id = id;
        this.isdone = false;

    }
    void displaytask()
    {
        System.out.println("Title : " + title);
        System.out.println("Category : " + category);
        System.out.println("Deadline : " + deadline);
        System.out.println("ID : " + id);
        System.out.println("Status : " + (isdone ? "Done" : "Not Done"));
        System.out.println("-------------------------");
    }

    void markDone()
    {
        isdone = true;
    }
}