# Ticket Machine System

## Overview
The Ticket Machine System is a Java-based application developed to demonstrate key Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, and encapsulation. This system allows for the creation and management of different types of tickets, each with its own pricing and characteristics.

## Features
- **Inheritance:** Different types of tickets inherit from a base `Ticket` class, allowing for easy extension and maintenance.
- **Polymorphism:** The system uses polymorphism to handle various ticket types through a common interface, making the code more flexible and reusable.
- **Encapsulation:** The `Ticket` class uses private fields and public getter and setter methods to protect the internal state of the object.

## Project Structure
The project is structured as follows:
TicketMachineSystem/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── mycompany/
│ │ │ └── ticketmachinesystem/
│ │ │ ├── model/
│ │ │ │ ├── Ticket.java
│ │ │ │ ├── StandardTicket.java
│ │ │ │ └── StudentTicket.java
│ │ │ ├── service/
│ │ │ │ └── TicketPrinter.java
│ │ │ └── main/
│ │ │ └── TicketMachine.java
│ └── test/
│ └── java/
│ └── com/
│ └── mycompany/
│ └── ticketmachinesystem/
│ └── (Your unit test files)
│
├── pom.xml
└── README.md


## Getting Started

### Prerequisites
To run this project, you will need:
- **Java 8 or later**: Make sure JDK 8 is installed.
- **Maven**: The project uses Maven for dependency management and build automation.
- **NetBeans IDE**: This project was developed using Apache NetBeans IDE.

### Running the Application
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/mcneillium/Ticket-Machine-System.git


## Getting Started

### Prerequisites
To run this project, you will need:
- **Java 8 or later**: Make sure JDK 8 is installed.
- **Maven**: The project uses Maven for dependency management and build automation.
- **NetBeans IDE**: This project was developed using Apache NetBeans IDE.

### Running the Application
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/mcneillium/TicketMachineSystem.git

2. Open the Project in NetBeans:

Open NetBeans IDE.
Go to File > Open Project, and select the cloned repository folder.

3. Build the Project:

Right-click on the project in the Projects pane and select Build.

4. Run the Application:

Right-click on the TicketMachine class in the main package and select Run File.
The application will print ticket details to the console.

### Usage
The Ticket Machine System currently supports two types of tickets:

- StandardTicket: A regular ticket with a fixed price.
- StudentTicket: A discounted ticket for students.

You can extend the system by adding more ticket types or enhancing the features.

### Contributing
Contributions are welcome! Feel free to fork this repository and submit a pull request with your improvements.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Contact
If you have any questions or need further assistance, please contact me at paulmcneill1989@hotmail.co.uk.
