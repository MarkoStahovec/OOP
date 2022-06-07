### Short important information:	

- Name: **Marko Stahovec**
- Admin password: **admin**

This small application resembles a simulation for luxury cars store. It is build upon Swing libraries providing elemental GUI functionalities.
The exercises are present within the src folder, so there is only one java project for all the files.

## Environment
- Intellij IDEA Ultimate 2021, compatible with Eclipse IDE


- JDK 8 
- Java Swing Libraries
- javax.swing, java.awt, java.io, java.util, java.imageio

## Certain implementations

### Inheritance:

As you can see on the diagram below, the inheritance is present when segregating class **Car** and class **Motorcycle** from their superclass called **Vehicle**. They **inherit** all the attributes that class Vehicle possesses.

### Polymorphism:

In this project, polymorphism was applied when **constructing** cars, since all the cars in the program were constructed using class Car, but their branding and parameters were all **different**.

### Aggregation:

Aggregation was applied directly with classes **LuxuryCarsManager**, **Motorcycle** and **Car**, because both Motorcycle and Car have unidirectional association with LuxuryCarsManager, while being able to exist individually.

### Encapsulation:

Encapsulation mechanism was used for example on a class **Car**, since its parameters were declared **private** and in the program they are being accessed by special **get** and **set** methods.

### DataAccessObject design pattern:

DataAccessObject was used as a separate class and interface as a **mechanism to access and delete data** from current database. Their dependencies are shown in the diagram below.

### Observer design pattern:

Observer design pattern was indirectly used when creating ActionListeners for specific buttons using method **addActionListener** with lambda expression, such as:

![Observer](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/code_snippets/observer.png)

### Custom exceptions:

There are 2 custom exceptions in this application:

1. **MissingDataException:** is thrown when manipulating incorrect vehicle object
![MissingDataException](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/code_snippets/exc1.png)

2. **IncorrectInputException:** is thrown when entering a wrongful input
![IncorrectInputException](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/code_snippets/exc2.png)

### Custom handlers:

Every event that occurs in this application is handled manually using **custom** listeners, as can be seen on **Observer design pattern**, where is an example handler for deletion button.

### Multi-threading:

Multithreading feature was implemented within the **request section** of the application, where if user requests a vehicle, the application remains **fully functional**, while another thread prepares the requested vehicle.

![Multi-threading](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/code_snippets/%C2%B4multithreading.png)

### Serialization:

Serialization mechanism is part of a **menubar** on top-left part of the application, where **load** and **save** items are present to ensure simplistic yet effective state **persistence**.



## Installation
- Make sure Java 1.8 is installed.

## Version changes
Version 1.0.6 - Motorcycle request

Version 1.0.5 - Icons for main menu

Version 1.0.4 - DataAccessObject design pattern

Version 1.0.3 - Project restructure, icon fixing and database

Version 1.0.2 - Added serialization

Version 1.0.1 - Added multi-threading using lambda expression

Version 1.0.0 - First commit, main classes and first GUI draft


## List of features:
- Serialization
- Multi-level Access Privilege
- Simplistic UI with illustrative icons
- Multi-threading
- CSV Database

## Project Skeleton
UML Class Diagram:

![UML Diagram](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/uml_diagram.png)

Intellij Generated Diagram:
![Intellij Diagram](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/generated_diagram.png)

Brief demonstration of functionality - Prototypes:
![Prototype](https://github.com/OOP-FIIT/oop-2021-uto-18-a-dakic-MarkoStahovec/blob/master/Documentation/code_snippets/prototype.png)
