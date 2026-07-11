# Online Quiz Application

## Description

The Online Quiz Application is a Java-based application that allows users to create accounts, log in, select courses, answer quiz questions, and view their results. The system uses a MySQL database to store users, courses, questions, and quiz results.

---

## Requirements

Before running the application, install the following:

* Java Development Kit (JDK) 8 or higher
* NetBeans IDE
* MySQL Server or XAMPP (MySQL)
* MySQL JDBC Driver

---

## Database Setup

### 1. Create the Database

Open MySQL Command Line, MySQL Workbench, or phpMyAdmin and run:

```sql
CREATE DATABASE exams;
```

Select the database:

```sql
USE exams;
```

---

# Database Tables

## 1. Users Table

Stores registered user information.

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    gender ENUM('Male','Female','Other') NOT NULL
);
```

### Fields

| Field    | Type         | Description        |
| -------- | ------------ | ------------------ |
| id       | INT          | Unique user ID     |
| fullname | VARCHAR(100) | User full name     |
| email    | VARCHAR(255) | User email address |
| password | VARCHAR(255) | User password      |
| gender   | ENUM         | User gender        |

---

## 2. Courses Table

Stores available quiz courses.

```sql
CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(20) NOT NULL UNIQUE
);
```

### Fields

| Field | Type         | Description |
| ----- | ------------ | ----------- |
| id    | INT          | Course ID   |
| name  | VARCHAR(100) | Course name |
| code  | VARCHAR(20)  | Course code |

---

## 3. Questions Table

Stores multiple-choice questions for each course.

```sql
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    question TEXT NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL,

    FOREIGN KEY(course_id) REFERENCES courses(id)
);
```

### Fields

| Field          | Type         | Description       |
| -------------- | ------------ | ----------------- |
| id             | INT          | Question ID       |
| course_id      | INT          | Related course ID |
| question       | TEXT         | Quiz question     |
| option1        | VARCHAR(255) | First option      |
| option2        | VARCHAR(255) | Second option     |
| option3        | VARCHAR(255) | Third option      |
| option4        | VARCHAR(255) | Fourth option     |
| correct_answer | VARCHAR(255) | Correct answer    |

---

## 4. Results Table

Stores users' quiz scores.

```sql
CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    courseId INT NOT NULL,
    score INT NOT NULL,
    total INT NOT NULL,
    percentage DECIMAL(5,2) NOT NULL,

    FOREIGN KEY(userId) REFERENCES users(id),
    FOREIGN KEY(courseId) REFERENCES courses(id)
);
```

### Fields

| Field      | Type    | Description               |
| ---------- | ------- | ------------------------- |
| id         | INT     | Result ID                 |
| userId     | INT     | User who took the quiz    |
| courseId   | INT     | Course completed          |
| score      | INT     | Number of correct answers |
| total      | INT     | Total questions           |
| percentage | DECIMAL | Final percentage score    |

---

# Database Connection Setup

Update your database connection class with your MySQL credentials.

Example:

```java
String url = "jdbc:mysql://localhost:3306/onlinequiz";
String username = "root";
String password = "";
```

If using XAMPP:

* Start **Apache**
* Start **MySQL**
* Default username: `root`
* Default password: empty

---

# Running the Application

1. Clone the repository:

```bash
git clone https://github.com/PINKYTTUD/onlineQuiz.git
```

2. Open the project in NetBeans.

3. Add the MySQL JDBC Driver:

   * Right-click project
   * Select **Properties**
   * Select **Libraries**
   * Add MySQL Connector/J

4. Create the database:

```sql
CREATE DATABASE onlinequiz;
```

5. Run all table creation scripts.

6. Update database credentials in the connection class.

7. Run the project from NetBeans.

---

# Project Features

* User registration
* User login
* Course selection
* Multiple-choice quizzes
* Automatic score calculation
* Percentage calculation
* Result storage

---

# Database Relationship

```
Users
  |
  | 1-to-many
  |
Results
  |
  | many-to-1
  |
Courses
  |
  | 1-to-many
  |
Questions
```

---

# Author

Yaw Amponsah Kankam
