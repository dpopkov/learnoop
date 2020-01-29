package learn.oop.acdpsp.ch04interf.adapter.objectadapter;

import learn.oop.acdpsp.ch04interf.adapter.Adaptee;
import learn.oop.acdpsp.ch04interf.adapter.ExpectedInterface;

/**
 * The Object Adapter pattern uses composition to delegate from the methods of the interface
 * to those of a contained, encapsulated object.
 */
public class Adapter implements ExpectedInterface {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void expectedMethod() {
        adaptee.notExpectedMethod();
    }
}
