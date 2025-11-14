# Student Library Management System

A comprehensive Spring Boot application for managing library operations in educational institutions. This system provides RESTful APIs for managing students, books, library cards, and transactions.

## Key Features

### Book Management
- Add new books to the library
- Search books by ID or title
- Update book details
- Delete books from the system
- List all available books

### Student Management
- Register new students
- View student details by ID
- Update student information
- Delete student records
- List all registered students

### Library Card System
- Generate library cards for students
- Track card status (Active/Deactivated/Blocked)
- View card details and associated student
- Check number of books issued on a card

### Transaction Management
- Issue books to students
- Return books
- Track due dates and fines
- View transaction history
- Filter transactions by type (ISSUE/RETURN)

### Additional Features
- RESTful API endpoints for all operations
- Input validation and error handling
- MySQL database integration
- Clean and maintainable code structure

## Technology Stack
- **Backend**: Spring Boot
- **Database**: MySQL
- **API Documentation**: Swagger/OpenAPI (if implemented)
- **Build Tool**: Maven

## Getting Started

### Prerequisites
- Java 11 or higher
- MySQL Server
- Maven

### Installation
1. Clone the repository
2. Configure database properties in `application.properties`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## API Documentation
API endpoints are available at `http://localhost:8080/swagger-ui.html` (if Swagger is configured)

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
