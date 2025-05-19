# 📝 NoteNest - A Simple Note Taking Web Application

NoteNest is a lightweight web-based application that allows users to securely sign up, log in, and manage personal notes. It's built using **Spring Boot (Java)** for the backend and **HTML, CSS, Bootstrap, and JavaScript** for the frontend—all integrated in a single-page frontend (`index.html`).

---

## 🚀 Features

- ✅ User Signup and Login  
- 🔐 Basic token-based authentication (simulated using localStorage)  
- 🗒️ Create and View Notes  
- 📆 Timestamp for each note  
- 📦 Clean and responsive Bootstrap UI  

---

## 🛠️ Tech Stack

**Frontend:**  
- HTML5  
- CSS3  
- Bootstrap 5  
- JavaScript (Vanilla)  

**Backend:**  
- Java  
- Spring Boot  
- RESTful APIs  

**Database:**  
- MySQL  

---

## 📂 Project Structure

```
/NoteNest
│
├── src/
│   └── main/
│       ├── java/com/notenest/
│       │   ├── controller/
│       │   │   └── InfoCnt.java
│       │   ├── entity/
│       │   │   ├── Info.java
│       │   │   └── User.java
│       │   ├── repository/
│       │   │   ├── InfoRepo.java
│       │   │   └── UserRepo.java
│       │   └── NoteNestApplication.java
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
│
├── pom.xml
└── README.md
```

---

## ⚙️ Setup Instructions

1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/notenest.git
cd notenest
```

2. **Configure the `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notenest_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8081
```

3. **Start MySQL and create the database**
```sql
CREATE DATABASE notenest_db;
```

4. **Run the Spring Boot App**
```bash
./mvnw spring-boot:run
```

5. **Access the Web App**

Visit:  
[http://localhost:8081/index.html](http://localhost:8081/index.html)

---

## 📬 API Endpoints

| Endpoint           | Method | Description            |
|-------------------|--------|------------------------|
| `/api/signup`     | POST   | Register a new user    |
| `/api/login`      | POST   | Authenticate user      |
| `/InfoCnt/create` | POST   | Create a new note      |
| `/InfoCnt/getall` | GET    | Fetch all user notes   |

> ⚠️ Note: Authentication is simulated via `localStorage` token. For production, consider using JWT or Spring Security.

---

## 🧑‍💻 Author

**Hritik Raj**  
[LinkedIn]([https://www.linkedin.com/in/your-profile](https://www.linkedin.com/in/hritik-raj-b68163210/))  
📧 Email: hritikraj723@gmail.com

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
