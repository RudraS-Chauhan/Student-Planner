# Student Planner (Mini Project)

A simple **command-line Task Manager / Student Planner** built in **Java**.  
This project allows students to organize their daily tasks, save them in a file, and load them on the next run.

---

## ✨ Features
- ➕ Add tasks with **title, category, and deadline**  
- 📋 Display all tasks  
- ✅ Mark tasks as done  
- ❌ Delete tasks  
- 💾 Save tasks to a file (`Records.txt`)  
- 📂 Load tasks automatically on startup  
- ⏳ Display pending tasks only (extension idea)

---

## 🏗️ Project Structure
├── Main.java # Entry point, handles menu & user input
├── Task.java # Task model (title, category, deadline, status)
├── TaskManager.java # Core logic: add, delete, save/load tasks
└── Records.txt # File used for storing tasks (auto-created)

EXAMPLE:

1. Add Task
2. Display All Tasks
3. Mark Task as Done
4. Delete Task
5. Display Pending Tasks
6. Exit
Choose an option: 1
Enter Task Title: Complete Assignment
Enter Category: Work
Enter Due Date (YYYY-MM-DD): 2025-10-01
Task Added Successfully!
