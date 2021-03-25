Spring Design Patterns
======================

* [The Patterns of the Spring Framework](#the-patterns-of-the-spring-framework)
* [Inversion of Control (IoC) Pattern](#inversion-of-control-ioc-pattern-1)
* [Creational Patterns in Spring](#creational-patterns-in-spring)
    * [1 - Factory Pattern](#1---factory-pattern)
    * [2 - The Builder Pattern](#2---the-builder-pattern)
    * [3 - The Singleton Pattern](#3---the-singleton-pattern)

The Patterns of the Spring Framework
------------------------------------

### Inversion of Control (IoC) Pattern

* The entire runtime of the framework is based on IoC
* Improves testability, decreases coupling, enforces coding to an interface

### Proxy Pattern

* Since 4.0, involved in every object managed by Spring
* Brings some major caveats to the operation of Spring
* Allows additon of behaviors that we leverage throughout the framework

### Factory Pattern

* IoC container is a factory
* Heavily leveraged in startup and runtime operation of Spring
* First class support for factories in your code

### Singleton and Prototype Patterns

* Most of your objects configured for Spring leverage these two patterns
* Singleton is most popular
* Not a traditional singleton implementation, but works the same

### Template Pattern

* Used widely in remote calls
* JDBC and REST are the most popular situations
* Also implemented by third parties to remove boilerplate 
code for using their tooling

### Model-View-Controller Pattern

* Entire web framework is based on this
* Traditional web pages as well as RESTful services
* Not a classic pattern, but very important in Spring

[Top](#spring-design-patterns)

Inversion of Control (IoC) Pattern
----------------------------------

* Not a Gang of Four design pattern
* Architectural pattern for relegating control of dependencies
to the container instead of the developer
* Often called Dependency Injection, though that is one flavor of IoC

### How Does It Work

* Central container constructs and maintains all object references
* Hands them ot other objects when needed at runtime (or startup)
* Centralized control and management

### IoC in Spring

* Spring manages your dependences
* Objects injected at runtime, not compile time
* An object accepts the dependences for construction instead of you constructing them

### Benefits of IoC

* Reduces noise in your code
* Reduces object coupling
* Reduces the defects that arise from incorrect construction

### Application Context

* Spring: Application Context is the IoC container
* Another pattern in play that we will talk about later with BeanFactory
* Leverages the configuration to create the beans and manage the depencency injections

[Top](#spring-design-patterns)

Creational Patterns in Spring
-----------------------------

### 1 - Factory Pattern

#### Use in Spring
* BeanFactory
* FactoryBean
* Leveraged heavily in the framework

#### Pattern in a Nutshell
* Factory allows construction of similar classes of different
types using a factory method
* Method call creates the object for you and serves it back
* Constructed objects are from classes that share an interface or parent class

#### Why Use This Pattern?
* Allows you to not worry about class construction in more than one place
* Allows you to leverage the interface for repetitive operations
* Lack of construction code cleans up code and also makes copy/paste errors less likely

#### Example of Factory Pattern
* [PetFactory](src/main/java/learn/oop/springdp/springdp/factory/PetFactory.java) used
in [PetController](src/main/java/learn/oop/springdp/springdp/controller/PetController.java)

[Top](#spring-design-patterns)


### 2 - The Builder Pattern

#### Use in Spring
* Used in various places in the framework
* ResultActions is one often used (MockMvc)
* Lombok @Builder annotation: not genuinely Spring, but widely accepted

#### Pattern in a Nutshell
* Each method returns the object reference it's called from
* Build method returns a fully constructed object
* Functionality can be combined into one class

#### Why Use This Pattern?
* Useful when object creation has many parameters
* Becomes increasingly more useful when some or all parameters are optional
* Can make code easier to read because of reduced lines for construction when compared with setters

#### Creation Strategy
* Define base class with all-args-constructor
* Create Builder class with attributes and setters for each argument of base class
* Each setter should return the Builder object
* Create the build method that constructs and returns object of the base class

#### Example of Builder Pattern
* [Contact.Builder](src/main/java/learn/oop/springdp/springdp/builder/Contact.java) used
in [ContactController](src/main/java/learn/oop/springdp/springdp/controller/ContactController.java)

[Top](#spring-design-patterns)


### 3 - The Singleton Pattern

#### Use in Spring
* Every bean by default is a singleton
* Not a classic singleton, but behaves the same
* Beans must be thread-safe

#### Pattern in a Nutshell
* Class stores reference to instance of itself
* Constructor is private
* Static __getInstance()__ method returns reference of self instance, or if not constructed
it constructs in thread-safe manner
* The __new__ command is never called on the class outside of the __getInstance()__ method

#### Why Use This Pattern?
* Expensive object creation
* Control concurrency associated with shared resources
* Storing static state for multiple parts of the application

#### Creation Strategy
* Private constructor
* static instance
* static getInstance() method with synchronized block on class itself (double check)

#### Example of Singleton Pattern
* [SingletonTraditional](src/main/java/learn/oop/springdp/springdp/singleton/SingletonTraditional.java)
* [SingletonAsSpringBean](src/main/java/learn/oop/springdp/springdp/singleton/SingletonAsSpringBean.java)
* [SingletonsTest](src/test/java/learn/oop/springdp/springdp/singleton/SingletonsTest.java)

[Top](#spring-design-patterns)
