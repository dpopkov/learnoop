package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class WatcherView {
    private final Label label = new Label("The count has not yet changed");
    private final CheckBox isEven = new CheckBox("Value is now even");
    private final CheckBox isOdd = new CheckBox("Value is now odd");
    private final Pane root;

    public WatcherView(WatcherController controller) {
        root = createNodeHierarchy();
        controller.setView(this);
    }

    public Pane getRoot() {
        return root;
    }

    public void updateDisplay(String msg, boolean even, boolean odd) {
        label.setText(msg);
        isEven.setSelected(even);
        isOdd.setSelected(odd);
    }

    private Pane createNodeHierarchy() {
        isEven.setSelected(true);
        isOdd.setSelected(false);
        VBox pane = new VBox(8);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.getChildren().addAll(label, isEven, isOdd);
        return pane;
    }
}
