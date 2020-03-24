module jpdppp {
    requires javafx.graphics;
    requires javafx.controls;

    opens learn.oop.jpdppp.bank.gui to javafx.graphics;
    opens learn.oop.jpdppp.examples.composites.gui to javafx.graphics;
    opens learn.oop.jpdppp.examples.mvcjavafx to javafx.graphics;
}