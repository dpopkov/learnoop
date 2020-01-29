package learn.oop.acdpsp.ch04interf.adapter.classadapter;

import learn.oop.acdpsp.ch04interf.adapter.ExpectedInterface;

public class Client {
    public static void main(String[] args) {
        ExpectedInterface dependency = new Adapter();
        dependency.expectedMethod();
    }
}
