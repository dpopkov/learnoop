package learn.oop.acdpsp.ch04interf.adapter.objectadapter;

import learn.oop.acdpsp.ch04interf.adapter.Adaptee;
import learn.oop.acdpsp.ch04interf.adapter.ExpectedInterface;

public class Client {
    public static void main(String[] args) {
        ExpectedInterface adapter = new Adapter(new Adaptee());
        adapter.expectedMethod();
    }
}
