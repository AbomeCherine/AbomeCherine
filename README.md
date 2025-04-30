Advanced Java OOP System Designs
This repository contains three advanced Java Object-Oriented Programming (OOP) system designs:

Advanced Stock Management System

Advanced Online Shopping System

Advanced Motor Vehicle Insurance System

Each system demonstrates core OOP principles including abstraction, encapsulation, inheritance, and polymorphism, along with proper validation and reporting mechanisms.

Table of Contents
Features

System Designs

1. Stock Management System

2. Online Shopping System

3. Motor Vehicle Insurance System

Technologies

Setup

Usage

Validation Rules

Report Generation

Contributing

License

Features
Abstraction: Abstract base classes for each system

Encapsulation: Proper data hiding with getters/setters

Inheritance: Specialized concrete classes extending base classes

Polymorphism: Overridden methods in child classes

Validation: Comprehensive input validation

Reporting: Detailed system reports

User Interaction: Scanner-based console interface

System Designs
1. Stock Management System
Manages product inventory with specialized stock items:

StockItem (Abstract)
├── ElectronicsItem
├── ClothingItem
├── GroceryItem
├── FurnitureItem
└── PerishableItem

Encapsulated Classes:
- Product
- Supplier
- Warehouse
2. Online Shopping System
Simulates e-commerce functionality:

ShoppingItem (Abstract)
├── ElectronicsItem
├── ClothingItem
├── GroceriesItem
├── BooksItem
└── AccessoriesItem

Encapsulated Classes:
- Customer
- ShoppingCart
- Payment
3. Motor Vehicle Insurance System
Handles insurance policies and claims:

InsurancePolicy (Abstract)
├── ComprehensivePolicy
├── ThirdPartyPolicy
├── CollisionPolicy
├── LiabilityPolicy
└── RoadsideAssistancePolicy

Encapsulated Classes:
- Vehicle
- Person
- Claim
Technologies
Java 11+

Java Scanner for user input

Object-Oriented Programming principles

Date/Time API for insurance system

Console-based interface

Setup
Clone the repository:

bash
git clone https://github.com/AbomeCherine/advanced-java-oop-systems.git
cd advanced-java-oop-systems
Compile and run any system:

bash
javac StockManagementSystem.java
java StockManagementSystem
Usage
Each system provides a console menu to:

Add/update items

Process transactions

Generate reports

Validate inputs

Example workflow for Stock Management:

Add products

Update stock quantities

Apply discounts

Generate inventory report

Check for expired items

Validation Rules
Common validations across all systems:

Negative values prevented

Unique identifiers enforced

Range checks (discounts, quantities)

Format validation (emails, dates)

Business logic validation

Report Generation
Each system generates comprehensive reports including:

Inventory/sales summaries

Financial calculations

Status updates

Expiration/alert notifications

Transaction histories

Contributing
Contributions welcome! 
