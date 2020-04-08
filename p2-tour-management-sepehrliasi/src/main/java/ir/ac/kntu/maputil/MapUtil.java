package ir.ac.kntu.maputil;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public final class MapUtil {

    public static void showMap(String... places) {
        if (places == null || places.length == 0) {
            places = new String[1];
            places[0] = "Tehran";
        }
        var editedPlaces = Stream.of(places)
                .map(p -> p.replace(" ", "-"))
                .toArray();
        if (places.length == 2) {
            browse("https://www.google.com/maps/dir/" +
                    editedPlaces[0] + "/" + editedPlaces[1]);
        } else {
            browse("https://www.google.com/maps/place/" + editedPlaces[0]);
        }
    }

    private static void browse(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private MapUtil() {
    }
}