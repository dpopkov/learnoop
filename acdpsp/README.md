# acdpsp - Adaptive Code. Agile Coding with Design Patterns and SOLID Principles

* [Null Object pattern](#nullobject)
* [Adapter pattern](#adapter)
* [Strategy pattern](#strategy)


### Chapter 4 - Interfaces and design patterns

#### [Null Object pattern](src/main/java/learn/oop/acdpsp/ch04interf/nullobj) 
<a name="nullobject"></a>

#### [Adapter pattern](src/main/java/learn/oop/acdpsp/ch04interf/adapter)
<a name="adapter"></a>
  
The Adapter pattern allows you to provide an object instance to a client that has a dependency on an interface
that your instance does not implement. An Adapter class is created that fulfills the expected interface of the client

[Class Adapter pattern](src/main/java/learn/oop/acdpsp/ch04interf/adapter/classadapter)  
[Object Adapter pattern](src/main/java/learn/oop/acdpsp/ch04interf/adapter/objectadapter)


#### [Strategy pattern](src/main/java/learn/oop/acdpsp/ch04interf/strategy)
<a name="strategy"></a>
The Strategy pattern allows you to change the desired behavior of a class based on one or more supplied "strategies".
It is used whenever a class needs th exhibit variant behavior depending on the state of an object, that can change 
at run time. The behavior of the class is hidden behind an interface whose implementations are used to perform
the real work.
