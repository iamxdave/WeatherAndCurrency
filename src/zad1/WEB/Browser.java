package zad1.WEB;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import java.awt.*;

public class Browser extends JFXPanel {
    String url;

    public Browser() {
        Platform.runLater(this::loadPage);
    }

    public void setPage(String url) {
        this.url = url;
    }
    public void loadPage() {
        setPreferredSize(new Dimension(400, 700));
        WebView page = new WebView();
        page.getEngine().load(url);
        setScene(new Scene(page));
    }
}
