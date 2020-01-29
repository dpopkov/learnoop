package learn.oop.acdpsp.ch04interf.adapter.classadapter;

import learn.oop.acdpsp.ch04interf.adapter.Adaptee;
import learn.oop.acdpsp.ch04interf.adapter.ExpectedInterface;

/**
 * Implements the Adapter pattern.
 * It makes use of inheritance for the adapter - a subclass of the target class
 * needs to be adapted to fit the expected interface of clients.
 */
public class Adapter extends Adaptee implements ExpectedInterface {
    @Override
    public void expectedMethod() {
        notExpectedMethod();
    }
}
