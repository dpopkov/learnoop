Modular Design
==============

[Rules of Design](Rules.md)

Versions of Banking demo
------------------------

1. Initial: All in one class - BankProgram
2. SRP: add Bank and Bank Client, Unit Testing
3. Add BankAccount
4. Encapsulation, The Most Qualified Class Rule, Dependency Injection:
  redistribute responsibilities Bank operations -> BankAccount, 
  instantiation -> BankProgram
5. Polymorphism, Interfaces: turn BankAccount into an interface, add 2 account types
6. Make interface BankAccount transparent adding method addInterest, implement Comparable
7. Abstract class: add AbstractBankAccount  
8. Turn concrete super class CheckingAccount into abstract, add RegularChecking,
   add SavedBankInfo
9. Use the Template Pattern in AbstractBankAccount 
10. Use the Strategy Pattern - use OwnerStrategy in AbstractBankAccount, 
                               use InputCommand in BankClient
11. Eliminate the Class Hierarchy - redesign the Template Method Pattern to the Strategy Pattern -
    add interface TypeStrategy
12. Use object caching - add enum Owners and InputCommands,
    encapsulate object creation - add AccountFactory.
13. Make abstract factory, add 3 concrete account factories, cache factory objects in interface AccountFactory.
14. Implement the factory objects as enum constants in AccountFactories, delete concrete factories.
15. Make Bank Iterable, add method stream().
16. Saving state as one object, make BankAccount Serializable, add FIAccountInfo, Loan, add adapters.
17. Add decorators: UnmodifiableAccount, UnmodifiableBankIterator, SuspiciousAccount, wrapper: BankAccountWrapper, 
                    LoanAuthorizer and its implementations, change method authorizeLoan in Bank.
18. Add interface BankObserver, enum BankEvent, add method notifyObservers to Bank. 
19. Implement MVC pattern - add InputController
