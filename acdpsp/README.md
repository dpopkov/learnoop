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


### Chapter 5 - Testing

__Unit Testing__ - is the discipline of writing code hat tests other code. Unit tests are source code, thus they 
can be compiled and executed. As each unit test runs, it reports the test's success or failure. If all of the unit 
tests pass, the production code that they test is considered to be working, meeting its requirements.

When you unit test as early as possible in the process - that is, before you write any production code - you create
a safety net to catch any subsequent errors when you change code. If a unit test transitions from a passing state 
to a failing state, you know that the last change you made is responsible for breaking the code.


### Chapter 6 - Refactoring

#### Making Legacy Code Adaptive

__Legacy code is code without tests.__ (Michael Feathers, Working Effectively with Legacy Code)

Для создания safety net перед началом рефаткоринга сначала создаются _characterization tests_, то есть сохраненный
вывод соответствующий различным вариантам ввода. Когда _characterization tests_ готовы, то создается _Golden Master_
тест, который проверяет соответствие реального вывода SUT (System Under Test), тому выводу который сохранен в
_characterization tests_. Только после того как _Golden Master_ готов можно иметь минимальный уровень уверенности 
и можно приступать к рефакторингу кода не покрытого юнит тестами.


### Chapter 7 - The Single Responsibility Principle

Принцип SRP рекомендует псать код, который имеет одну и только одну причину для изменений. Если у класса более одной
причины меняться, это значит у него более одной ответственности. Классы с более чем одной ответственностью должны 
быть разбиты на меньшие классы, каждый из которых должен иметь только одну ответственность и причину для изменения.
   
Через процесс делегирования и абстракции класс имеющий слишком много причин для изменений должен делегировать одну 
или несколько ответственностей другим классам.
