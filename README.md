Employee Management System
This is a web application built with Spring Boot that allows for managing employee records. It provides functionalities for adding, searching, viewing, editing, and deleting employee details, along with a basic login mechanism.

---> Features
The application implements the following key features:

User Authentication:

A dedicated login page for user authentication.

Basic in-memory user validation (username: user, password: password).

Redirection to the employee search page upon successful login.

Employee Addition:

Form for creating new employee records.

Auto-generated Employee ID: Formatted as EMPXXXXX (e.g., EMP00001), ensuring uniqueness.

Auto-generated Login ID: Derived from the first character of the first name and the last name (e.g., jsmith). If a combination already exists, a 3-digit random number is appended (e.g., jsmith123).

Date of Birth: Input in DD-Mon-YYYY format with server-side validation to ensure the employee is at least 18 years old.

Department Dropdown: Selection from predefined departments: Engineering, Support, HR, Finance.

ID Proof Upload: Allows uploading PDF files only, with size validation between 10KB and 1MB. Files are stored on the server's file system.

-----> Employee Search & Listing:

A dedicated search page with multiple filter criteria:

Employee ID (partial match)

First Name (partial, case-insensitive match)

Last Name (partial, case-insensitive match)

Login ID (partial, case-insensitive match)

Date of Birth (range search: From and To dates)

Department 




---->Employee Details & Actions:

View Link: Each employee record in the list/search results has a "View" link to display all captured data fields on a dedicated details page.

Edit Functionality: An "Edit" link/button enables modification of existing employee details, including replacing the uploaded ID proof document.

Delete Functionality: "Delete" buttons are available for individual record deletion (with confirmation).

History (Placeholder): A "History" link is present as a placeholder, indicating a potential future feature for auditing changes (not currently implemented).

---->Technologies Used
Spring Boot: Framework for building robust, stand-alone, production-grade Spring applications.

Spring Data JPA: Simplifies data access using JPA and provides powerful repository abstractions.

Hibernate: JPA implementation for ORM.

MySQL: Relational database for storing employee data.

Thymeleaf: Server-side templating engine for rendering dynamic HTML pages.

Spring Security: Provides authentication and authorization capabilities.

Jakarta Bean Validation (JSR 303): For server-side form validation.

Apache Commons Lang3 / Spring StringUtils: For utility string operations.

Bootstrap 4: Frontend framework for responsive and modern UI design.
