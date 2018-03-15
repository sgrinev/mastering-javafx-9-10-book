module chapterEleven {
    requires javafx.base;
    requires javafx.controls;

    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    opens chapterEleven to javafx.fxml;
    exports chapterEleven;
}
