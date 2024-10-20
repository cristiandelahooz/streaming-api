# 🎬 Streaming API

Welcome to the **Streaming API** project! This API is designed to simulate a streaming application, leveraging the power of **Spring Boot** and **Spring Data JPA**. The application will connect to a **SQL Server** database to manage and serve data, making it a robust and scalable solution for streaming platforms.

## 🌟 Features

- **Spring Boot** for creating a robust and scalable backend.
- **Spring Data JPA** for seamless interaction with the SQL Server database.
- **SQL Server** as the relational database management system.
- RESTful API endpoints to manage streaming content, users, and other related entities.

## 🛠️ Technologies Used

- **Java**: The core programming language for building the API.
- **Spring Boot**: A powerful framework to develop production-ready applications.
- **Spring Data JPA**: Simplifies the data access layer and interaction with SQL Server.
- **SQL Server**: Database to store and manage application data.
- **Maven**: Dependency management and project build tool.

## 🚀 Getting Started

### Prerequisites

- **Java 17+** installed on your machine.
- **Maven 3.6+** for building the project.
- **SQL Server** installed and running.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/SaratrasV/streaming-api.git
    ```

2. Navigate to the project directory:

    ```bash
    cd streaming-api
    ```

3. Configure the database connection in `application.properties`:

    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=streamingdb
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Build the project:

    ```bash
    mvn clean install
    ```

5. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## 🧩 API Endpoints

### Users

- **GET /users**: Retrieve a list of all users.
- **POST /users**: Create a new user.
- **GET /users/{id}**: Retrieve details of a specific user.
- **PUT /users/{id}**: Update a user's information.
- **DELETE /users/{id}**: Remove a user from the database.

### Streaming Content

- **GET /content**: Retrieve all streaming content.
- **POST /content**: Add new content to the streaming library.
- **GET /content/{id}**: Get details of a specific content item.
- **PUT /content/{id}**: Update content information.
- **DELETE /content/{id}**: Remove content from the library.

## 📝 To-Do List

- [ ] Implement authentication and authorization.
- [ ] Add user profiles and preferences.
- [ ] Integrate video streaming capabilities.
- [ ] Set up CI/CD pipeline for automated deployments.

## 👨‍💻 Author

- **Cristian de la Hoz** - [GitHub](https://github.com/SaratrasV)

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

---

Crafted with ❤️ by [Cristian de la Hoz]
