package oop.acdpsp.ch10isp;

/** Fake transaction object imitation. */
public class TransactionScope implements AutoCloseable {
    /** Imitates commit of the transaction. */
    public void commit() {
        // empty body
    }

    /** Imitates closing this fake auto-closeable resource. */
    @Override
    public void close() {
        // empty body
    }
}
