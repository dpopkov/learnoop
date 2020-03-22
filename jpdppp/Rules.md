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


5 - Encapsulating Object Creation
---------------------------------

This chapter uses _object caching_ and _factories_.

Caching reuses objects, thereby reducing the need for constructors.
Immutable objects are good candidates for caching. If a class only needs
a fixed number of immutable objects, then it can create and cache those
objects when it is loaded. Such classes are called _singletons_. The Java 
enum syntax is the preferred way to define singleton classes.

A _factory_ is a class that encapsulates constructor usage. When a class 
needs to create an object, it calls a method from the appropriate factory
class.


6 - Iterables and Iteration
---------------------------

This chapter uses external and internal iteration, the Visitor Pattern.

An _iterator_ generates a sequence of elements. It has the two methods _next_
and _hasNext_. An _iterable_ is an object that has an associated iterator.
Collections are the most common examples iterables.

The __iterator pattern_ organizes the iterable and iterator classes into 
separate, parallel hierarchies, with each iterable class having a corresponding
iterator class.


7 - Adapters
------------

8 - Decorators
--------------

This chapter examines several useful applications of decorators.

The decorator pattern asserts that the decorations for an interface form a hierarchy.
The root of the hierarchy is an abstract wrapper class that holds a reference to 
its wrapped class and provides default implementations of the interface methods.
The decorator classes are the subclasses of the wrapper class. 
The non-decorator classes of the interface are called its _base classes_.

A decorator class, like an adapter, can be thought of as transforming
an input object into an output object. The difference is that the output
of a decorator has the same type as its input. This feature means that
decorators can be composed.

The __chain of command pattern__ is a special case of the decorator pattern
where the decorators perform tasks instead of calculating values. Each decorator
understands some part of the task. A request to perform the task is sent to
the first decorator in the chain and is passed down the chain until it encounters
a decorator that can perform that task.


9 - Composites
--------------

A _composite object_ has a hierarchical structure. Each object in the hierarchy implements the same interface,
called the _composite interface_.
The _composite pattern_ describes the preferred way to organize the classes of a composite object.
These classes form two categories: _base classes_, whose objects are the leaves of the composite hierarchy,
and _recursive classes_, whose objects form the interior of the hierarchy.
Each recursive object wraps one or more objects that implement the composite interface.
These wrapped objects are called its _children_.

Syntactically, a composite object is very similar to a decorator object; the only difference is that 
a composite can have multiple children whereas a decorator can have just one.
This difference completely changes their purpose. A decorator is a chain, where the recursive objects 
serve to enhance the methods of the base object at the end of the chain.
A composite is a tree, whose non-root objects combine to execute the methods of the root.
