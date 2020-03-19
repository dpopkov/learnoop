package learn.oop.jpdppp.bank.adapters;

/** Allows to see information for investigation. */
public interface FIAccountInfo {
    /** Returns balance in dollars. */
    int balance();
    boolean isForeign();
    /** Returns type of account: "deposit" or "loan". */
    String accountType();
}
