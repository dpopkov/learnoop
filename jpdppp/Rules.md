Rules of Program Design
=======================


1 - Modular Software Design
---------------------------

### The Fundamental Principle of Software Design

A program should be designed so hat any change to it will affect only
a small, predictable portion of the code.

### The Single Responsibility Rule

A class should have a single purpose, and all its methods should be
related to that purpose.

### The Rule of Encapsulation

A class's implementation details should be hidden from its clients
as much as possible.

### The Most Qualified Class Rule

Work should be assigned to the class that knows best how to do it.

### The Rule of Low Coupling

Try to minimize the number of class dependencies.


2 - Polymorphism
----------------

### The Rule of Transparency

A client should be able to use an interface without needing to know
the classes that implement that interface.

### The Open/Close Rule

To the extent possible, a program should be open for extension 
but closed for modification.

### The Liskov Substitution Principle

If type X extends type Y then an object of type X can always be used
wherever an object of type Y is expected.

### The Rule of Abstraction

A class's dependencies should be as abstract as possible.


3 - Class Hierarchies
---------------------

### The "Don't Repeat Yourself" Rule

A piece of code should exist in exactly one place.


4 - Strategies
--------------

This chapter uses the Strategy Pattern and the Command Pattern.
