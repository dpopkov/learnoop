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
  