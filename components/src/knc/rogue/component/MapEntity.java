package knc.rogue.component;

import com.artemis.Component;

public class MapEntity extends Component {
    public MapType mapType;

    public void set(MapType mapType) {
        this.mapType = mapType;
    }

    public enum MapType {
        FOREST_1("Forest 1", "F:1"),
        FOREST_2("Forest 2", "F:2"),
        FOREST_3("Forest 3", "F:3"),
        FOREST_4("Forest 4", "F:4"),
        FOREST_5("Forest 5", "F:5"),
        FOREST_6("Forest 6", "F:6"),
        CAVES_1("Caves 1", "C:1"),
        CAVES_2("Caves 2", "C:2"),
        CAVES_3("Caves 3", "C:3"),
        RUINS_1("Ruins 1", "R:1"),
        RUINS_2("Ruins 2", "R:2"),
        RUINS_3("Ruins 3", "R:3"),
        RUINS_4("Ruins 4", "R:4"),
        RUINS_5("Ruins 5", "R:5");

        private String longName;
        private String shortName;

        MapType(String longName, String shortName) {
            this.longName = longName;
            this.shortName = shortName;
        }

        public String getLongName() {
            return longName;
        }

        public String getShortName() {
            return shortName;
        }
    }
}
