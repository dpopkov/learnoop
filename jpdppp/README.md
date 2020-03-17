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
