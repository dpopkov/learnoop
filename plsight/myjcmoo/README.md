### myjcmoo - Pluralsight. Making Your Java Code More Object-oriented.

#### Goals
* Detect where objects are missing
* Avoid branching around Booleans
* Remove null references
* Apply principles of object-oriented programming
* Encapsulate object's state
* Develop better coding style


#### Module 2 - Attaining Extensibility with Object-oriented Code

##### Two Fundamental Ideas

Encapsulation, Polymorphism, Inheritance are the consequences of these two ideas:
* Implicit `this` reference
* Dynamic dispatch

There is one v-table and one type descriptor per class. V-table contains pointers to methods
and type descriptor. 
All objects of the same class contain the same pointer value pointing to a v-table. 

##### What follows

A collection is an object.  
A missing object is also an object.  
Replace branching with polymorphic calls.  
Immutable objects. How to avoid bugs due to mutability.  
Avoid nulls. Null is not an object.  
Optional<T> type form Java 8.  No more nulls in business applications.  
  

`learn.oop.myjcmoo.p2.PutObjectWhereNotPossible` - Putting objects where it doesn't look possible


#### Module 3 - Rendering Branching over Boolean Flags Obsolete

