# Aqua User Guide

Aqua is a task management chatbot that supports a variety of commands for managing todos, deadlines, events, and priorities.  

Note:
- All commands are **case-insensitive**.
- Data are saved locally on every command run, you don't have to worry about losing your data if you exit the program prematurely.

---

## 📋 Command List
### 1. Show all tasks
```
list
```
Displays all tasks currently stored, along with their index and status.


### 2. Add a Todo
```
todo <description>
```
Adds a new todo task.
#### Example:
```
todo Buy groceries
```

### 3. Add a Deadline
```
deadline <description> /by <date>
```
Adds a deadline task with a due date.
#### Example:
```
deadline Submit assignment /by 20092025
```

### 4. Add a Event
```
event <description> /from <date> /to <date>
```
Adds an event task with a start and end date/time.
#### Example:
```
event Project meeting /from 20092025 14:00 /to 20092025 16:00
```

### 5. Mark a Task as Done
```
mark <index>
```
Marks the task at the given index as done.
#### Example:
```
mark 2
```

### 6. Unmark a Task
```
unmark <index>
```
Marks the task at the given index as not done.
#### Example:
```
unmark 2
```

### 7. Set Task Priority
```
priority <index> <priority>
```
Sets a priority level for a task.

**Priority levels:**
- `0` → Low
- `1` → Medium
- `2` → High
#### Example:
```
priority 3 2
```
##### or:
```
priority 3 high
```

### 8. Delete a Task
```
delete <index>
```
Removes the task at the given index.
#### Example:
```
delete 4
```

### 9. Find Tasks
```
find <keyword>
```
Searches for tasks containing the keyword.
#### Example:
```
find project
```

### 10. Exit the Program
```
bye
```
Exits Aqua.

## 📅 Supported Date Formats

Aqua accepts the following date formats for **deadline** and **event** commands:

- `ddMMyyyy`
- `ddMMyyyy HH:mm`
- `ddMMyyyy HHmm`
- `dd-MM-yyyy HHmm`
- `dd-MM-yyyy HH:mm`
- `dd-MM-yyyy`
- `dd-MM-yyyy HHmm`
- `dd-MM-yyyy HH:mm`
- `dd/MM/yyyy`
- `yyyy-MM-dd`
- `yyyy-MM-dd HH:mm`
- `yyyy-MM-dd'T'HH:mm`
- `yyyy-MM-dd'T'HH:mm:ss`