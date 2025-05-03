# Requirements

Develop a simplified Ticket Management System similar to Jira that allows users to manage various types of tickets such as stories, epics, and on-call tasks. Implement functionalities to create, update, and manage these tickets, including sprint management for stories.  Write modular and clean code in java. Use SOLID principles and OOPs features in your code. 
Requirements:

1. Ticket Types:
    * Implement three types of tickets: Story, Epic, and On-call.
    * Each ticket type should have a unique flow of statuses.
2. Ticket Flows:
    * Story: Open -> In Progress -> Testing -> In Review -> Deployed
    * Epic: Open -> In Progress -> Completed
    * On-call: Open -> In Progress -> Resolved
3. Sprint Management:
    * Only tickets of type Story can be part of a sprint.
    * Users should be able to add and remove stories from a sprint.
    * Maintain a list of stories in the current sprint.
4. Sub-tasks:
    * Each ticket can have multiple sub-tasks associated with it.
    * Sub-tasks should have the same status flow as their parent ticket.
    * Users should be able to create, update, and delete sub-tasks.
    * Story should not be closed if the sub tasks are not marked complete.
5. Functional Requirements:
    * Create Ticket: Allow users to create tickets of any type.
    * Update Ticket Status: Allow users to update the status of any ticket.
    * Sprint Management: Allow users to add/remove stories from the current sprint.
    * Sub-task Management: Allow users to add/remove sub-tasks for any ticket.
6. Data Storage:
    * Use an in-memory data structure to store tickets, sub-tasks, and sprint information.
    * Ensure the data structure supports efficient lookup and modification.


Example Scenario:
1. Create Tickets:
    * User creates a Story ticket with the title "Implement login feature".
    * User creates an Epic ticket with the title "User authentication".
    * User creates an On-call ticket with the title "Fix production bug".
2. Update Ticket Status:
    * User updates the status of "Implement login feature" from Open to In Progress.
3. Sprint Management:
    * User adds "Implement login feature" to the current sprint.
    * User removes "Implement login feature" from the current sprint.
4. Sub-task Management:
    * User creates a sub-task for "Implement login feature" with the title "Design login UI".
    * User updates the status of "Design login UI" from Open to In Progress.
    * User deletes the sub-task "Design login UI". 

Implement the above example scenarios in the main/driver class. 

 Note :    * Subtask will exist independently and does not depend on the sprint 
 * Have a validation that if a subtask is not closed, a story cannot be closed 
* A ticket is not allowed to delete, it only can be transitioned from one status to other.
 Create Data repository classes to store data
A driver program/main class/test case is needed to test out the code by the evaluator with multiple test cases. But do not spend too much time in the input parsing. Keep it as simple as possible.






# 🛠️ Simplified Ticket Management System (Jira-like)

A lightweight Java-based Ticket Management System inspired by Jira, supporting management of Stories, Epics, On-call tasks, Sub-tasks, and Sprint planning. Built with clean architecture principles using **OOP** and **SOLID** design principles.

---

## 🚀 Features

### ✅ Ticket Types
Supports three core ticket types:
- **Story**
- **Epic**
- **On-call**

Each ticket type follows a unique status flow:

| Ticket Type | Allowed Status Flow |
|-------------|----------------------|
| **Story**   | Open → In Progress → Testing → In Review → Deployed |
| **Epic**    | Open → In Progress → Completed |
| **On-call** | Open → In Progress → Resolved |

---

### 🔁 Ticket Management
- Create, manage, and track ticket status transitions.
- Sub-tasks can be added to any ticket and follow the same status flow as the parent.
- Tickets **cannot be deleted**, only transitioned across allowed statuses.

---

### 📅 Sprint Management
- Only **Story** tickets are allowed in the current sprint.
- Add or remove stories from a sprint.
- Maintains an in-memory list of stories in the sprint.

---

### 🧩 Sub-task Management
- Create, update, and delete sub-tasks.
- Each sub-task must follow the parent ticket's status flow.
- **Validation**: A Story cannot be marked as "Deployed" if any of its sub-tasks are incomplete.

---

## 📦 In-Memory Storage
- All data (tickets, subtasks, sprint details) is stored using efficient in-memory data structures.
- Fast access and modification without external databases.

---

## 📌 Example Scenario (Implemented in Main Class)

1. **Ticket Creation**
    - Story: `"Implement login feature"`
    - Epic: `"User authentication"`
    - On-call: `"Fix production bug"`

2. **Update Ticket Status**
    - `"Implement login feature"`: Open → In Progress

3. **Sprint Management**
    - Add `"Implement login feature"` to current sprint
    - Remove it from the sprint

4. **Sub-task Management**
    - Create sub-task: `"Design login UI"` under `"Implement login feature"`
    - Update sub-task to In Progress
    - Delete the sub-task

---

## 📂 Project Structure

src/
│
├── model/
│ ├── Ticket.java
│ ├── Story.java
│ ├── Epic.java
│ ├── OnCall.java
│ ├── SubTask.java
│ └── TicketStatus.java
│
├── repository/
│ ├── TicketRepository.java
│ └── SprintRepository.java
│
├── service/
│ ├── TicketService.java
│ ├── SprintService.java
│ └── SubTaskService.java
│
└── main/
└── Main.java




---

## 🧪 How to Run

1. Clone or download the repository.
2. Open the project in your favorite Java IDE (e.g., IntelliJ, Eclipse).
3. Compile and run the `Main.java` file to test the full example flow.

---

## 📌 Design Principles

- ✅ **S**ingle Responsibility Principle
- ✅ **O**pen/Closed Principle
- ✅ **L**iskov Substitution Principle
- ✅ **I**nterface Segregation Principle
- ✅ **D**ependency Inversion Principle
- ✅ **OOP Features**: Encapsulation, Inheritance, Polymorphism, Abstraction

---

## 🔒 Notes

- Sub-tasks are not bound to sprint participation.
- Tickets are immutable (no delete operation).
- Story status cannot transition to `Deployed` unless all sub-tasks are complete.

---

## 👨‍💻 Author

Developed as part of a system design practice exercise for simplified ticket management workflows.

---
