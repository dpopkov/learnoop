package learn.oop.myjcmoo;

/**
 * <h3>Putting objects where it doesn't look possible</h3>
 *
 * Getting rid of 'if else branching'
 * Do not model a missing object with null.
 * Use an object of a class to model the missing object.
 */
public class P2PutObjectWhereNotPossible {

    /** Example of if-else branching code. */
    public void showItOld(String data) {
        String upper;
        if (data == null) {
            upper = null;
        } else {
            upper = data.toUpperCase();
        }
        System.out.println(upper);
    }

    /** Example of OOP code. */
    public void showItNew(MaybeString data) {
        MaybeString upper = data.toUpperCase();
        String toPrint = upper.orElse("");
        System.out.println(toPrint);
    }

    public static void main(String[] args) {
        P2PutObjectWhereNotPossible p = new P2PutObjectWhereNotPossible();
        p.showItOld("Usual String");
        p.showItNew(new MaybeString("Object that may be String"));
    }

    /** This class represents a String or nothing. */
    private static class MaybeString {

        private final String value;

        public MaybeString(String value) {
            this.value = value;
        }

        /** Returns upper case string if there is a string, or nothing otherwise. */
        public MaybeString toUpperCase() {
            return new MaybeString(value != null ? value.toUpperCase() : "");
        }

        /** Returns contained string or substitute value. */
        public String orElse(String substitute) {
            return value != null ? value : substitute;
        }
    }
}
