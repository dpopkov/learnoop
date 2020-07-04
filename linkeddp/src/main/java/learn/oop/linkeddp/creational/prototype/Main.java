package learn.oop.linkeddp.creational.prototype;

public class Main {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.setAge(8);
        Person sally = new Person("Sally");
        rabbit.setOwner(sally);
        Rabbit rabbitCopy = rabbit.clone();
        sally.setName("Sally Brown");
        System.out.println("Age of 1st rabbit: " + rabbit.getAge());
        System.out.println("Age of 2nd rabbit: " + rabbitCopy.getAge());
        System.out.println("Owner of 1st rabbit: " + rabbit.getOwner());
        System.out.println("Owner of 2nd rabbit: " + rabbitCopy.getOwner());
    }
}
